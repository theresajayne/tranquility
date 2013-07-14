package com.github.theresajayne.tranquility.model.beans;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: Theresa
 * Date: 27/04/13
 * Time: 18:58
 */
public class SystemVO {
    private String name;
    private List<PlanetVO> planets;
    private List<AsteroidBeltVO> asteroidBelts;
    private List<StationVO> stations;
    private List<CollidableObjectVO> collidableObjects;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setPlanets(List<PlanetVO> planets) {
        this.planets = planets;
    }

    public List<PlanetVO> getPlanets() {
        return planets;
    }

    public void setAsteroidBelts(List<AsteroidBeltVO> asteroidBelts) {
        this.asteroidBelts = asteroidBelts;
    }

    public List<AsteroidBeltVO> getAsteroidBelts() {
        return asteroidBelts;
    }

    public void setStations(List<StationVO> stations) {
        this.stations = stations;
    }

    public List<StationVO> getStations() {
        return stations;
    }

    public void setCollidableObjects(List<CollidableObjectVO> collidableObjects) {
        this.collidableObjects = collidableObjects;
    }

    public List<CollidableObjectVO> getCollidableObjects() {
        return collidableObjects;
    }
}
