package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.BankOffice;

import java.util.List;

// Interface for entity of database  bank_office
public interface BankOfficeService {
    BankOffice get(long bankOfficeId);
    void save(BankOffice bankOffice);
    void update(BankOffice bankOffice);
    void delete(long bankOfficeId);
    List<BankOffice> getAll();
}
