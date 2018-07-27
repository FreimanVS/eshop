package com.freimanvs.shops.eshop.rest;

import com.freimanvs.shops.eshop.dao.interfaces.GoodsDAO;
import com.freimanvs.shops.eshop.dao.interfaces.RoleDAO;
import com.freimanvs.shops.eshop.entities.Goods;
import com.freimanvs.shops.eshop.entities.Role;
import com.freimanvs.shops.eshop.rest.interceptors.NotFoundInterceptor;
import com.freimanvs.shops.eshop.rest.interfaces.RestCrud;
import io.swagger.annotations.*;

import javax.ejb.EJB;
import javax.interceptor.Interceptors;
import javax.ws.rs.*;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import java.util.List;

@SwaggerDefinition(
        info = @Info(
                title = "Roles Resource Swagger-generated API",
                description = "Roles Resource Description example",
                version = "1.0.0",
                termsOfService = "share and care",
                contact = @Contact(
                        name = "name", email = "mail@mail.com",
                        url = "http://www.url.com"),
                license = @License(
                        name = "Apache 2.0",
                        url = "http://www.apache.org")),
        tags = {
                @Tag(name = "Roles Resource Swagger-generated API",
                        description = "Description Example")
        },
        basePath = "/eshop/api",
        schemes = {SwaggerDefinition.Scheme.HTTP},
        externalDocs = @ExternalDocs(
                value = "Developing a Swagger-enabled REST API using WebSphere Developer Tools",
                url = "https://tinyurl.com/swagger-wlp"))
@Api(tags = "Roles Resource Swagger-generated API", produces = MediaType.APPLICATION_JSON)

@Path("/v1/roles")
public class RoleResource implements RestCrud<Role> {

    @EJB
    private RoleDAO roleDAO;

    @Context
    private UriInfo info;

    @ApiOperation(value = "Get all",
            notes = "Get all",
            produces = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 200, message = "OK")
    })

    @GET
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response getALL() {
        List<Role> list =  roleDAO.getList();
        return Response.ok(list).build();
    }

    @ApiOperation(value = "Create",
            notes = "Create",
            consumes = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 201, message = "It has been created"),
            @ApiResponse(code = 400, message = "bad request")
    })

    @POST
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response add(Role obj) {
        long id = roleDAO.add(obj);
        return Response.created(info.getAbsolutePathBuilder().path("/" + id).build()).build();
    }

    @ApiOperation(value = "Get by id",
            notes = "Get by id",
            produces = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 200, message = "ok"),
            @ApiResponse(code = 404, message = "not found")
    })
    @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "path")

    @Interceptors({NotFoundInterceptor.class})
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response getById(@PathParam("id") long id) {
        Role role = roleDAO.getById(id);
        return Response.ok(role).build();
    }

    @ApiOperation(value = "Delete",
            notes = "Delete")
    @ApiResponses({
            @ApiResponse(code = 204, message = "It has been deleted"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "path")

    @DELETE
    @Interceptors({NotFoundInterceptor.class})
    @Path("/{id}")
    @Override
    public Response delete(@PathParam("id") long id) {
        roleDAO.deleteById(id);
        return Response.noContent().build();
    }

    @ApiOperation(value = "Update",
            notes = "Update",
            consumes = MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @ApiResponses({
            @ApiResponse(code = 201, message = "It has been updated"),
            @ApiResponse(code = 400, message = "Bad request"),
            @ApiResponse(code = 404, message = "Not found")
    })
    @ApiImplicitParam(name = "id", value = "id", dataType = "long", paramType = "path")

    @Interceptors({NotFoundInterceptor.class})
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON + ";charset=UTF-8")
    @Override
    public Response update(@PathParam("id") long id, Role obj) {
        roleDAO.updateById(id, obj);
        return Response.created(info.getAbsolutePath()).build();
    }
}
