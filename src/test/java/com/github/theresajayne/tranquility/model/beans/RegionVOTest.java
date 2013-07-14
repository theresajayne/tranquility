package com.github.theresajayne.tranquility.model.beans;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:41
 */
public class RegionVOTest {

    @Test
    public void canCreateARegion()
    {
        RegionVO regionVO = new RegionVO();
        assertNotNull(regionVO);

    }

    @Test
    public void aRegionHasAName()
    {
        RegionVO regionVO = new RegionVO();
        regionVO.setName("The Forge");
        assertEquals("The Forge",regionVO.getName());
    }

    @Test
    public void RegionHasConstellations()
    {
        RegionVO regionVO = new RegionVO();
        ConstellationVO constellationVO = new ConstellationVO();
        List<ConstellationVO> constellationList = new ArrayList<ConstellationVO>();
        constellationList.add(constellationVO);
        regionVO.setConstellations(constellationList);
        assertEquals(constellationList,regionVO.getConstellations());
    }
}
