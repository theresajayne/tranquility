package com.github.theresajayne.tranquility.formbeans;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:51

 */
public class ConstellationFBTest {
    @Test
    public void canCreateAConstellation()
    {
        ConstellationFB constellationFB = new ConstellationFB();
        assertNotNull(constellationFB);
    }

    @Test
    public void constellationHasAName()
    {
        ConstellationFB constellationFB = new ConstellationFB();
        constellationFB.setName("Geminate");
        assertEquals("Geminate", constellationFB.getName());
    }
    @Test
    public void constellationHasRegion()
    {
        ConstellationFB constellationFB = new ConstellationFB();
        RegionFB regionFB = new RegionFB();
        constellationFB.setRegionFB(regionFB);
        assertEquals(regionFB, constellationFB.getRegionFB());
    }
}
