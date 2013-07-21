package com.github.theresajayne.tranquility.formbeans;

import com.github.theresajayne.tranquility.common.FormBean;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:30
 */
public class RegionFB extends FormBean {
    private Long regionID;
    private String regionName;
    private UniverseFB universeFB;

    public void setRegionName(String regionName) {
        this.regionName = regionName;
    }

    public String getRegionName() {
        return regionName;
    }

    public UniverseFB getUniverseFB() {
        return universeFB;
    }

    public void setUniverseFB(UniverseFB universeFB) {
        this.universeFB = universeFB;
    }

    public Long getRegionID() {
        return regionID;
    }

    public void setRegionID(Long regionID) {
        this.regionID = regionID;
    }
}
