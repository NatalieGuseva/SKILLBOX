import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/skillbox";
        String user = "root";
        String pass = "Aa01012015/";

        Connection connection = DriverManager.getConnection(url, user, pass);

        Statement statement = connection.createStatement();

        ResultSet resultSet = statement.executeQuery("SELECT course_name, COUNT(course_name)/(MAX(MONTH(subscription_date)) - MIN(MONTH(subscription_date))) AS Coefficient FROM PurchaseList GROUP BY course_name ORDER BY course_name");
        while (resultSet.next()) {
            String result = resultSet.getString("course_name") + " - " + resultSet.getString("Coefficient");
            System.out.println(result);

        }
        resultSet.close();
        statement.close();
        connection.close();
    }
}


