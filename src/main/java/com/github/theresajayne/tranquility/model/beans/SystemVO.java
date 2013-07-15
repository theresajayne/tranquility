package com.github.theresajayne.tranquility.model.beans;

import com.github.theresajayne.tranquility.common.ValueObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:58
 */
public class SystemVO extends ValueObject {
    private String name;
    private Long systemID;
    private ConstellationVO constellationVO;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }


    public Long getSystemID() {
        return systemID;
    }

    public void setSystemID(Long systemID) {
        this.systemID = systemID;
    }

    public ConstellationVO getConstellationVO() {
        return constellationVO;
    }

    public void setConstellationVO(ConstellationVO constellationVO) {
        this.constellationVO = constellationVO;
    }
}
