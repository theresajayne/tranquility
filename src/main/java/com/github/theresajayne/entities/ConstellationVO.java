package com.github.theresajayne.entities;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:50
 * To change this template use File | Settings | File Templates.
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
