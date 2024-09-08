package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.BankOfficeDAO;
import tech.reliab.course.toropchinda.bank.entity.BankOffice;
import tech.reliab.course.toropchinda.bank.service.BankOfficeService;

import java.util.List;

/*
 * A class representing implementation of service for entity BankOffice
 * @see tech.reliab.course.toropchinda.bank.service.BankOfficeService
 * @see tech.reliab.course.toropchinda.bank.DAO.BankOfficeDAO
 */
public class BankOfficeServiceImpl implements BankOfficeService {
    private final BankOfficeDAO bankOfficeDAO = new BankOfficeDAO();

    @Override
    public BankOffice get(long bankId) {
        return bankOfficeDAO.get(bankId).orElse(null);
    }

    @Override
    public List<BankOffice> getAll() {
        return bankOfficeDAO.getAll();
    }

    @Override
    public void save(BankOffice bankOffice) {
        bankOfficeDAO.save(bankOffice);
    }

    public void update(BankOffice bankOffice) {
        bankOfficeDAO.update(bankOffice);
    }

    public void delete(long bankOfficeId) {
        bankOfficeDAO.delete(bankOfficeId);
    }
}
