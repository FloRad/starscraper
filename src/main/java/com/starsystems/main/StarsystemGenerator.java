package com.starsystems.main;

import java.util.Collections;
import java.util.Iterator;
import java.util.Random;

import com.starsystems.log.HerokuLogger;
import com.starsystems.model.Planet;
import com.starsystems.model.Starsystem;

public class StarsystemGenerator {

	HerokuLogger log = new HerokuLogger();

	public Starsystem generateSystem() {

		Starsystem system = new Starsystem("Hubba Bubba");

		// determine number of planets

		log.debug("Generating planets...");

		int number = randomInt(1, 6);

		switch (number) {
		case 1:
			system.setNumberOfPlanets(0);
			break;
		case 2:
			system.setNumberOfPlanets(randomInt(1, 4));
			break;
		case 3:
			system.setNumberOfPlanets(randomInt(1, 6));
			break;
		case 4:
			system.setNumberOfPlanets(randomInt(1, 8));
			break;
		case 5:
			system.setNumberOfPlanets(randomInt(1, 10));
			break;
		case 6:
			system.setNumberOfPlanets(randomInt(1, 12));
			break;
		default:
			break;
		}

		log.debug("Generated " + system.getNumberOfPlanets() + " planets");

		// Add random planets
		for (int i = 0; i < system.getNumberOfPlanets(); i++) {
			int random = randomInt(1, 6);
			Planet planet = new Planet("Planet #" + i, random);
			switch (random) {
			case 1:
				planet.setCondition("Burnt");
				break;
			case 2:
				planet.setCondition("Over-cooked");
				break;
			case 3:
				planet.setCondition("Golden");
				break;
			case 4:
				planet.setCondition("Under-cooked");
				break;
			case 5:
				planet.setCondition("Frozen");
				break;
			case 6:
				createVariableConditionPlanet(planet);
				break;
			default:
				break;
			}
			system.getPlanets().add(planet);
		}

		Collections.sort(system.getPlanets());
		
		for (int i = 0; i < system.getPlanets().size(); i++) {
			int planetPos = i+1;
			system.getPlanets().get(i).setName("Planet #" + planetPos);
		}
		

		return system;
	}

	private void createVariableConditionPlanet(Planet planet) {

		StringBuilder builder = new StringBuilder();
		int random;
		int usedRandom;

		usedRandom = randomInt(1, 5);

		switch (usedRandom) {
		case 1:
			usedRandom = 1;
			builder.append("Burnt/");
			break;
		case 2:
			usedRandom = 2;
			builder.append("Over-cooked/");
			break;
		case 3:
			usedRandom = 3;
			builder.append("Golden/");
			break;
		case 4:
			usedRandom = 4;
			builder.append("Under-cooked/");
			break;
		case 5:
			usedRandom = 5;
			builder.append("Frozen/");
			break;
		}

		do {
			random = randomInt(1, 5);
		} while (random == usedRandom);

		switch (random) {
		case 1:
			builder.append("Burnt");
			break;
		case 2:
			builder.append("Over-cooked");
			break;
		case 3:
			builder.append("Golden");
			break;
		case 4:
			builder.append("Under-cooked");
			break;
		case 5:
			builder.append("Frozen");
			break;
		}
		
		
		planet.setCondition(builder.toString());
		planet.setPosition((random + usedRandom) / 2);
	}

	public int randomInt(int min, int max) {
		if (min > max) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		int randomNumber = new Random().nextInt((max - min) + 1) + min;

		return randomNumber;
	}

}
