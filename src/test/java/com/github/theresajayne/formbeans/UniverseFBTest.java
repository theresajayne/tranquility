package com.github.theresajayne.formbeans;

import com.github.theresajayne.model.beans.RegionVO;
import com.github.theresajayne.model.beans.UniverseVO;
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
        UniverseVO universeVO = new UniverseVO();
        assertNotNull(universeVO);
    }



    @Test
    public void a_universe_has_a_name()
    {
        UniverseVO universeVO = new UniverseVO();
        universeVO.setName("Eden");
        assertEquals("Eden", universeVO.getName());
    }

    @Test
    public void aUniverseHasRegions()
    {
        UniverseVO universeVO = new UniverseVO();
        RegionVO regionVO = new RegionVO();
        List<RegionVO> regionList = new ArrayList<RegionVO>();
        regionList.add(regionVO);
        universeVO.setRegions(regionList);
        assertEquals(regionList,universeVO.getRegions());

    }
}
