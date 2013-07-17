package com.github.theresajayne.tranquility.model.dao;

import com.github.theresajayne.tranquility.model.beans.RegionVO;
import com.github.theresajayne.tranquility.model.beans.UniverseVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 16/07/13
 * Time: 22:54
 */
public interface RegionDao {
    List<RegionVO> getAllRegions();
    List<RegionVO> getAllRegionsInUniverse(UniverseVO universeVO);
    RegionVO getRegionByID(Long regionID);
    RegionVO getRegionByName(String name);
    void saveRegion(RegionVO regionVO);
}
