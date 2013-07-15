package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:50
 */
public class ConstellationVO {
    private Long constellationID;
    private String name;
    private RegionVO regionVO;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getConstellationID() {
        return constellationID;
    }

    public void setConstellationID(Long constellationID) {
        this.constellationID = constellationID;
    }

    public RegionVO getRegionVO() {
        return regionVO;
    }

    public void setRegionVO(RegionVO regionVO) {
        this.regionVO = regionVO;
    }
}
