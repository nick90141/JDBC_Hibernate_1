package Task_6;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class Task_2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/Task6";
        String user = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection connection = DriverManager.getConnection(url, user, password);
                 Statement statement = connection.createStatement();
                 BufferedReader reader = new BufferedReader(new FileReader("D:\\КУРС ПО JAVA\\JDBC & Hibernate українською\\Введения в JDBC\\src\\Task_6\\Task_2.txt"))) {

                String query;

                while ((query = reader.readLine()) != null) {
                    boolean isResultSet = statement.execute(query);
                    if (!isResultSet) {
                        int rowsAffected = statement.getUpdateCount();
                        if (rowsAffected > 0) {
                            System.out.println("Запрос успешно выполнен.");
                        } else {
                            System.out.println("Не удалось выполнить запрос.");
                        }
                    }
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
