package br.com.salesiana.controller;

import br.com.salesiana.dao.DistrictDao;
import br.com.salesiana.entity.District;
import br.com.salesiana.entity.Municipality;

public class DistrictController {
    DistrictDao districtDao = new DistrictDao();

    public District create(String districtName, Municipality municipality){
        District district = districtDao.getDistrictFromNameAndMunicipality(districtName, municipality.getId());
        if(district == null) {
            district = new District(districtName, municipality);
            districtDao.save(district);
        }
        return district;
    }
}
