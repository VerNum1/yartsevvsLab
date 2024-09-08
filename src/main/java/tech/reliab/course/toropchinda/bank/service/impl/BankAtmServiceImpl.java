package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.BankAtmDAO;
import tech.reliab.course.toropchinda.bank.entity.BankAtm;
import tech.reliab.course.toropchinda.bank.service.BankAtmService;

import java.util.List;

/*
 * A class representing implementation of service for entity BankAtm
 * @see tech.reliab.course.toropchinda.bank.service.BankAtmService
 * @see tech.reliab.course.toropchinda.bank.DAO.BankAtmDAO
 */
public class BankAtmServiceImpl implements BankAtmService {
    private final BankAtmDAO bankAtmDAO = new BankAtmDAO();

    @Override
    public BankAtm get(long bankId) {
        return bankAtmDAO.get(bankId).orElse(null);
    }

    @Override
    public List<BankAtm> getAll() {
        return bankAtmDAO.getAll();
    }

    @Override
    public void save(BankAtm bankAtm) {
        bankAtmDAO.save(bankAtm);
    }

    public void update(BankAtm bankAtm) {
        bankAtmDAO.update(bankAtm);
    }

    public void delete(long bankAtmId) {
        bankAtmDAO.delete(bankAtmId);
    }
}
