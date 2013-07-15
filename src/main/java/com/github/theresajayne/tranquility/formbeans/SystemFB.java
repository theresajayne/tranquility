package com.github.theresajayne.tranquility.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:29
 */
public class SystemFB {
    private String name;
    private Long systemID;
    private ConstellationFB constellationFB;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getSystemID() {
        return systemID;
    }

    public void setSystemID(Long systemID) {
        this.systemID = systemID;
    }


    public ConstellationFB getConstellationFB() {
        return constellationFB;
    }

    public void setConstellationFB(ConstellationFB constellationFB) {
        this.constellationFB = constellationFB;
    }
}
