package ru.job4j.jdbc;

import java.io.FileInputStream;
import java.io.InputStream;
import java.sql.*;
import java.util.Properties;

public class TableEditor implements AutoCloseable {
    private Connection connection;

    private Properties properties;

    public TableEditor(Properties properties) throws Exception {
        this.properties = properties;
        initConnection();
    }

    private void initConnection() throws Exception {
        try (InputStream in = new FileInputStream("src/main/resources/db.properties")) {
            properties.load(in);
            Class.forName(properties.getProperty("driver-class-name"));
            connection = DriverManager.getConnection(
                    properties.getProperty("db.host"),
                    properties.getProperty("db.login"),
                    properties.getProperty("db.password")
            );
        }
    }

    private void getStatement(String sql) throws Exception {
        try (Statement statement = connection.createStatement()) {
            statement.execute(sql);
        }
    }

    public void createTable(String tableName) throws Exception {
        String sql = String.format("create table if not exists %s();", tableName);
        getStatement(sql);
    }

    public void dropTable(String tableName) throws Exception {
        String sql = String.format("drop table if exists %s;", tableName);
        getStatement(sql);
    }

    public void addColumn(String tableName, String columnName, String type) throws Exception {
        String sql = String.format("alter table if exists %s add %s %s;", tableName, columnName, type);
        getStatement(sql);
    }

    public void dropColumn(String tableName, String columnName) throws Exception {
        String sql = String.format("alter table if exists %s drop if exists  %s ;", tableName, columnName);
        getStatement(sql);
    }

    public void renameColumn(String tableName, String columnName, String newColumnName) throws Exception {
        String sql = String.format("alter table if exists %s rename %s to %s;", tableName, columnName, newColumnName);
        getStatement(sql);
    }

    public String getScheme(String tableName) throws SQLException {
        StringBuilder scheme = new StringBuilder();
        DatabaseMetaData metaData = connection.getMetaData();
        try (ResultSet columns = metaData.getColumns(null, null, tableName, null)) {
            scheme.append(String.format("%-15s %-15s%n", "column", "type"));
            while (columns.next()) {
                scheme.append(String.format("%-15s %-15s%n",
                        columns.getString("COLUMN_NAME"),
                        columns.getString("TYPE_NAME")));
            }
        }
        return scheme.toString();
    }

    @Override
    public void close() throws Exception {
        if (connection != null) {
            connection.close();
        }
    }

    public static void main(String[] args) throws Exception {
        TableEditor tableEditor = new TableEditor(new Properties());
        tableEditor.dropTable("table1");
        tableEditor.createTable("table1");
        System.out.println(tableEditor.getScheme("table1"));
        tableEditor.addColumn("table1", "name", "varchar(255)");
        System.out.println(tableEditor.getScheme("table1"));
        tableEditor.renameColumn("table1", "name", "name1");
        System.out.println(tableEditor.getScheme("table1"));
        tableEditor.dropColumn("table1", "name1");
        System.out.println(tableEditor.getScheme("table1"));
    }
}
