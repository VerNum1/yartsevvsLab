package tech.reliab.course.toropchinda.bank.controller;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.service.PaymentAccountService;

import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/payment_account")
public class PaymentAccountController {
    @Inject
    PaymentAccountService PaymentAccountService;

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getById(@PathParam("id") Long id) {
        PaymentAccount PaymentAccount = PaymentAccountService.get(id);
        if (PaymentAccount != null) {
            return Response.ok(PaymentAccount).build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll() {
        List<PaymentAccount> atms = PaymentAccountService.getAll();
        return Response.ok(atms).build();
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(PaymentAccount PaymentAccount) {
        PaymentAccountService.save(PaymentAccount);
        return Response.ok(PaymentAccount.getId()).build();
    }

    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response update(PaymentAccount updPaymentAccount, @PathParam("id") Long id) {
        PaymentAccountService.update(updPaymentAccount);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response delete(@PathParam("id") Long id) {
        PaymentAccountService.delete(id);
        return Response.noContent().build();
    }
}
