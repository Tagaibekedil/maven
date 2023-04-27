package kg.megalab;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


    /* Создать проект Maven
     * Перенести модель UserWithAccount из прошлых заданий
     * Создать сервис который будет делать селект из прошлых заданий
     * в методе main вызвать метод сервиса с селектом
     */

    public class App {
        static final String DB_URL = "jdbc:postgresql://localhost:5432/postgres";
        static final String USER = "postgres";
        static final String PASS = "postgres";
        static final String QUERY2 = "insert into user_account (id,age,login,fulname,email,gender,) values(1,27,'Edil','tagaibek','edk@','m')";
        static final String QUERY1 = "delete from users where id=1";
        static final String QUERY = " select u.login,u.email,ua.currency from users u\n" +
                "join users_account ua on u.id = ua.id";

        public static void main(String[] args) {

            UsersAccount usersAccaunt = new UsersAccount();
            List<String> list = new ArrayList<>(10);
            try (Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(QUERY)) {
                //Extract data from result
                while (rs.next()) {
                    usersAccaunt.setLogin(rs.getString("login"));
                    usersAccaunt.setEmail(rs.getString("email"));
                    usersAccaunt.setCurrency(rs.getString("currency"));
                    list.add(usersAccaunt.getEmail() + " " +  " " + usersAccaunt.getCurrency() + " " + usersAccaunt.getLogin());
                } System.out.println(list);

            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
