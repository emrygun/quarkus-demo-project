package com.emrygun.quickstart;

import io.quarkus.vertx.http.runtime.filters.Filters;
import io.quarkus.vertx.web.Route;
import io.vertx.core.http.HttpMethod;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.event.Observes;

@ApplicationScoped
public class ApplicationRoutes {

    public void routes(@Observes Router router) {
        router
                .get("/ok")
                .handler(rc -> rc.response().end("Ok from RouteContext HttpServletResponse"));
    }

    public void filter(@Observes Filters filters) {
        filters
                .register(rc -> {
                    rc.response()
                            .putHeader("V-Header", "Header added by Vert.x filter.");
                    rc.next();
                }, 10);
    }

    @Route(path = "/declarative-ok", methods = HttpMethod.GET)
    public void declarativeOkRoute(RoutingContext routingContext) {
        routingContext.response().end("Ok from RouteContext HttpServletResponse");
    }


}
