package tech.reliab.course.toropchinda.bank;

import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.service.*;
import tech.reliab.course.toropchinda.bank.service.impl.*;

import java.sql.Date;


public class Main {
    public static void taskInitialized(){
        // Bank
        System.out.println("Bank init");
        Bank bank = Bank.builder()
                .name("Sberbank")
                .build();
        BankService service1 = new BankServiceImpl();
        service1.save(bank);

        // BankOffice
        System.out.println("BankOffice init");
        BankOffice bankOffice = BankOffice.builder()
                .name("Office Sbepbank")
                .address("Moscow city")
                .status(true)
                .freePlaceForAtm(true)
                .creditServices(false)
                .issuesMoney(true)
                .depositMoney(false)
                .rent(40000)
                .bankId(Long.parseLong("3"))
                .build();
        BankOfficeService service2 = new BankOfficeServiceImpl();
        service2.save(bankOffice);

        // Employee
        System.out.println("Employee init");
        Employee employee = Employee.builder()
                .fullName("Amir Zasd fdss")
                .dateOfBirth(new Date(100, 7, 28))
                .post("Promouter")
                .bankId(Long.parseLong("3"))
                .officeWorkFormat(true)
                .bankOfficeId(Long.parseLong("1"))
                .creditServices(true)
                .salary(15000)
                .build();
        EmployeeService service5 = new EmployeeServiceImpl();
        service5.save(employee);

        // User
        System.out.println("User init");
        String[] banksName  = {"Sberbank"};
        User user = User.builder()
                .fullName("User user user")
                .dateOfBirth(new Date(103, 11, 10))
                .workplace("Zavod")
                .banksUsed(banksName)
                .build();
        UserService service7 = new UserServiceImpl();
        service7.save(user);

        // Payment Account
        System.out.println("PaymentAccount init");
        PaymentAccount paymentAccount = PaymentAccount.builder()
                .userId(Long.parseLong("1"))
                .bankName("Sberbank")
                .build();
        PaymentAccountService service6 = new PaymentAccountServiceImpl();
        service6.save(paymentAccount);

        // BankAtm
        System.out.println("BankAtm init");
        BankAtm bankAtm = BankAtm.builder()
                .name("Sberbank ATM")
                .status("working")
                .bankId(Long.parseLong("3"))
                .bankOfficeId(Long.parseLong("1"))
                .employeeId(Long.parseLong("11"))
                .issuesMoney(true)
                .depositMoney(false)
                .costMaintenance(3200)
                .build();
        BankAtmService service3 = new BankAtmServiceImpl();
        service3.save(bankAtm);

        // CreditAccount
        System.out.println("CreditAccount init");
        CreditAccount creditAccount = CreditAccount.builder()
                .userId(Long.parseLong("1"))
                .bankName("Sberbank")
                .creditStartDate(new Date(124, 3, 20))
                .creditEndDate(new Date(124, 8, 20))
                .creditMonthlyDuration(5)
                .creditAmount(150000)
                .monthlyPayment(32000)
                .employeeId(Long.parseLong("11"))
                .paymentAccountId(Long.parseLong("16"))
                .build();
        CreditAccountService service4 = new CreditAccountServiceImpl();
        service4.save(creditAccount);

        System.out.println("\n\n");
    }

    public static void taskOutAll(){
        // Bank
        BankService service1 = new BankServiceImpl();
        System.out.println(service1.get(Long.parseLong("3")).toString());

        // BankAtm
        BankAtmService service2 = new BankAtmServiceImpl();
        System.out.println(service2.get(Long.parseLong("2")).toString());

        // BankOffice
        BankOfficeService service3 = new BankOfficeServiceImpl();
        System.out.println(service3.get(Long.parseLong("1")).toString());

        // CreditAccount
        CreditAccountService service4 = new CreditAccountServiceImpl();
        System.out.println(service4.get(Long.parseLong("13")).toString());

        // Employee
        EmployeeService service5 = new EmployeeServiceImpl();
        System.out.println(service5.get(Long.parseLong("11")).toString());

        //PaymentAccount
        PaymentAccountService service6 = new PaymentAccountServiceImpl();
        System.out.println(service6.get(Long.parseLong("16")).toString());

        // User
        UserService service7 = new UserServiceImpl();
        System.out.println(service7.get(Long.parseLong("1")).toString());
    }

    public static void main(String[] args) {
        taskOutAll();
    }
}