package com.github.theresajayne.tranquility.formbeans;

import com.github.theresajayne.tranquility.common.FormBean;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:28
 */
public class ConstellationFB extends FormBean {
    private Long constellationID;
    private String constellationName;
    private RegionFB regionFB;

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

    public RegionFB getRegionFB() {
        return regionFB;
    }

    public void setRegionFB(RegionFB regionFB) {
        this.regionFB = regionFB;
    }
}
