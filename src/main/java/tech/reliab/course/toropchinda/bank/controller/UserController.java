package tech.reliab.course.toropchinda.bank.controller;

import tech.reliab.course.toropchinda.bank.entity.User;
import tech.reliab.course.toropchinda.bank.service.UserService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/user")
public class UserController {
    @Inject
    UserService UserService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        User User = UserService.get(id);
        if (User != null) {
            return Response.ok(User).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<User> atms = UserService.getAll();
        return Response.ok(atms).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(User User) {
        UserService.save(User);
        return Response.ok(User.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(User updUser, @PathParam("id") Long id) {
        UserService.update(updUser);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        UserService.delete(id);
        return Response.noContent().build();
    }
}
