package com.github.theresajayne.tranquility.model.beans;

import com.github.theresajayne.tranquility.common.ValueObject;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:50
 */
public class ConstellationVO extends ValueObject {
    private Long constellationID;
    private String constellationName;
    private RegionVO regionVO;

    public void setConstellationName(String constellationName) {
        this.constellationName = constellationName;
    }

    public String getConstellationName() {
        return constellationName;
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
