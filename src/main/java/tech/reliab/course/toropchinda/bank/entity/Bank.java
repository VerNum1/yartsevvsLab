package tech.reliab.course.toropchinda.bank.entity;

import lombok.*;

// Entity of database  bank
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Bank {
    Long id;
    String name;
    Integer numberOffices;
    Integer numberAtms;
    Integer numberEmployees;
    Integer numberUsers;
    Integer bankRating;
    Integer totalMoney;
    Float interestRate;
}