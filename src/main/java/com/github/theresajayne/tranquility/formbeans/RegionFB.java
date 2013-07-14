package com.github.theresajayne.tranquility.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:30
 */
public class RegionFB {
    private String name;
    private List<ConstellationFB> constellations;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setConstellations(List<ConstellationFB> constellations) {
        this.constellations = constellations;
    }

    public List<ConstellationFB> getConstellations() {
        return constellations;
    }
}
