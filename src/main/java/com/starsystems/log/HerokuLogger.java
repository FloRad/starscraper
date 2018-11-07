package com.starsystems.log;

public class HerokuLogger {

	public void info(String message) {
		System.out.println("INFO - " + message);
	}

	public void debug(String message) {
		System.out.println("DEBUG - " + message);
	}

	public void warning(String message) {
		System.out.println("DEBUG - " + message);
	}

	public void error(String message) {
		System.out.println("ERROR - " + message);
	}

	public void fatal(String message) {
		System.out.println("FATAL - " + message);
	}
}