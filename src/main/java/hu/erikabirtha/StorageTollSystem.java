package hu.erikabirtha;

import java.sql.*;

public class StorageTollSystem {
    //file mentés

    private Connection connectSqlLite() {
        //SqLite connection string
        String urlConnection = "jdbc:sqlite:M:\\Documents\\00_fejlesztes\\bootcamp\\Bootcamp_20230124\\TollSystemPersistanceStorage\\tollsystem.sqlite";
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(urlConnection);
        } catch (SQLException exception) {
            exception.printStackTrace();
            System.out.println(exception.getMessage());
        }
        return connection;
    }
    public void findVehicleByRegistrationNumber(String registration_number) {
        String sql = "SELECT registration_number, valid_from, valid_to FROM toll_system";

        try {
            Connection connection = this.connectSqlLite();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }
}
