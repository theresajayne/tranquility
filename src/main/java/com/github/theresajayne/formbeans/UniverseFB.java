package com.github.theresajayne.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:33
 */
public class UniverseFB {
    private String name;
    private List<RegionFB> regions;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRegions(List<RegionFB> regions) {
        this.regions = regions;
    }

    public List<RegionFB> getRegions() {
        return regions;
    }
}
