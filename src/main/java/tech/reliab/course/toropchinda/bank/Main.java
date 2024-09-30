package tech.reliab.course.toropchinda.bank;

import tech.reliab.course.toropchinda.bank.DAO.UserDAO;
import tech.reliab.course.toropchinda.bank.entity.*;
import tech.reliab.course.toropchinda.bank.service.*;
import tech.reliab.course.toropchinda.bank.service.impl.*;

import java.sql.Date;


public class Main {
    public static void taskInitialized(){
        // Bank
//        System.out.println("Bank init");
//        Bank bank = Bank.builder()
//                .name("VTB")
//                .build();
//        BankService service1 = new BankServiceImpl();
//        service1.save(bank);

//        // BankOffice
//        System.out.println("BankOffice init");
//        BankOffice bankOffice = BankOffice.builder()
//                .name("Office3 RusBank")
//                .address("Moscow city")
//                .status(true)
//                .freePlaceForAtm(true)
//                .creditServices(false)
//                .issuesMoney(true)
//                .depositMoney(false)
//                .rent(40000)
//                .bankId(Long.parseLong("6"))
//                .build();
//        BankOfficeService service2 = new BankOfficeServiceImpl();
//        service2.save(bankOffice);
//
//        // Employee
//        System.out.println("Employee init");
//        Employee employee = Employee.builder()
//                .fullName("Some5")
//                .dateOfBirth(new Date(100, 7, 28))
//                .post("Promouter")
//                .bankId(Long.parseLong("6"))
//                .officeWorkFormat(true)
//                .bankOfficeId(Long.parseLong("15"))
//                .creditServices(true)
//                .salary(15000)
//                .build();
//        EmployeeService service5 = new EmployeeServiceImpl();
//        service5.save(employee);
//
//        // User
//        System.out.println("User init");

//        String[] name  = {"User Userovich6", "User Userovich7", "User Userovich8", "User Userovich9", "User Userovich10"};
//
//        String[] banksName  = {"Sberbank", "T-bank", "Selhos Bank", "VTB", "RusBank"};
//        int j = 0;
//        for (int i = 21; i <= 25; i++){
//            User user = User.builder()
//                    .fullName("User Userovich" + i)
//                    .dateOfBirth(new Date(103, 11, 10))
//                    .workplace("Zavod")
//                    .bankUsed(banksName[j])
//                    .build();
//            UserService service7 = new UserServiceImpl();
//            service7.save(user);
//            j++;
//        }

        // Payment Account
//
//        String[] banksName  = {"Sberbank", "T-bank", "Selhos Bank", "VTB", "RusBank"};
//        Integer j = 17;
//
//        for (String i : banksName) {
//            System.out.println("PaymentAccount init");
//            PaymentAccount paymentAccount = PaymentAccount.builder()
//                    .userId(Long.parseLong(Integer.toString(j)))
//                    .bankName(i)
//                    .build();
//            PaymentAccountService service6 = new PaymentAccountServiceImpl();
//            service6.save(paymentAccount);
//            j++;
//        }

//
//
//        // BankAtm
//        System.out.println("BankAtm init");
//        BankAtm bankAtm = BankAtm.builder()
//                .name("Selhos Banmk ATM1")
//                .status("working")
//                .bankId(Long.parseLong("6"))
//                .bankOfficeId(Long.parseLong("15"))
//                .employeeId(Long.parseLong("26")) //26?32?38
//                .issuesMoney(true)
//                .depositMoney(false)
//                .costMaintenance(3200)
//                .build();
//        BankAtmService service3 = new BankAtmServiceImpl();
//        service3.save(bankAtm);
//
//        // CreditAccount
//        System.out.println("CreditAccount init");
//
//        String[] banksName  = {"Sberbank", "T-bank", "Selhos Bank", "VTB", "RusBank"};
//        String[] empl = {"15", "30", "45", "65", "75"};
//        int user = 27;
//        int pay = 50;
//        int k = 0;
//        for (String i : banksName) {
//            CreditAccount creditAccount = CreditAccount.builder()
//                    .userId(Long.parseLong(Integer.toString(user)))
//                    .bankName(i)
//                    .creditStartDate(new Date(124, 3, 20))
//                    .creditEndDate(new Date(124, 8, 20))
//                    .creditMonthlyDuration(5)
//                    .creditAmount(150000)
//                    .monthlyPayment(32000)
//                    .employeeId(Long.parseLong(empl[k]))
//                    .paymentAccountId(Long.parseLong(Integer.toString(pay)))
//                    .build();
//            CreditAccountService service4 = new CreditAccountServiceImpl();
//            service4.save(creditAccount);
//
//            user++;
//            k++;
//            pay++;
//        }
//
//        System.out.println("\n\n");
    }

    public static void taskOutAll(){
        // Bank
        BankService service1 = new BankServiceImpl();
        System.out.println(service1.getAll().toString());

        // BankAtm
        BankAtmService service2 = new BankAtmServiceImpl();
        System.out.println(service2.getAll().toString());

        // BankOffice
        BankOfficeService service3 = new BankOfficeServiceImpl();
        System.out.println(service3.getAll().toString());

        // CreditAccount
        CreditAccountService service4 = new CreditAccountServiceImpl();
        System.out.println(service4.getAll().toString());

        // Employee
        EmployeeService service5 = new EmployeeServiceImpl();
        System.out.println(service5.getAll().toString());

        //PaymentAccount
        PaymentAccountService service6 = new PaymentAccountServiceImpl();
        System.out.println(service6.getAll().toString());

        // User
        UserService service7 = new UserServiceImpl();
        System.out.println(service7.getAll().toString());
    }

    public static void main(String[] args) {

        //taskInitialized();
        //taskOutAll();
        BankService serv = new BankServiceImpl();
        serv.outputBankInfo(Long.parseLong("3"));
    }
}