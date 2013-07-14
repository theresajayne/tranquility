package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:50
 */
public class ConstellationVO {
    private String name;
    private List<SystemVO> systems;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSystems(List<SystemVO> systems) {
        this.systems = systems;
    }

    public List<SystemVO> getSystems() {
        return systems;
    }
}