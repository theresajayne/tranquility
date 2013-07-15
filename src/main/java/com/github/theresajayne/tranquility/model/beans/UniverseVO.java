package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/04/13
 * Time: 22:49
 */
public class UniverseVO {
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
