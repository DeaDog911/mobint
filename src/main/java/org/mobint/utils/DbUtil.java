package org.mobint.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DbUtil {
    private static Connection dbConnection = null;

    public static Connection getConnection() {
        if (dbConnection == null) {
            try {
                InputStream inputStream = DbUtil.class.getClassLoader()
                        .getResourceAsStream("db.properties");
                Properties properties = new Properties();
                if (properties != null) {
                    properties.load(inputStream);

                    String dbDriver = properties.getProperty("driver");
                    String url = properties.getProperty("url");
                    String username = properties.getProperty("username");
                    String password = properties.getProperty("password");

                    try {
                        Class.forName(dbDriver);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }

                    dbConnection = DriverManager.getConnection(url, username, password);
                }
            } catch (SQLException | IOException e) {
                throw new RuntimeException(e);
            }
        }
        return dbConnection;
    }
}
