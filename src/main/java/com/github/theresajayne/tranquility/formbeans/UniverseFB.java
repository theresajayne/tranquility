package com.github.theresajayne.tranquility.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:33
 */
public class UniverseFB {
    private Long universeID;
    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Long getUniverseID() {
        return universeID;
    }

    public void setUniverseID(Long universeID) {
        this.universeID = universeID;
    }
}
