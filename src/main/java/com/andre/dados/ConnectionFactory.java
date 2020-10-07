package com.andre.dados;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class ConnectionFactory {
    public static Connection getConnection() {
            try {
                Class.forName("org.postgresql.Driver");
                String url = "jdbc:postgresql://lallah.db.elephantsql.com:5432/azjmtott";
                Properties props = new Properties();
                props.setProperty("user","azjmtott");
                props.setProperty("password","OQvqqvYC8W4JFk_YHAZMmFCo7MLk-b2C");
                Connection conn = DriverManager.getConnection(url, props);
                return conn;
            } catch(Exception e) {
                System.out.println(e);
            }
            return null;
        }

}
