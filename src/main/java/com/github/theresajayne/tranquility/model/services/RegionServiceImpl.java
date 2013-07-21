package com.github.theresajayne.tranquility.model.services;

import com.github.theresajayne.tranquility.common.Converter;
import com.github.theresajayne.tranquility.formbeans.RegionFB;
import com.github.theresajayne.tranquility.model.beans.RegionVO;
import com.github.theresajayne.tranquility.model.dao.RegionDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 16/07/13
 * Time: 23:12
 */
@Service
public class RegionServiceImpl implements RegionService {
    @Autowired
    private Converter converter;

    @Autowired
    private RegionDao regionDao;
    
    @Override
    public List<RegionFB> getAllRegions() {
        List<RegionVO> regionVOList =regionDao.getAllRegions();
        List<RegionFB> regionFBList = new ArrayList<RegionFB>();
        for(RegionVO regionVO : regionVOList)
        {
            RegionFB fb = (RegionFB)converter.toFormBean(regionVO);
            regionFBList.add(fb);
        }
        return regionFBList;
    }

    @Override
    public RegionFB getRegionById(Long regionID) {
        return (RegionFB)converter.toFormBean(regionDao.getRegionByID(regionID));
    }

    @Override
    public RegionFB getRegionByName(String name) {
        return (RegionFB)converter.toFormBean(regionDao.getRegionByName(name));
    }

    @Override
    public void saveRegion(RegionFB regionFB) {
        RegionVO regionVO = (RegionVO)converter.toValueObject(regionFB);
        regionDao.saveRegion(regionVO);
    }

    @Override
    public void deleteRegion(RegionFB regionFB) {
        //To change body of implemented methods use File | Settings | File Templates.
    }
}
