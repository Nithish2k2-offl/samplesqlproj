package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnectionExample {
    private static final String URL = "jdbc:mysql://localhost:3306/student";
    private static final String USER = "root";
    private static final String PASSWORD = "root";

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connected to the database!");
            Statement statement = connection.createStatement();
            String insertQuery = "INSERT INTO students (rollno, name, average) VALUES (10,'Mr.han', 99)";
            statement.executeUpdate(insertQuery);

            String selectQuery = "SELECT * FROM students";
            ResultSet resultSet = statement.executeQuery(selectQuery);

            while (resultSet.next()) {
                int rollno = resultSet.getInt("rollno");
                String name = resultSet.getString("name");
                String average = resultSet.getString("average");

                System.out.println("rollno " + rollno + ", Name: " + name + ", average: " + average);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

