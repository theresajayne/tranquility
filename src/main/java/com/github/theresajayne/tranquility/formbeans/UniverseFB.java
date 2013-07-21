package com.github.theresajayne.tranquility.formbeans;

import com.github.theresajayne.tranquility.common.FormBean;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:33
 */
public class UniverseFB  extends FormBean {
    private Long universeID;
    private String universeName;

    public void setUniverseName(String universeName) {
        this.universeName = universeName;
    }

    public String getUniverseName() {
        return universeName;
    }

    public Long getUniverseID() {
        return universeID;
    }

    public void setUniverseID(Long universeID) {
        this.universeID = universeID;
    }
}
