package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mark King
 * Date: 28/04/13
 * Time: 16:14
 */
public class UserVO {
    private String name;
    private List<CharacterVO> characters;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setCharacters(List<CharacterVO> characters) {
        this.characters = characters;
    }

    public List<CharacterVO> getCharacters() {
        return characters;
    }
}
