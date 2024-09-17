package tech.reliab.course.toropchinda.bank.servlet;

import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.service.*;
import tech.reliab.course.toropchinda.bank.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet("")
public class HelloServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("json/html");
        Writer printWriter = resp.getWriter();

        // Bank
        BankService service1 = new BankServiceImpl();
        printWriter.write(service1.getAll().toString());

        // BankAtm
        BankAtmService service2 = new BankAtmServiceImpl();
        printWriter.write(service2.getAll().toString());

        // BankOffice
        BankOfficeService service3 = new BankOfficeServiceImpl();
        printWriter.write(service3.getAll().toString());

        // CreditAccount
        CreditAccountService service4 = new CreditAccountServiceImpl();
        printWriter.write(service4.getAll().toString());

        // Employee
        EmployeeService service5 = new EmployeeServiceImpl();
        printWriter.write(service5.getAll().toString());

        //PaymentAccount
        PaymentAccountService service6 = new PaymentAccountServiceImpl();
        printWriter.write(service6.getAll().toString());

        // User
        UserService service7 = new UserServiceImpl();
        printWriter.write(service7.getAll().toString());

        printWriter.close();
    }
}
