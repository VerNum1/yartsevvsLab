package tech.reliab.course.toropchinda.bank.DAO;

import tech.reliab.course.toropchinda.bank.entity.Employee;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static tech.reliab.course.toropchinda.bank.utils.Utils.builderEmployee;

/*
 * implementation of an interface for interacting with the database employee
 */
public class EmployeeDAO implements DAO<Employee, Long> {

    /*
     * Should return object found by id in database employee.
     * @param id    id-primary key of entity employee
     * @return      entity found by id in database employee
     */
    @Override
    public Optional<Employee> get(Long id) {
        String sql = "SELECT * FROM employee where id=?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234")) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Employee employee = builderEmployee(rs);
                rs.close();
                statement.close();

                return Optional.ofNullable(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    /*
     * Should return all objects in database employee.
     * @return  the list of all entities in database employee
     */
    @Override
    public List<Employee> getAll() {
        String sql = "SELECT * FROM employee";
        List<Employee> employees = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Employee employee = builderEmployee(rs);
                employees.add(employee);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return employees;
    }

    /*
     * Should save data of the object in database employee.
     * @param employee    employee-object of database entity employee
     */
    @Override
    public void save(Employee employee) {
        String sql = "INSERT INTO employee (full_name, date_of_birth, post, bank_id," +
                "office_work_format, bank_office_id, credit_services, salary) VALUES " +
                "(?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
             PreparedStatement statement = conn.prepareStatement(sql)) {
            Long bankId = employee.getBankId();

            statement.setString(1, employee.getFullName());
            statement.setDate(2, (Date) employee.getDateOfBirth());
            statement.setString(3, employee.getPost());
            statement.setLong(4, bankId);
            statement.setBoolean(5, employee.getOfficeWorkFormat());
            statement.setLong(6, employee.getBankOfficeId());
            statement.setBoolean(7, employee.getCreditServices());
            statement.setInt(8, employee.getSalary());
            statement.executeUpdate();

            // обновление кол-ва сотрудников в банке
            String sql4 = "UPDATE bank SET number_employees = bank.number_employees + 1 WHERE bank.id=?";
            PreparedStatement ps4 = conn.prepareStatement(sql4);
            ps4.setLong(1, bankId);
            ps4.executeUpdate();

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should update data of the object found by id in database employee.
     * @param employee    employee-object of database entity employee
     */
    @Override
    public void update(Employee employee) {
        String updateQuery = "UPDATE employee SET" +
                " full_name=?, date_of_birth=?, post=?, bank_id=?, office_work_format=?," +
                " bank_office_id=?, credit_services=?, salary=? "
                + "WHERE employee.id=?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");) {
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setString(1, employee.getFullName());
            statement.setDate(2, (Date) employee.getDateOfBirth());
            statement.setString(3, employee.getPost());
            statement.setLong(4, employee.getBankId());
            statement.setBoolean(5, employee.getOfficeWorkFormat());
            statement.setLong(6, employee.getBankOfficeId());
            statement.setBoolean(7, employee.getCreditServices());
            statement.setInt(8, employee.getSalary());

            statement.setLong(9, employee.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should delete the object found by id in database employee.
     * @param id    id-primary key of entity employee
     */
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM employee where employee.id =?";

        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
