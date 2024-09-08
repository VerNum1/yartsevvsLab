package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

import java.util.List;

// Interface for entity of database  payment_account
public interface PaymentAccountService {
    PaymentAccount get(long paymentAccountId);
    void save(PaymentAccount paymentAccount);
    void update(PaymentAccount paymentAccount);
    void delete(long paymentAccountId);
    List<PaymentAccount> getAll();
}
