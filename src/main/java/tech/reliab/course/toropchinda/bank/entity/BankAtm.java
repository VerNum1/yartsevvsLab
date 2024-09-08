package tech.reliab.course.toropchinda.bank.entity;

import lombok.*;

// Entity of database  bank_atm
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankAtm {
    Long id;
    String name;
    String address;
    String status;
    Long bankId;
    Long bankOfficeId;
    Long employeeId;
    Boolean issuesMoney;
    Boolean depositMoney;
    Integer totalMoney;
    Integer costMaintenance;
}
