package com.github.theresajayne.entities;

import org.junit.Test;

import static junit.framework.Assert.assertNotNull;

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
}
