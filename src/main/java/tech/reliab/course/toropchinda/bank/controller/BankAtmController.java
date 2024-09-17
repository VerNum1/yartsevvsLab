package tech.reliab.course.toropchinda.bank.controller;

import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.service.BankAtmService;

import javax.inject.Inject;
import javax.print.attribute.standard.Media;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/bank_atm")
public class BankAtmController {
    @Inject
    BankAtmService bankAtmService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        BankAtm bankAtm = bankAtmService.get(id);
        if (bankAtm != null) {
            return Response.ok(bankAtm).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<BankAtm> atms = bankAtmService.getAll();
        return Response.ok(atms).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(BankAtm bankAtm) {
        bankAtmService.save(bankAtm);
        return Response.ok(bankAtm.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(BankAtm updBankAtm, @PathParam("id") Long id) {
        bankAtmService.update(updBankAtm);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        bankAtmService.delete(id);
        return Response.noContent().build();
    }
}
