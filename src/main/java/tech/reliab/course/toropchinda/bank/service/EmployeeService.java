package tech.reliab.course.toropchinda.bank.service;

import tech.reliab.course.toropchinda.bank.entity.Employee;

import java.util.List;

// Interface for entity of database  employee
public interface EmployeeService {
    Employee get(long employeeId);
    void save(Employee employee);
    void update(Employee employee);
    void delete(long employeeId);
    List<Employee> getAll();
}
