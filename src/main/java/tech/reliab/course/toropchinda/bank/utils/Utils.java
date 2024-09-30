package tech.reliab.course.toropchinda.bank.utils;

import tech.reliab.course.toropchinda.bank.entity.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class Utils {
    /* Получение случайного числа типа Integer на отрезке [a, b) */
    public static int getRandomIntFromAToB(Integer a, Integer b)
    {
        return (int) (Math.random() * (b - a)) + (a);
    }

    /* Конструктор сущности User из объекта ResultSet с использованием Lombok */
    public static User builderUser(ResultSet rs) throws SQLException {
        return User.builder()
                .id(rs.getLong("id"))
                .fullName(rs.getString("full_name"))
                .dateOfBirth(rs.getDate("date_of_birth"))
                .workplace(rs.getString("workplace"))
                .monthlyIncome(rs.getInt("monthly_income"))
                .bankUsed(rs.getString("bank_used"))
                .creditAccountId(rs.getLong("credit_account_id"))
                .paymentAccountId(rs.getLong("payment_account_id"))
                .creditRating(rs.getInt("credit_rating"))
                .build();
    }

    /* Конструктор сущности PaymentAccount из объекта ResultSet с использованием Lombok */
    public static PaymentAccount builderPaymentAccount(ResultSet rs) throws SQLException {
        return PaymentAccount.builder()
                .id(rs.getLong("id"))
                .userId(rs.getLong("user_id"))
                .bankName(rs.getString("bank_name"))
                .currentAmount(rs.getInt("current_amount"))
                .build();
    }

    /* Конструктор сущности Employee из объекта ResultSet с использованием Lombok */
    public static Employee builderEmployee(ResultSet rs) throws SQLException {
        return Employee.builder()
                .id(rs.getLong("id"))
                .fullName(rs.getString("full_name"))
                .dateOfBirth(rs.getDate("date_of_birth"))
                .post(rs.getString("post"))
                .bankId(rs.getLong("bank_id"))
                .officeWorkFormat(rs.getBoolean("office_work_format"))
                .bankOfficeId(rs.getLong("bank_office_id"))
                .creditServices(rs.getBoolean("credit_services"))
                .salary(rs.getInt("salary"))
                .build();
    }

    /* Конструктор сущности CreditAccount из объекта ResultSet с использованием Lombok */
    public static CreditAccount builderCreditAccount(ResultSet rs) throws SQLException {
        return CreditAccount.builder()
                .id(rs.getLong("id"))
                .userId(rs.getLong("user_id"))
                .bankName(rs.getString("bank_name"))
                .creditStartDate(rs.getDate("credit_start_date"))
                .creditEndDate(rs.getDate("credit_end_date"))
                .creditMonthlyDuration(rs.getInt("credit_monthly_duration"))
                .creditAmount(rs.getInt("credit_amount"))
                .monthlyPayment(rs.getInt("monthly_payment"))
                .interestRate(rs.getFloat("interest_rate"))
                .employeeId(rs.getLong("employee_id"))
                .paymentAccountId(rs.getLong("payment_account_id"))
                .build();
    }

    /* Конструктор сущности BankOffice из объекта ResultSet с использованием Lombok */
    public static BankOffice builderBankOffice(ResultSet rs) throws SQLException {
        return BankOffice.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .address(rs.getString("address"))
                .status(rs.getBoolean("status"))
                .freePlaceForAtm(rs.getBoolean("free_place_for_atm"))
                .numberAtms(rs.getInt("number_atms"))
                .creditServices(rs.getBoolean("credit_services"))
                .issuesMoney(rs.getBoolean("issues_money"))
                .depositMoney(rs.getBoolean("deposit_money"))
                .totalMoney(rs.getInt("total_money"))
                .rent(rs.getInt("rent"))
                .bankId(rs.getLong("bank_id"))
                .build();
    }

    /* Конструктор сущности BankAtm из объекта ResultSet с использованием Lombok */
    public static BankAtm builderBankAtm(ResultSet rs) throws SQLException {
        return BankAtm.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .address(rs.getString("address"))
                .status(rs.getString("status"))
                .bankId(rs.getLong("bank_id"))
                .bankOfficeId(rs.getLong("bank_office_id"))
                .employeeId(rs.getLong("employee_id"))
                .issuesMoney(rs.getBoolean("issues_money"))
                .depositMoney(rs.getBoolean("deposit_money"))
                .totalMoney(rs.getInt("total_money"))
                .costMaintenance(rs.getInt("cost_maintenance"))
                .build();
    }

    /* Конструктор сущности Bank из объекта ResultSet с использованием Lombok */
    public static Bank builderBank(ResultSet rs) throws SQLException {
        return Bank.builder()
                .id(rs.getLong("id"))
                .name(rs.getString("name"))
                .numberOffices(rs.getInt("number_offices"))
                .numberAtms(rs.getInt("number_atms"))
                .numberEmployees(rs.getInt("number_employees"))
                .numberUsers(rs.getInt("number_users"))
                .bankRating(rs.getInt("bank_rating"))
                .totalMoney(rs.getInt("total_money"))
                .interestRate(rs.getFloat("interest_rate"))
                .build();
    }
}
