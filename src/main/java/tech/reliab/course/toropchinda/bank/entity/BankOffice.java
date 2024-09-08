package tech.reliab.course.toropchinda.bank.entity;

import lombok.*;

// Entity of database  bank_office
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BankOffice {
    Long id;
    String name;
    String address;
    Boolean status;
    Boolean freePlaceForAtm;
    Integer numberAtms;
    Boolean creditServices;
    Boolean issuesMoney;
    Boolean depositMoney;
    Integer totalMoney;
    Integer rent;
    Long bankId;
}
