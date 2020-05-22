/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package mainpackage.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class DataBaseManager {
private Connection connection;
    public void connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection( "jdbc:mysql://localhost:3306/alien-files?useUnicode=true&serverTimezone=UTC","root", "" );
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
////
    
//    public void addUser(Users user){
//        try{
//
//            PreparedStatement statement = connection.prepareStatement("" +
//                    "INSERT INTO student (id, name, surname, login, password,gender) " +
//                    "VALUES (NULL, ?, ?, ?, ?,?)" );
//            
//            
//            statement.setString(1, user.getName());
//            statement.setString(2, user.getSurname());
//            statement.setString(3, user.getLogin());
//            statement.setString(4, user.getPassword());
//            statement.setString(5, user.getGender());
//            
//            int rows = statement.executeUpdate();// Insert, Delete, Update
//            
//            statement.close();
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//    }
        public void addUser(String name, String surname, String login, String password, String gender){
        try{

          
            PreparedStatement statement = connection.prepareStatement("" +
                    "INSERT INTO users (id, name, surname, login, password,gender) " +
                    "VALUES (NULL, ?, ?, ?, ?,?)" );
                
            
            statement.setString(1, name);
            statement.setString(2, surname);
            statement.setString(3, login);
            statement.setString(4, password);
            statement.setString(5, gender);
             
            int rows = statement.executeUpdate();// Insert, Delete, Update
            
            statement.close();

        }catch (Exception e){
            e.printStackTrace();
        }
    }
////
//        public ResultSet getUser(Users user){
//            ResultSet resSet = null;
//            String select = "SELECT * FROM" + 
//        }
////
    public ArrayList<Users> getAllusers(){
        ArrayList<Users> usersList = new ArrayList<>();
        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet = statement.executeQuery();/// Select
           
            while(resultSet.next()){
                Integer id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String surname = resultSet.getString("surname");
                String login = resultSet.getString("login");
                String password = resultSet.getString("password");
                String gender = resultSet.getString("gender");
                
                usersList.add(new Users(id, name, surname, login, password, gender));
            }
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return usersList;
    }
    public void deleteUsers(Integer id){
        try{
            PreparedStatement statement = connection.prepareStatement("" +
                    "DELETE FROM student WHERE id = ?"
            );
            statement.setInt(1, id);
            int rows = statement.executeUpdate();
            statement.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }

}
