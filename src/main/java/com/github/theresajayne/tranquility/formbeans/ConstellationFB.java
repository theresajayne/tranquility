package com.github.theresajayne.tranquility.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:28
 */
public class ConstellationFB {
    private Long constellationID;
    private String name;
    private RegionFB regionFB;

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

    public RegionFB getRegionFB() {
        return regionFB;
    }

    public void setRegionFB(RegionFB regionFB) {
        this.regionFB = regionFB;
    }
}
