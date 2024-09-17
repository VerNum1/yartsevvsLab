package tech.reliab.course.toropchinda.bank.controller;

import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bank_office")
public class BankOfficeController {
    @Inject
    BankOfficeService bankOfficeService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        BankOffice BankOffice = bankOfficeService.get(id);
        if (BankOffice != null) {
            return Response.ok(BankOffice).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<BankOffice> atms = bankOfficeService.getAll();
        return Response.ok(atms).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(BankOffice BankOffice) {
        bankOfficeService.save(BankOffice);
        return Response.ok(BankOffice.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(BankOffice updBankOffice, @PathParam("id") Long id) {
        bankOfficeService.update(updBankOffice);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        bankOfficeService.delete(id);
        return Response.noContent().build();
    }
}
