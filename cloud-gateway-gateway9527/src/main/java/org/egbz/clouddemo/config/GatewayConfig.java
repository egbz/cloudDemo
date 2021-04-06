package org.egbz.clouddemo.config;

import org.springframework.cloud.gateway.route.Route;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author egbz
 * @date 2021/4/6
 */
@Configuration
public class GatewayConfig {

    /**
     * 配置了一个id为path_route_0的路由规则,
     * 当访问地址 http://localhost:9527/guonei 时, 会自动转发到地址 http://news/baidu.com/guonei
     * @param routeLocatorBuilder
     * @return
     */
    @Bean
    public RouteLocator customRouteLocator0(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes =  routeLocatorBuilder.routes();

        routes.route("path_route_0",
                r -> r.path("/guonei").uri("http://news.baidu.com/guonei")).build();
        return routes.build();
    }

    @Bean
    public RouteLocator customRouteLocator1(RouteLocatorBuilder routeLocatorBuilder) {
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();
        routes.route("path_route_1", r -> r.path("/guoji").uri("http://news.baidu.com/guoji")).build();

        return routes.build();
    }
}
