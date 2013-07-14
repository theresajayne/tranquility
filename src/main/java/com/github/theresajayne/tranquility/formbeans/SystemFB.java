package com.github.theresajayne.tranquility.formbeans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 19:29
 */
public class SystemFB {
    private String name;
    private List<PlanetFB> planets;
    private List<AsteroidBeltFB> asteroidBelts;
    private List<StationFB> stations;
    private List<CollidableObjectFB> collidableObjects;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setPlanets(List<PlanetFB> planets) {
        this.planets = planets;
    }

    public List<PlanetFB> getPlanets() {
        return planets;
    }

    public void setAsteroidBelts(List<AsteroidBeltFB> asteroidBelts) {
        this.asteroidBelts = asteroidBelts;
    }

    public List<AsteroidBeltFB> getAsteroidBelts() {
        return asteroidBelts;
    }

    public void setStations(List<StationFB> stations) {
        this.stations = stations;
    }

    public List<StationFB> getStations() {
        return stations;
    }

    public void setCollidableObjects(List<CollidableObjectFB> collidableObjects) {
        this.collidableObjects = collidableObjects;
    }

    public List<CollidableObjectFB> getCollidableObjects() {
        return collidableObjects;
    }
}
