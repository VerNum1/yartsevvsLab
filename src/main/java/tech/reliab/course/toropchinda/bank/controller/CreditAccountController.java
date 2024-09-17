package tech.reliab.course.toropchinda.bank.controller;

import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.service.CreditAccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/credit_account")
public class CreditAccountController {
    @Inject
    CreditAccountService CreditAccountService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        CreditAccount CreditAccount = CreditAccountService.get(id);
        if (CreditAccount != null) {
            return Response.ok(CreditAccount).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<CreditAccount> atms = CreditAccountService.getAll();
        return Response.ok(atms).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(CreditAccount CreditAccount) {
        CreditAccountService.save(CreditAccount);
        return Response.ok(CreditAccount.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(CreditAccount updCreditAccount, @PathParam("id") Long id) {
        CreditAccountService.update(updCreditAccount);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        CreditAccountService.delete(id);
        return Response.noContent().build();
    }
}
