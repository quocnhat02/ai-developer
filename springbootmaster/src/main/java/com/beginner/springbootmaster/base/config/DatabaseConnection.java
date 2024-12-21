package com.beginner.springbootmaster.base.config;

import java.sql.Connection;

public class DatabaseConnection {
    private static DatabaseConnection instance;

    private Connection connection;

    private DatabaseConnection() {}

    private static class DatabaseConnectionHolder {
        private static final DatabaseConnection INSTANCE = new DatabaseConnection();
    }

    public static DatabaseConnection getInstance() {
        return DatabaseConnectionHolder.INSTANCE;
    }

    public Connection getConnection() {
        return connection;
    }
}
