package com.mysql.connections.demo.jdbcApi;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class MainJdbcApi {
    public static void main(String[] args) throws SQLException {
        Connection connection = DriverManager
                .getConnection("jdbc:mysql://127.0.0.1:3306/consultatieSql", "root", "rootuser");

        Statement statement = connection.createStatement();

        String sqlInsert = "insert into person values(null, ?,?)";
        PreparedStatement preparedStatement = connection.prepareStatement(sqlInsert);
        preparedStatement.setString(1, "Ana");
        preparedStatement.setString(2, "Andrei");
        int result = preparedStatement.executeUpdate();
        if (result>0){
            System.out.println("s-a inserat cu succes");
        }

        ResultSet resultSet = statement.executeQuery("select * from person");
        List<Person> people = new ArrayList<>();
        while (resultSet.next()){
            Person p = new Person();
            p.setId(resultSet.getInt("id"));
            p.setNume(resultSet.getString("nume"));
            p.setPrenume(resultSet.getString("prenume"));
            people.add(p);
        }
        System.out.println(people);
    }
}
