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

    @Test
    public void aSystemHasPlanets()
    {
        SystemFB systemFB = new SystemFB();
        PlanetFB planetFB = new PlanetFB();
        List<PlanetFB> planetList = new ArrayList<PlanetFB>();
        planetList.add(planetFB);
        systemFB.setPlanets(planetList);
        TestCase.assertEquals(planetList,systemFB.getPlanets());
    }

    @Test
    public void aSystemHasAsteroidBelts()
    {
        SystemFB systemFB = new SystemFB();
        AsteroidBeltFB asteroidBeltFB = new AsteroidBeltFB();
        List<AsteroidBeltFB> asteroidList = new ArrayList<AsteroidBeltFB>();
        asteroidList.add(asteroidBeltFB);
        systemFB.setAsteroidBelts(asteroidList);
        TestCase.assertEquals(asteroidList,systemFB.getAsteroidBelts());

    }

    @Test
    public void aSystemHasStations()
    {
        SystemFB systemFB = new SystemFB();
        StationFB StationFB = new StationFB();
        List<StationFB> asteroidList = new ArrayList<StationFB>();
        asteroidList.add(StationFB);
        systemFB.setStations(asteroidList);
        TestCase.assertEquals(asteroidList,systemFB.getStations());

    }

    @Test
    public void aSystemHasCollidableObjects()
    {
        SystemFB systemFB = new SystemFB();
        CollidableObjectFB CollidableObjectFB = new CollidableObjectFB();
        List<CollidableObjectFB> asteroidList = new ArrayList<CollidableObjectFB>();
        asteroidList.add(CollidableObjectFB);
        systemFB.setCollidableObjects(asteroidList);
        TestCase.assertEquals(asteroidList,systemFB.getCollidableObjects());

    }    
    
}
