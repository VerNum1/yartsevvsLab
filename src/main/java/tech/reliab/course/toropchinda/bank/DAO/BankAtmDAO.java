package tech.reliab.course.toropchinda.bank.DAO;

import tech.reliab.course.toropchinda.bank.entity.BankAtm;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static tech.reliab.course.toropchinda.bank.utils.Utils.builderBankAtm;

/*
 * implementation of an interface for interacting with the database bank_atm
 */
public class BankAtmDAO implements DAO<BankAtm, Long> {

    /*
     * Should return object found by id in database bank_atm.
     * @param id    id-primary key of entity bank_atm
     * @return      entity found by id in database bank_atm
     */
    @Override
    public Optional<BankAtm> get(Long id) {
        String sql = "SELECT * FROM bank_atm where id=?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234")) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                BankAtm atm = builderBankAtm(rs);
                rs.close();
                statement.close();

                return Optional.ofNullable(atm);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    /*
     * Should return all objects in database bank_atm.
     * @return      the list of all entities in database bank_atm
     */
    @Override
    public List<BankAtm> getAll() {
        String sql = "SELECT * FROM bank_atm";
        List<BankAtm> atms = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                BankAtm atm = builderBankAtm(rs);
                atms.add(atm);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return atms;
    }

    /*
     * Should save data of the object in database bank_atm.
     * @param bankAtm    bankAtm-object of database entity bank_atm
     */
    @Override
    public void save(BankAtm bankAtm) {
        String sql = "INSERT INTO bank_atm (name, address, status, bank_id, bank_office_id," +
                " employee_id, issues_money, deposit_money, total_money, cost_maintenance) VALUES " +
                "(?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
             PreparedStatement statement = conn.prepareStatement(sql)) {
            Long bankId = bankAtm.getBankId();
            Long bankOfficeId = bankAtm.getBankOfficeId();

            statement.setString(1, bankAtm.getName());
            statement.setString(3, bankAtm.getStatus());
            statement.setLong(4, bankId);
            statement.setLong(5, bankOfficeId);
            statement.setLong(6, bankAtm.getEmployeeId());
            statement.setBoolean(7, bankAtm.getIssuesMoney());
            statement.setBoolean(8, bankAtm.getDepositMoney());
            statement.setInt(10, bankAtm.getCostMaintenance());

            // получение адреса банковского офиса для расположения банкомата
            String sql1 = "SELECT address FROM bank_office WHERE bank_office.id=?";
            PreparedStatement ps1 = conn.prepareStatement(sql1);
            ps1.setLong(1, bankOfficeId);
            ResultSet rs1 = ps1.executeQuery();
            if (rs1.next()) {
                statement.setString(2, rs1.getString("address"));
            }

            // получение общего кол-ва денег в банке для заполнения этой же переменной в банкомате
            String sql2 = "SELECT total_money FROM bank WHERE bank.id=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setLong(1, bankId);
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                statement.setInt(9, rs2.getInt("total_money"));
            }

            //
            statement.executeUpdate();

            // обновление кол-ва банкоматов в банке
            String sql3 = "UPDATE bank SET number_atms = number_atms + 1 WHERE bank.id=?";
            PreparedStatement ps3 = conn.prepareStatement(sql3);
            ps3.setLong(1, bankId);
            ps3.executeUpdate();

            // обновление кол-ва банкоматов в офисе
            String sql4 = "UPDATE bank_office SET number_atms = number_atms + 1 WHERE bank_office.id=?";
            PreparedStatement ps4 = conn.prepareStatement(sql4);
            ps4.setLong(1, bankOfficeId);
            ps4.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should update data of the object found by id in database bank_atm.
     * @param bankAtm     bankAtm-object of database entity bank_atm
     */
    @Override
    public void update(BankAtm bankAtm) {
        String updateQuery = "UPDATE bank_atm SET" +
                " name=?, address=?, status=?, bank_id=?, bank_office_id=?," +
                " employee_id=?, issues_money=?, deposit_money=?, total_money=?, cost_maintenance=? "
                + "WHERE bank_atm.id=?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");) {
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setString(1, bankAtm.getName());
            statement.setString(2, bankAtm.getAddress());
            statement.setString(3, bankAtm.getStatus());
            statement.setLong(4, bankAtm.getBankId());
            statement.setLong(5, bankAtm.getBankOfficeId());
            statement.setLong(6, bankAtm.getEmployeeId());
            statement.setBoolean(7, bankAtm.getIssuesMoney());
            statement.setBoolean(8, bankAtm.getDepositMoney());
            statement.setInt(9, bankAtm.getTotalMoney());
            statement.setInt(10, bankAtm.getCostMaintenance());

            statement.setLong(11, bankAtm.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
    * Should delete the object found by id in database bank_atm.
    * @param id    id-primary key of entity bank_atm
    */
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM bank_atm where bank_atm.id =?";

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
