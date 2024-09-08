package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.CreditAccount;

import java.util.List;

// Interface for entity of database  credit_account
public interface CreditAccountService {
    CreditAccount get(long creditAccountId);
    void save(CreditAccount creditAccount);
    void update(CreditAccount creditAccount);
    void delete(long creditAccountId);
    List<CreditAccount> getAll();
}
