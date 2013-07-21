package com.github.theresajayne.tranquility.formbeans;

import com.github.theresajayne.tranquility.common.FormBean;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:29
 */
public class SystemFB extends FormBean {
    private String systemName;
    private Long systemID;
    private ConstellationFB constellationFB;

    public void setSystemName(String systemName) {
        this.systemName = systemName;
    }

    public String getSystemName() {
        return systemName;
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
