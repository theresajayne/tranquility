package com.github.theresajayne.model.beans;

import com.github.theresajayne.model.beans.RegionVO;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/04/13
 * Time: 22:49
 */
public class UniverseVO {
    private String name;
    private List<RegionVO> regions;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setRegions(List<RegionVO> regions) {
        this.regions = regions;
    }

    public List<RegionVO> getRegions() {
        return regions;
    }
}
