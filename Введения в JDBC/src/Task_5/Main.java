package Task_5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Main {
    public static void main(String[] args) {

        retrieveContactDetails();
        retrieveBirthdaysOfUnmarriedEmployees();
        retrieveManagerInformation();
    }
    
    private static void retrieveContactDetails() {
        String url = "jdbc:mysql://localhost:3306/MyJoinsDB";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT Employees.name, Employees.telephone, Personal_information.location " +
                    "FROM Employees " +
                    "JOIN Personal_information ON Employees.employeeID = Personal_information.employeeID";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString("name") +
                            ", Telephone: " + resultSet.getString("telephone") +
                            ", Location: " + resultSet.getString("location"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void retrieveBirthdaysOfUnmarriedEmployees() {
        String url = "jdbc:mysql://localhost:3306/MyJoinsDB";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT Employees.name, Personal_information.birthday, Employees.telephone " +
                    "FROM Employees " +
                    "JOIN Personal_information ON Employees.employeeID = Personal_information.employeeID " +
                    "WHERE Personal_information.martial_status = 'неодружений'";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString("name") +
                            ", Birthday: " + resultSet.getString("birthday") +
                            ", Telephone: " + resultSet.getString("telephone"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void retrieveManagerInformation() {
        String url = "jdbc:mysql://localhost:3306/MyJoinsDB";
        String user = "root";
        String password = "root";

        try (Connection connection = DriverManager.getConnection(url, user, password)) {
            String sql = "SELECT Employees.name, Employees.telephone, Personal_information.birthday " +
                    "FROM Employees " +
                    "INNER JOIN Work_information ON Employees.employeeID = Work_information.employeeID " +
                    "INNER JOIN Personal_information ON Employees.employeeID = Personal_information.employeeID " +
                    "WHERE Work_information.position = 'менеджер'";

            try (PreparedStatement statement = connection.prepareStatement(sql);
                 ResultSet resultSet = statement.executeQuery()) {

                while (resultSet.next()) {
                    System.out.println("Name: " + resultSet.getString("name") +
                            ", Birthday: " + resultSet.getString("birthday"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
