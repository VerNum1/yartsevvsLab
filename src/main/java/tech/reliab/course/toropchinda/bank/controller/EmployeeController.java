package tech.reliab.course.toropchinda.bank.controller;

import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.service.EmployeeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/employee")
public class EmployeeController {
    @Inject
    EmployeeService EmployeeService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        Employee Employee = EmployeeService.get(id);
        if (Employee != null) {
            return Response.ok(Employee).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<Employee> atms = EmployeeService.getAll();
        return Response.ok(atms).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(Employee Employee) {
        EmployeeService.save(Employee);
        return Response.ok(Employee.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(Employee updEmployee, @PathParam("id") Long id) {
        EmployeeService.update(updEmployee);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        EmployeeService.delete(id);
        return Response.noContent().build();
    }
}
