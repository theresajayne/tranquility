package com.github.theresajayne.tranquility.model.beans;

import com.github.theresajayne.tranquility.common.ValueObject;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 17:18
 */
public class RegionVO extends ValueObject {
    private Long regionID;
    private String regionName;
    private UniverseVO universeVO;


    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public Long getRegionID() {
        return regionID;
    }

    public void setRegionID(Long regionID) {
        this.regionID = regionID;
    }

    public UniverseVO getUniverseVO() {
        return universeVO;
    }

    public void setUniverseVO(UniverseVO universeVO) {
        this.universeVO = universeVO;
    }
}
