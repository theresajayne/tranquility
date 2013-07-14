package com.github.theresajayne.tranquility.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:28
 */
public class ConstellationFB {
    private String name;
    private List<SystemFB> systems;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setSystems(List<SystemFB> systems) {
        this.systems = systems;
    }

    public List<SystemFB> getSystems() {
        return systems;
    }
}
