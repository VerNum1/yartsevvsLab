package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Bank;

import java.util.List;

// Interface for entity of database  bank
public interface BankService {
    Bank get(long bankId);
    void save(Bank bank);
    void update(Bank bank);
    void delete(long bankId);
    List<Bank> getAll();
}
