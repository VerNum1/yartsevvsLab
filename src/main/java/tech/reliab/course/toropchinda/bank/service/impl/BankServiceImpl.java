package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.BankDAO;
import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.service.BankService;

import java.util.List;

/*
* A class representing implementation of service for entity Bank
* @see tech.reliab.course.toropchinda.bank.service.BankService
* @see tech.reliab.course.toropchinda.bank.DAO.BankDAO
*/
public class BankServiceImpl implements BankService {
    private final BankDAO bankDAO = new BankDAO();

    @Override
    public Bank get(long bankId) {
        return bankDAO.get(bankId).orElse(null);
    }

    @Override
    public List<Bank> getAll() {
        return bankDAO.getAll();
    }

    @Override
    public void save(Bank bank) {
        bankDAO.save(bank);
    }

    public void update(Bank bank) {
        bankDAO.update(bank);
    }

    public void delete(long bankId) {
        bankDAO.delete(bankId);
    }

    @Override
    public void outputBankInfo(Long id){ bankDAO.outputAllBankInfo(id); }
}
