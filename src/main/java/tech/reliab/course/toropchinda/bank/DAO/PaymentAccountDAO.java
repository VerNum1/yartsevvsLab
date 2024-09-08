package tech.reliab.course.toropchinda.bank.DAO;

import tech.reliab.course.toropchinda.bank.entity.PaymentAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static tech.reliab.course.toropchinda.bank.utils.Utils.builderPaymentAccount;

/*
 * implementation of an interface for interacting with the database payment_account
 */
public class PaymentAccountDAO implements DAO<PaymentAccount, Long>{

    /*
     * Should return object found by id in database payment_account.
     * @param id    id-primary key of entity payment_account
     * @return      entity found by id in database payment_account
     */
    @Override
    public Optional<PaymentAccount> get(Long id) {
        String sql = "SELECT * FROM payment_account where id=?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234")) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                PaymentAccount payAcc = builderPaymentAccount(rs);
                rs.close();
                statement.close();

                return Optional.ofNullable(payAcc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    /*
     * Should return all objects in database payment_account.
     * @return      the list of all entities in database payment_account
     */
    @Override
    public List<PaymentAccount> getAll() {
        String sql = "SELECT * FROM payment_account";
        List<PaymentAccount> payAccs = new ArrayList<>();

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                PaymentAccount payAcc = builderPaymentAccount(rs);
                payAccs.add(payAcc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return payAccs;
    }

    /*
     * Should save data of the object in database payment_account.
     * @param paymentAccount    paymentAccount-object of database entity payment_account
     */
    @Override
    public void save(PaymentAccount paymentAccount) {
        String sql = "INSERT INTO payment_account (user_id, bank_name, current_amount) VALUES " +
                "(?,?,?)";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");
             PreparedStatement statement = conn.prepareStatement(sql)) {
            String bankName = paymentAccount.getBankName();

            statement.setLong(1, paymentAccount.getUserId());
            statement.setString(2, bankName);
            statement.setInt(3, 0);
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should update data of the object found by id in database payment_account.
     * @param paymentAccount    paymentAccount-object of database entity payment_account
     */
    @Override
    public void update(PaymentAccount paymentAccount) {
        String updateQuery = "UPDATE payment_account SET" +
                " user_id=?, bank_name=?, current_amount=? "
                + "WHERE payment_account.id=?";

        try (Connection conn = DriverManager.getConnection(
                "jdbc:postgresql://localhost:5432/db", "postgres", "1234");) {
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setLong(1, paymentAccount.getUserId());
            statement.setString(2, paymentAccount.getBankName());
            statement.setInt(3, paymentAccount.getCurrentAmount());

            statement.setLong(4, paymentAccount.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should delete the object found by id in database payment_account.
     * @param id    id-primary key of entity payment_account
     */
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM payment_account where payment_account.id =?";

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
