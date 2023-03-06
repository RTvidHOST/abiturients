package com.example.abiturients;

import java.sql.*;
import java.time.LocalDate;

public class DbHandler extends Configs{

  Connection dbConnection;
    public Connection getDbConnection() throws ClassNotFoundException, SQLException {
        String connectionString = "jdbc:mysql://" + dbHost + ":" + dbPort + "/" + dbName;
        Class.forName("com.mysql.cj.jdbc.Driver");
        dbConnection = DriverManager.getConnection(connectionString, dbUser, dbPass);
        return dbConnection;
    }
    public void addAb(String family, String name, String dad, LocalDate dateR, String form, String att) {
        try {
            String insert = "INSERT INTO dataab (фамилия, имя, отчество, датаРождения, формаОбучения, среднийБалл)" +
                    "VALUES(?,?,?,?,?,?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, family);
            prst.setString(2, name);
            prst.setString(3, dad);
            prst.setDate(4, Date.valueOf(dateR));
            prst.setString(5, form);
            prst.setString(6, att);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void updateAb(String family, String name, String dad, LocalDate dateR, String form, String att) {
        try {
            String insert = "UPDATE dataab SET фамилия = ?, имя = ?, отчество = ?, датаРождения = ?, формаОбучения = ?, среднийБалл = ?" +
                    "WHERE id = " + HelloController.data;
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, family);
            prst.setString(2, name);
            prst.setString(3, dad);
            prst.setDate(4, Date.valueOf(dateR));
            prst.setString(5, form);
            prst.setString(6, att);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteAb(String family, String name, String dad, LocalDate birthday, String form, String att) {
        try {
            dbConnection = getDbConnection();
            String read = "SELECT фамилия FROM dataab WHERE id = " + HelloController.data + "'";
            PreparedStatement prst1 = dbConnection.prepareStatement(read);
            ResultSet resultSet = prst1.executeQuery();
            int sum = 0;
            if (resultSet.next()) {
                sum = resultSet.getInt(1) - 1;
            }
            String delete = "DELETE FROM dataab WHERE id = '" +
                    HelloController.data + "'";
            PreparedStatement prst = dbConnection.prepareStatement(delete);
            prst.setString(1, family);
            prst.setString(2, name);
            prst.setString(3, dad);
            prst.setDate(4, Date.valueOf(birthday));
            prst.setString(5, form);
            prst.setString(6, att);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public ResultSet tableAd() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM dataab";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet tableModer() {
        ResultSet resultSet = null;
        String select = "SELECT * FROM moderator";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getAdmin(Admin admin) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM admin WHERE login" + "=? AND " + "password" + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, admin.getLogin());
            prst.setString(2, admin.getPassword());
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public ResultSet getModer(Moder moder) {
        ResultSet resultSet = null;
        String select = "SELECT * FROM moderator WHERE login" + "=? AND " + "password" + "=?";
        try {
            PreparedStatement prst = getDbConnection().prepareStatement(select);
            prst.setString(1, moder.getLogin());
            prst.setString(2, moder.getPassword());
            resultSet = prst.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public void addModer(String login, String password) {
        try {
            String insert = "INSERT INTO moderator (login, password)" + "VALUES(?,?)";
            dbConnection = getDbConnection();
            PreparedStatement prst = dbConnection.prepareStatement(insert);
            prst.setString(1, login);
            prst.setString(2, password);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void deleteModer(String login, String password) {
        try {
            dbConnection = getDbConnection();
            String read = "SELECT * FROM moderator WHERE id = " + adminController.data + "'";
            PreparedStatement prst1 = dbConnection.prepareStatement(read);
            ResultSet resultSet = prst1.executeQuery();
            int sum = 0;
            if (resultSet.next()) {
                sum = resultSet.getInt(1) - 1;
            }
            String delete = "DELETE FROM dataab WHERE id = '" +
                    adminController.data + "'";
            PreparedStatement prst = dbConnection.prepareStatement(delete);
            prst.setString(1, login);
            prst.setString(2, password);
            prst.executeUpdate();
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
