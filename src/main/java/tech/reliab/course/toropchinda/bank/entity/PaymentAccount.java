package tech.reliab.course.toropchinda.bank.entity;

import lombok.*;

// Entity of database  payment_account
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class PaymentAccount {
    Long id;
    Long userId;
    String bankName;
    Integer currentAmount;
}
