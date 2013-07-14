package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 17:18
 */
public class RegionVO {
    private String name;
    private List<ConstellationVO> constellations;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setConstellations(List<ConstellationVO> constellations) {
        this.constellations = constellations;
    }

    public List<ConstellationVO> getConstellations() {
        return constellations;
    }
}
