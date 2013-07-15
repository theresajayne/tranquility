package com.github.theresajayne.tranquility.formbeans;

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
public class SystemFBTest {

    @Test
    public void canCreateASystem()
    {
        SystemFB systemFB = new SystemFB();
        assertNotNull(systemFB);

    }

    @Test
    public void aSystemHasAName()
    {
        SystemFB systemFB = new SystemFB();
        systemFB.setName("Wuos");
        assertEquals("Wuos",systemFB.getName());
    }


    
}
