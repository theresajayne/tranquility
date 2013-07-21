package com.github.theresajayne.tranquility.model.beans;

import org.junit.Test;

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
        systemVO.setSystemName("Wuos");
        assertEquals("Wuos",systemVO.getSystemName());
    }

    
}
