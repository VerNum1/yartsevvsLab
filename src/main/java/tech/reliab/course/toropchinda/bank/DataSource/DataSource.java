package tech.reliab.course.toropchinda.bank.DataSource;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;

import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    public static HikariConfig cfg = new HikariConfig();
    public static HikariDataSource ds;

    static {
        cfg.setJdbcUrl("jdbc:postgresql://localhost:5432/db");
        cfg.setUsername("postgres");
        cfg.setPassword("1234");
        cfg.setDriverClassName("org.postgresql.Driver");
        cfg.addDataSourceProperty( "cachePrepStmts" , "true" );
        cfg.addDataSourceProperty( "prepStmtCacheSize" , "250" );
        cfg.addDataSourceProperty( "prepStmtCacheSqlLimit" , "2048" );
        ds = new HikariDataSource(cfg);
    }

    private DataSource() {}

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
