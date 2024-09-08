package tech.reliab.course.toropchinda.bank.entity;

import lombok.*;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// Entity of database  user
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class User {
    Long id;
    String fullName;
    Date dateOfBirth;
    String workplace;
    Integer monthlyIncome;
    String[] banksUsed;
    Long creditAccountId;
    Long paymentAccountId;
    Integer creditRating;
}
