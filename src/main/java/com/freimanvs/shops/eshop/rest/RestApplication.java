package com.freimanvs.shops.eshop.rest;

import com.freimanvs.shops.eshop.rest.exception.MyExceptionMapper;
import com.freimanvs.shops.eshop.rest.exception.RuntimeExceptionMapper;

import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;
import java.util.Set;

@ApplicationPath("/api")
public class RestApplication extends Application {
    public RestApplication() {
    }

    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        addExceptionMapperClasses(resources);

        // enable Swagger
        addSwaggerClasses(resources);

        return resources;
    }

    private void addSwaggerClasses(Set<Class<?>> resources) {
        resources.add(io.swagger.jaxrs.listing.ApiListingResource.class);
        resources.add(io.swagger.jaxrs.listing.SwaggerSerializers.class);
    }

    private void addExceptionMapperClasses(Set<Class<?>> resources) {
        resources.add(MyExceptionMapper.class);
        resources.add(RuntimeExceptionMapper.class);
    }

    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(GoodsRest.class);
        resources.add(RoleRest.class);
        resources.add(OrderRest.class);
        resources.add(UserRest.class);
    }
}
