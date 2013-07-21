package com.github.theresajayne.tranquility.model.beans;

import org.junit.Test;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertEquals;


/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 21/04/13
 * Time: 22:46
 */

public class UniverseVOTest {

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
        universeVO.setUniverseName("Eden");
        assertEquals("Eden", universeVO.getUniverseName());
    }

}
