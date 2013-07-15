package com.github.theresajayne.tranquility.model.beans;

import com.github.theresajayne.tranquility.common.ValueObject;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Mark King
 * Date: 28/04/13
 * Time: 16:14
 */
public class UserVO extends ValueObject {
    private String name;
    private Long userID;
    private String password;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }


    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
