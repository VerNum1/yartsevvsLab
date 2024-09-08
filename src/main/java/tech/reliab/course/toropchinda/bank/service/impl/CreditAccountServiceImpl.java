package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.CreditAccountDAO;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;
import tech.reliab.course.toropchinda.bank.service.CreditAccountService;

import java.util.List;

/*
 * A class representing implementation of service for entity CreditAccount
 * @see tech.reliab.course.toropchinda.bank.service.CreditAccountService
 * @see tech.reliab.course.toropchinda.bank.DAO.CreditAccountDAO
 */
public class CreditAccountServiceImpl implements CreditAccountService {
    private final CreditAccountDAO creditAccountDAO = new CreditAccountDAO();

    @Override
    public CreditAccount get(long creditAccountId) {
        return creditAccountDAO.get(creditAccountId).orElse(null);
    }

    @Override
    public List<CreditAccount> getAll() {
        return creditAccountDAO.getAll();
    }

    @Override
    public void save(CreditAccount creditAccount) {
        creditAccountDAO.save(creditAccount);
    }

    public void update(CreditAccount creditAccount) {
        creditAccountDAO.update(creditAccount);
    }

    public void delete(long creditAccountId) {
        creditAccountDAO.delete(creditAccountId);
    }
}
