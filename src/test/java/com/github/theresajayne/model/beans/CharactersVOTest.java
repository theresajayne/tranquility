package com.github.theresajayne.model.beans;

import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Mark King
 * Date: 28/04/13
 * Time: 17:21
  */
public class CharactersVOTest {
    @Test
    public void canCreateACharacter(){
        CharacterVO characterVO = new CharacterVO();
        assertNotNull(characterVO);
    }
}
