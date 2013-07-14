package com.github.theresajayne.tranquility.model.beans;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Mark King
 * Date: 28/04/13
 * Time: 17:21
 */
public class CharactersVOTest {
    @Test
    public void canCreateACharacter() {
        CharacterVO characterVO = new CharacterVO();
        assertNotNull(characterVO);
    }

    @Test
    public void characterHasAName() {
        CharacterVO characterVO = new CharacterVO();
        characterVO.setName("Worf");
        assertEquals("Worf", characterVO.getName());
    }

    @Test
    public void characterHasShips(){
        CharacterVO characterVO = new CharacterVO();
        ShipVO shipVO = new ShipVO();
        List<ShipVO> shipList = new ArrayList<ShipVO>();
        shipList.add(shipVO);
        characterVO.setShips(shipList);
        assertEquals(shipList,characterVO.getShips());
    }
}
