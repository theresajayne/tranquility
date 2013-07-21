package com.github.theresajayne.tranquility.model.services;

import com.github.theresajayne.tranquility.formbeans.RegionFB;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 16/07/13
 * Time: 23:10
 */
public interface RegionService {
    List<RegionFB> getAllRegions();
    RegionFB getRegionById(Long regionID);
    RegionFB getRegionByName(String name);
    void saveRegion(RegionFB regionFB);
    void deleteRegion(RegionFB regionFB);
}
