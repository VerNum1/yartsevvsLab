package tech.reliab.course.toropchinda.bank.service.impl;

import tech.reliab.course.toropchinda.bank.DAO.EmployeeDAO;
import tech.reliab.course.toropchinda.bank.entity.Employee;
import tech.reliab.course.toropchinda.bank.service.EmployeeService;

import java.util.List;

/*
 * A class representing implementation of service for entity Employee
 * @see tech.reliab.course.toropchinda.bank.service.EmployeeService
 * @see tech.reliab.course.toropchinda.bank.DAO.EmployeeDAO
 */
public class EmployeeServiceImpl implements EmployeeService {
    private final EmployeeDAO employeeDAO = new EmployeeDAO();

    @Override
    public Employee get(long employeeId) {
        return employeeDAO.get(employeeId).orElse(null);
    }

    @Override
    public List<Employee> getAll() {
        return employeeDAO.getAll();
    }

    @Override
    public void save(Employee employee) {
        employeeDAO.save(employee);
    }

    public void update(Employee employee) {
        employeeDAO.update(employee);
    }

    public void delete(long employeeId) {
        employeeDAO.delete(employeeId);
    }
}
