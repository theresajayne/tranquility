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
 * Time: 1607
 */
public class UserVOTest {
    @Test
    public void canCreateAUser() {
        UserVO userVO = new UserVO();
        assertNotNull(userVO);
    }

    @Test
    public void userHasAName() {
        UserVO userVO = new UserVO();
        userVO.setName("Mark King");
        assertEquals("Mark King", userVO.getName());
    }

    @Test
    public void userHasCharacters() {
        UserVO userVO = new UserVO();
        CharacterVO characterVO = new CharacterVO();
        List<CharacterVO> characterList = new ArrayList<CharacterVO>();
        characterList.add(characterVO);
        userVO.setCharacters(characterList);
        assertEquals(characterList, userVO.getCharacters());
    }

}