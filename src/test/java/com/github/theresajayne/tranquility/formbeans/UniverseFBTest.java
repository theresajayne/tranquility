package com.github.theresajayne.tranquility.formbeans;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;


/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/04/13
 * Time: 22:46
 */

public class UniverseFBTest {

    @Test
    public void canCreateAUniverse()
    {
        UniverseFB universeFB = new UniverseFB();
        assertNotNull(universeFB);
    }



    @Test
    public void a_universe_has_a_name()
    {
        UniverseFB universeFB = new UniverseFB();
        universeFB.setName("Eden");
        assertEquals("Eden", universeFB.getName());
    }

    @Test
    public void aUniverseHasRegions()
    {
        UniverseFB universeFB = new UniverseFB();
        RegionFB regionFB = new RegionFB();
        List<RegionFB> regionList = new ArrayList<RegionFB>();
        regionList.add(regionFB);
        universeFB.setRegions(regionList);
        assertEquals(regionList,universeFB.getRegions());

    }
}
