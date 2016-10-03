package com.paulwoodiii;


import spark.ModelAndView;
import spark.Spark;
import spark.template.mustache.MustacheTemplateEngine;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
	// write your code here
        Spark.get(
                "/",
                (request, response) -> {
                    HashMap m = new HashMap();
                    m.put("name","paul");
                    return new ModelAndView(m,"home.html");
                },
                new MustacheTemplateEngine()
        );

        Spark.get(
                "/login",
                (req,res) -> {
                    return new ModelAndView(null,"login.html");
                },
                new MustacheTemplateEngine()
        );
        Spark.post(
                "/login",
                (req,res) -> {
                    res.redirect("/");
                   return null;
                }
        );

    }
}
