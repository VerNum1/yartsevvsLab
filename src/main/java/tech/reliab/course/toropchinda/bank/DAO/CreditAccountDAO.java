package tech.reliab.course.toropchinda.bank.DAO;

import tech.reliab.course.toropchinda.bank.DataSource.DataSource;
import tech.reliab.course.toropchinda.bank.entity.CreditAccount;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static tech.reliab.course.toropchinda.bank.utils.Utils.builderCreditAccount;

/*
 * implementation of an interface for interacting with the database credit_account
 */
public class CreditAccountDAO implements DAO<CreditAccount, Long> {

    /*
     * Should return object found by id in database credit_account.
     * @param id    id-primary key of entity credit_account
     * @return      entity found by id in database credit_account
     */
    @Override
    public Optional<CreditAccount> get(Long id) {
        String sql = "SELECT * FROM credit_account where id=?";

        try (Connection conn = DataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setLong(1, id);
            ResultSet rs = statement.executeQuery();
            if (rs.next()) {
                CreditAccount credAcc = builderCreditAccount(rs);
                rs.close();
                statement.close();

                return Optional.ofNullable(credAcc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return Optional.empty();
    }

    /*
     * Should return all objects in database credit_account.
     * @return      the list of all entities in database credit_account
     */
    @Override
    public List<CreditAccount> getAll() {
        String sql = "SELECT * FROM credit_account";
        List<CreditAccount> credAccs = new ArrayList<>();

        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql);
             ResultSet rs = statement.executeQuery()) {
            while (rs.next()) {
                CreditAccount credAcc = builderCreditAccount(rs);
                credAccs.add(credAcc);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return credAccs;
    }

    /*
     * Should save data of the object in database credit_account.
     * @param creditAccount    creditAccount-object of database entity credit_account
     */
    @Override
    public void save(CreditAccount creditAccount) {
        String sql = "INSERT INTO credit_account (user_id, bank_name, credit_start_date, credit_end_date," +
                " credit_monthly_duration, credit_amount, monthly_payment, interest_rate, employee_id, payment_account_id) " +
                "VALUES (?,?,?,?,?,?,?,?,?,?)";

        try (Connection conn = DataSource.getConnection();
             PreparedStatement statement = conn.prepareStatement(sql)) {

            statement.setLong(1, creditAccount.getUserId());
            statement.setString(2, creditAccount.getBankName());
            statement.setDate(3, (Date) creditAccount.getCreditStartDate());
            statement.setDate(4, (Date) creditAccount.getCreditEndDate());
            statement.setInt(5, creditAccount.getCreditMonthlyDuration());
            statement.setInt(6, creditAccount.getCreditAmount());
            statement.setInt(7, creditAccount.getMonthlyPayment());

            // получение процентной ставки в банке
            String sql2 = "SELECT interest_rate FROM bank WHERE bank.name=?";
            PreparedStatement ps2 = conn.prepareStatement(sql2);
            ps2.setString(1, creditAccount.getBankName());
            ResultSet rs2 = ps2.executeQuery();
            if (rs2.next()) {
                statement.setFloat(8, rs2.getFloat("interest_rate"));
            }

            //
            statement.setLong(9, creditAccount.getEmployeeId());
            statement.setLong(10, creditAccount.getPaymentAccountId());
            statement.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should update data of the object found by id in database credit_account.
     * @param creditAccount    creditAccount-object of database entity credit_account
     */
    @Override
    public void update(CreditAccount creditAccount) {
        String updateQuery = "UPDATE credit_account SET" +
                " user_id=?, bank_name=?, credit_start_date=?, credit_end_date=?, credit_monthly_duration=?," +
                " credit_amount=?, monthly_payment=?, interest_rate=?, employee_id=?, payment_account_id=? "
                + "WHERE credit_account.id=?";

        try (Connection conn = DataSource.getConnection()) {
            PreparedStatement statement = conn.prepareStatement(updateQuery);
            statement.setLong(1, creditAccount.getUserId());
            statement.setString(2, creditAccount.getBankName());
            statement.setDate(3, (Date) creditAccount.getCreditStartDate());
            statement.setDate(4, (Date) creditAccount.getCreditEndDate());
            statement.setInt(5, creditAccount.getCreditMonthlyDuration());
            statement.setInt(6, creditAccount.getCreditAmount());
            statement.setInt(7, creditAccount.getMonthlyPayment());
            statement.setFloat(8, creditAccount.getInterestRate());
            statement.setLong(9, creditAccount.getEmployeeId());
            statement.setLong(10, creditAccount.getPaymentAccountId());

            statement.setLong(11, creditAccount.getId());
            statement.executeUpdate();
            statement.close();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /*
     * Should delete the object found by id in database credit_account.
     * @param id    id-primary key of entity credit_account
     */
    @Override
    public void delete(Long id) {
        String sql = "DELETE FROM credit_account where credit_account.id =?";

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
