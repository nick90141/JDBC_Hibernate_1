package Task_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Task6";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, user, password);
            Statement statement = connection.createStatement();

            insertData(statement);
            selectData(statement);
            updateData(statement);
            deleteData(statement);

            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void insertData(Statement statement) throws Exception {
        String insertQuery = "INSERT INTO task6_information (StudentID, FName, LName, Age, Birthday, City, Group_number) " +
                "VALUES " +
                "('1','Alexander', 'Ivanov', 18, '17.02.2005','Kiev', '102'), " +
                "('2','Ekaterina', 'Petrov', 18, '03.05.2004','Odessa', '102'), " +
                "('3', 'Dmitry', 'Sidorov', 18, '21.11.2004','Lviv', '102'), " +
                "('4', 'Olga', 'Smirnov', 18, '08.09.2004','Dnipro', '102'), " +
                "('5', 'Ivan', 'Kuznetsov', 18, '15.07.2004','Kiev', '102')";

        int rowsAffected = statement.executeUpdate(insertQuery);

        if (rowsAffected > 0) {
            System.out.println("Данные успешно добавлены в таблицу.");
        } else {
            System.out.println("Не удалось добавить данные в таблицу.");
        }
    }

    private static void selectData(Statement statement) throws Exception {
        String selectQuery = "SELECT * FROM task6_information";
        ResultSet resultSet = statement.executeQuery(selectQuery);

        while (resultSet.next()) {
            int studentID = resultSet.getInt("StudentID");
            String fName = resultSet.getString("FName");
            String lName = resultSet.getString("LName");
            int age = resultSet.getInt("Age");
            String birthday = resultSet.getString("Birthday");
            String city = resultSet.getString("City");
            String groupNumber = resultSet.getString("Group_number");

            System.out.println("StudentID: " + studentID + ", FName: " + fName + ", LName: " + lName +
                    ", Age: " + age + ", Birthday: " + birthday + ", City: " + city + ", Group_number: " + groupNumber);
        }
    }

    private static void updateData(Statement statement) throws Exception {
        String updateQuery = "UPDATE task6_information SET Age = 19 WHERE StudentID = 1";
        int rowsAffected = statement.executeUpdate(updateQuery);

        if (rowsAffected > 0) {
            System.out.println("Данные успешно обновлены.");
        } else {
            System.out.println("Не удалось обновить данные.");
        }
    }

    private static void deleteData(Statement statement) throws Exception {
        String deleteQuery = "DELETE FROM task6_information WHERE StudentID = 2";
        int rowsAffected = statement.executeUpdate(deleteQuery);

        if (rowsAffected > 0) {
            System.out.println("Данные успешно удалены.");
        } else {
            System.out.println("Не удалось удалить данные.");
        }
    }
}
