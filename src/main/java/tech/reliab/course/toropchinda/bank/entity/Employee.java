package tech.reliab.course.toropchinda.bank.entity;

import lombok.*;

import java.util.Date;

// Entity of database  employee
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Employee {
    Long id;
    String fullName;
    Date dateOfBirth;
    String post;
    Long bankId;
    Boolean officeWorkFormat;
    Long bankOfficeId;
    Boolean creditServices;
    Integer salary;
}
