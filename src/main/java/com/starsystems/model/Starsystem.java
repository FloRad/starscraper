package com.starsystems.model;

import java.util.ArrayList;
import java.util.List;

public class Starsystem {

	private String name;
	private ArrayList<Planet> planets;
	private String systemType;
	private int numberOfPlanets;

	public Starsystem(String pName) {
		this.name = pName;
		planets = new ArrayList<Planet>();
	}

	public String getName() {
		return name;
	}

	public List<Planet> getPlanets() {
		return planets;
	}

	public String getSystemType() {
		return systemType;
	}

	public void setSystemType(String systemType) {
		this.systemType = systemType;
	}

	public int getNumberOfPlanets() {
		return numberOfPlanets;
	}

	public void setNumberOfPlanets(int numberOfPlanets) {
		this.numberOfPlanets = numberOfPlanets;
	}

}
