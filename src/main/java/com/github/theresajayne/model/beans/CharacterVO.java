package com.github.theresajayne.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mark King
 * Date: 28/04/13
 * Time: 17:12
 */
public class CharacterVO {
    private String name;
    private List<ShipVO> ships;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setShips(List<ShipVO> ships) {
        this.ships = ships;
    }

    public List<ShipVO> getShips() {
        return ships;
    }
}
