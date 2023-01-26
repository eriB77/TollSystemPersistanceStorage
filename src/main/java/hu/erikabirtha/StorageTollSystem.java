package hu.erikabirtha;

import java.sql.*;

public class StorageTollSystem implements StorageGatewayType {
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
    public void findVehicleByRegistrationNumber(String registrationNumber) {
        String sql = "SELECT registration_number, valid_from, valid_to FROM toll_system_dg_tmp";

        try {
            Connection connection = this.connectSqlLite();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                System.out.println(resultSet.getString(2 )+ "ez az adatbázis");
            }
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
        //lista
        //arrayList list
        //list.put
        //list visszadása
        System.out.println(registrationNumber + "Storageban lévő adat");

    }

    public VignetteEntity loadItem(String registrationNumber) {
        return findVehicleByRegistrationNumber();
    }

    private VignetteEntity findVehicleByRegistrationNumber() {
        return null;
    }
}
