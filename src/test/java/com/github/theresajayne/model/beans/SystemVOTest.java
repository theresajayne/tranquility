package com.github.theresajayne.model.beans;

import com.github.theresajayne.model.beans.*;
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

    @Test
    public void aSystemHasPlanets()
    {
        SystemVO systemVO = new SystemVO();
        PlanetVO planetVO = new PlanetVO();
        List<PlanetVO> planetList = new ArrayList<PlanetVO>();
        planetList.add(planetVO);
        systemVO.setPlanets(planetList);
        TestCase.assertEquals(planetList,systemVO.getPlanets());
    }

    @Test
    public void aSystemHasAsteroidBelts()
    {
        SystemVO systemVO = new SystemVO();
        AsteroidBeltVO asteroidBeltVO = new AsteroidBeltVO();
        List<AsteroidBeltVO> asteroidList = new ArrayList<AsteroidBeltVO>();
        asteroidList.add(asteroidBeltVO);
        systemVO.setAsteroidBelts(asteroidList);
        TestCase.assertEquals(asteroidList,systemVO.getAsteroidBelts());

    }

    @Test
    public void aSystemHasStations()
    {
        SystemVO systemVO = new SystemVO();
        StationVO StationVO = new StationVO();
        List<StationVO> asteroidList = new ArrayList<StationVO>();
        asteroidList.add(StationVO);
        systemVO.setStations(asteroidList);
        TestCase.assertEquals(asteroidList,systemVO.getStations());

    }

    @Test
    public void aSystemHasCollidableObjects()
    {
        SystemVO systemVO = new SystemVO();
        CollidableObjectVO CollidableObjectVO = new CollidableObjectVO();
        List<CollidableObjectVO> asteroidList = new ArrayList<CollidableObjectVO>();
        asteroidList.add(CollidableObjectVO);
        systemVO.setCollidableObjects(asteroidList);
        TestCase.assertEquals(asteroidList,systemVO.getCollidableObjects());

    }    
    
}
