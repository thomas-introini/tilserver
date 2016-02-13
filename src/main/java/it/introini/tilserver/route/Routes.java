package it.introini.tilserver.route;

import it.introini.tilserver.handler.NewHandler;
import it.introini.tilserver.handler.RootHandler;
import javaslang.Tuple;
import javaslang.Tuple2;
import spark.template.mustache.MustacheTemplateEngine;

import javax.inject.Inject;

import static spark.Spark.get;
import static spark.Spark.post;

/**
 * Created by thomas on 13/02/16.
 */
public class Routes {
    public static final Tuple2<String,String> rootTuple  = Tuple.of("/","root.mustache");
    public static final Tuple2<String,String> newTuple   = Tuple.of("/new","new.mustache");
    public static final String errView                   = "err.mustache";

    @Inject RootHandler  rootHandler;
    @Inject NewHandler   newHandler;

    public void initRoutes(){
        get(rootTuple._1,rootHandler,new MustacheTemplateEngine());

        get(newTuple._1,newHandler,new MustacheTemplateEngine());
        post(newTuple._1,newHandler,new MustacheTemplateEngine());
    }
}
