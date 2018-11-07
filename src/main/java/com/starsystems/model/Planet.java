package com.starsystems.model;

public class Planet implements Comparable<Planet> {

	private String name;
	private int position;
	private String condition;

	public Planet(String name, int position) {
		this.name = name;
		this.position = position;
	}

	@Override
	public int compareTo(Planet comparePlanet) {
		int comparePos = ((Planet) comparePlanet).getPosition();

		/* For Ascending order */
		return this.position - comparePos;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getPosition() {
		return position;
	}

	public void setPosition(int position) {
		this.position = position;
	}

	public String getCondition() {
		return condition;
	}

	public void setCondition(String condition) {
		this.condition = condition;
	}

}
