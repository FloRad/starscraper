package com.starsystems.main;

import static spark.Spark.get;
import static spark.Spark.port;
import static spark.Spark.staticFileLocation;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.starsystems.log.HerokuLogger;
import com.starsystems.model.Starsystem;
import com.starsystems.util.WebUtils;

import spark.ModelAndView;
import spark.template.velocity.VelocityTemplateEngine;

public class App {

	public static void main(String[] args) {

		HerokuLogger log = new HerokuLogger();
		WebUtils webUtils = new WebUtils();

		port(webUtils.getHerokuAssignedPort());
		staticFileLocation("/public");
		String layout = "templates/layout.vtl";

		Gson gson = new Gson();

		get("/", (request, response) -> {
			Map<String, String> model = new HashMap<String, String>();
			model.put("template", "templates/hello.vtl");
			model.put("homePageActive", "active");
			model.put("systemPageActive", "");
			model.put("planetPageActive", "");
			model.put("helloPageActive", "");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/system", (request, response) -> {
			Map<String, Object> model = new HashMap<String, Object>();
			model.put("template", "templates/system.vtl");

			model.put("homePageActive", "");
			model.put("systemPageActive", "active");
			model.put("planetPageActive", "");
			model.put("helloPageActive", "");

			Starsystem system = new StarsystemGenerator().generateSystem();
			log.info(gson.toJson(system));
			if (system.getNumberOfPlanets() == 0) {
				model.put("noplanets", "No planets");
			} else {
				model.put("noplanets", "");
			}
			model.put("starsystem", system);
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/planet", (request, response) -> {
			Map<String, String> model = new HashMap<String, String>();
			model.put("template", "templates/planet.vtl");
			model.put("planet", "Test");
			model.put("homePageActive", "");
			model.put("systemPageActive", "");
			model.put("planetPageActive", "active");
			model.put("helloPageActive", "");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());

		get("/hello", (request, response) -> {
			Map<String, String> model = new HashMap<String, String>();
			model.put("template", "templates/hello.vtl");
			model.put("homePageActive", "");
			model.put("systemPageActive", "");
			model.put("planetPageActive", "");
			model.put("helloPageActive", "active");
			return new ModelAndView(model, layout);
		}, new VelocityTemplateEngine());
	}

}
