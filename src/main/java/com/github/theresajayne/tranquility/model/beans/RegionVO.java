package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 17:18
 */
public class RegionVO {
    private Long regionID;
    private String name;
    private UniverseVO universeVO;


    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
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
