package br.com.salesiana.controller;

import br.com.salesiana.dao.*;
import br.com.salesiana.entity.*;


import java.time.LocalDate;

public class ControladorDeEmpresas {

    private UnidadeFederativaDao unidadeFederativaDao;
    private MunicipioDao municipioDao;
    private BairroDao bairroDao;
    private EmpresaDao empresaDao;
    private FiscalizacaoDao fiscalizacaoDao;

    public ControladorDeEmpresas() {
        this.unidadeFederativaDao = new UnidadeFederativaDao();
        this.municipioDao = new MunicipioDao();
        this.bairroDao = new BairroDao();
        this.empresaDao = new EmpresaDao();
        this.fiscalizacaoDao = new FiscalizacaoDao();
    }


    public Fiscalizacao createFiscalization(String[] items) throws Exception {
        try {
            String mesEAno = items[1];
            LocalDate data = LocalDate.parse(mesEAno.replace("/", "-") + "-01");
            String cnpj = items[2];
            String razaoSocial = items[3];
            String logradouro = items[4];
            String cep = items[5];
            String nomeBairro = items[6];
            String nomeMunicipio = items[7];
            String nomeUnidadeFederativa = items[8].trim();

            UnidadeFederativa unidadeFederativa = unidadeFederativaDao.getByName(nomeUnidadeFederativa);

            Municipio municipio = municipioDao.getByNameAndFederatedUnit(nomeMunicipio, unidadeFederativa.getId());
            if (municipio == null) {
                municipio = new Municipio(nomeMunicipio, unidadeFederativa);
                municipioDao.save(municipio);
            }

            Bairro bairro = bairroDao.getDistrictFromNameAndMunicipality(nomeBairro, municipio.getId());
            if (bairro == null) {
                bairro = new Bairro(nomeBairro, municipio);
                bairroDao.save(bairro);
            }

            Empresa empresa = empresaDao.getCompanyFromCnpj(cnpj);
            if (empresa == null) {
                empresa = new Empresa(cnpj, razaoSocial);
                empresaDao.save(empresa);
            }

            Fiscalizacao fiscalizacao = fiscalizacaoDao.getFiscalizationFromDateAndPostalCodeAndPublicPlace(data, cep, logradouro);
            if (fiscalizacao == null) {
                fiscalizacao = new Fiscalizacao(
                        data,
                        logradouro,
                        cep,
                        empresa,
                        bairro,
                        municipio,
                        unidadeFederativa
                );
                fiscalizacaoDao.save(fiscalizacao);
            }

            return new Fiscalizacao();
        } catch (Exception err) {
            System.out.println(err.getMessage());
        }

        return null;
    }
}