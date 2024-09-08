package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.PaymentAccountDAO;
import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;
import tech.reliab.course.toropchinda.bank.service.PaymentAccountService;

import java.util.List;

/*
 * A class representing implementation of service for entity PaymentAccount
 * @see tech.reliab.course.toropchinda.bank.service.PaymentAccountService
 * @see tech.reliab.course.toropchinda.bank.DAO.PaymentAccountDAO
 */
public class PaymentAccountServiceImpl implements PaymentAccountService {
    private final PaymentAccountDAO paymentAccountDAO = new PaymentAccountDAO();

    @Override
    public PaymentAccount get(long paymentAccountId) {
        return paymentAccountDAO.get(paymentAccountId).orElse(null);
    }

    @Override
    public List<PaymentAccount> getAll() {
        return paymentAccountDAO.getAll();
    }

    @Override
    public void save(PaymentAccount paymentAccount) {
        paymentAccountDAO.save(paymentAccount);
    }

    public void update(PaymentAccount paymentAccount) {
        paymentAccountDAO.update(paymentAccount);
    }

    public void delete(long paymentAccountId) {
        paymentAccountDAO.delete(paymentAccountId);
    }
}
