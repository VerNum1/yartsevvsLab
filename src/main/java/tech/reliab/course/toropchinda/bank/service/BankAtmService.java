package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.BankAtm;

import java.util.List;

// Interface for entity of database  bank_atm
public interface BankAtmService {
    BankAtm get(long bankAtmId);
    void save(BankAtm bankAtm);
    void update(BankAtm bankAtm);
    void delete(long bankAtmId);
    List<BankAtm> getAll();
}
