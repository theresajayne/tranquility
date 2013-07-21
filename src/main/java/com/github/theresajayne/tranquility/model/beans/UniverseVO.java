package com.github.theresajayne.tranquility.model.beans;

import com.github.theresajayne.tranquility.common.ValueObject;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/04/13
 * Time: 22:49
 */
public class UniverseVO extends ValueObject {
    private Long universeID;
    private String universeName;



    public Long getUniverseID() {
        return universeID;
    }

    public void setUniverseID(Long universeID) {
        this.universeID = universeID;
    }

    public String getUniverseName() {
        return universeName;
    }

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }
}
