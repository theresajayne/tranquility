package com.github.theresajayne.tranquility.model.beans;

import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:59
 */
public class SystemVOTest {

    @Test
    public void canCreateASystem()
    {
        SystemVO systemVO = new SystemVO();
        assertNotNull(systemVO);

    }

    @Test
    public void aSystemHasAName()
    {
        SystemVO systemVO = new SystemVO();
        systemVO.setName("Wuos");
        assertEquals("Wuos",systemVO.getName());
    }

    
}
