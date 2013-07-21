package com.github.theresajayne.tranquility.model.beans;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNotNull;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:51

 */
public class ConstellationVOTest {
    @Test
    public void canCreateAConstellation()
    {
        ConstellationVO constellationVO = new ConstellationVO();
        assertNotNull(constellationVO);
    }

    @Test
    public void constellationHasAName()
    {
        ConstellationVO constellationVO = new ConstellationVO();
        constellationVO.setConstellationName("Geminate");
        assertEquals("Geminate", constellationVO.getConstellationName());
    }


}
