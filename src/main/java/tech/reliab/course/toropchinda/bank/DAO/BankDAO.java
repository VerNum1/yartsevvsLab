package tech.reliab.course.toropchinda.bank.DAO;

import tech.reliab.course.toropchinda.bank.DataSource.DataSource;
import tech.reliab.course.toropchinda.bank.entity.Bank;
import tech.reliab.course.toropchinda.bank.utils.Utils;

import java.sql.*;
import java.util.*;

import static tech.reliab.course.toropchinda.bank.utils.Utils.builderBank;


/*
* implementation of an interface for interacting with the database bank
*/
public class BankDAO implements DAO<Bank, Long> {

    /*
     * Should return object found by id in database bank.
     * @param id    id-primary key of entity bank
     * @return      entity found by id in database bank
     */
    @Override
    public Optional<Bank> get(Long id) {
        String sql = "SELECT * FROM bank where id=?";

        try (Connection conn = DataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                Bank bank = builderBank(rs);
                rs.close();
                statement.close();

                return Optional.ofNullable(bank);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    /*
     * Should return all objects in database bank.
     * @return      the list of all entities in database bank
     */
    @Override
    public List<Bank> getAll() {
        String sql = "SELECT * FROM bank";
        List<Bank> banks = new ArrayList<>();

        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                Bank bank = builderBank(rs);
                banks.add(bank);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return banks;
    }

    /*
     * Should save data of the object in database bank.
     * @param bank    bank-object of database entity bank
     */
    @Override
    public void save(Bank bank) {
        String sql = "INSERT INTO bank (name, number_offices, number_atms, number_employees," +
                "number_users, bank_rating, total_money, interest_rate) VALUES " +
                "(?,?,?,?,?,?,?,?)";

        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {
            statement.setString(1, bank.getName());
            statement.setInt(2, 0);
            statement.setInt(3, 0);
            statement.setInt(4, 0);
            statement.setInt(5, 0);
            int bankRating = Utils.getRandomIntFromAToB(0, 100);
            statement.setInt(6, bankRating);
            statement.setInt(7, Utils.getRandomIntFromAToB(1, 1000000));

            int a = 0, b = 20;
            int div = bankRating / 20;
            if (div >= 4){
                b = 4;
            } else if (div == 3){
                a = 4; b = 8;
            } else if (div == 2){
                a = 8; b = 12;
            } else if (div == 1){
                a = 12; b = 16;
            } else {
                a = 16;
            }

            statement.setFloat(8, (float) (Math.random() * (b - a)) + (a));
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should update data of the object found by id in database bank.
     * @param bank    bank-object of database entity bank
     */
    @Override
    public void update(Bank bank) {
        String updateQuery = "UPDATE bank SET" +
                " name=?, number_offices=?, number_atms=?, number_employees=?, number_users=?," +
                " bank_rating=?, total_money=?, interest_rate=? "
                + "WHERE bank.id=?";

        try (Connection conn = DataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setString(1, bank.getName());
            statement.setInt(2, bank.getNumberOffices());
            statement.setInt(3, bank.getNumberAtms());
            statement.setInt(4, bank.getNumberEmployees());
            statement.setInt(5, bank.getNumberUsers());
            statement.setInt(6, bank.getBankRating());
            statement.setInt(7, bank.getTotalMoney());
            statement.setFloat(8, bank.getInterestRate());
            statement.setLong(9, bank.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should delete the object found by id in database bank.
     * @param id    id-primary key of entity bank
     */
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM bank where bank.id =?";

        try {
            Connection conn = DataSource.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
