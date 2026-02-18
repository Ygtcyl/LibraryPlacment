package com.sau.librraryplacment.db;

import com.sau.librraryplacment.dto.Student;

import java.sql.*;
import java.util.Optional;

public class StudentCrudOperations {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/cr26";
    static final String USER = "postgres";
    static final String PASS = "postgres";

    public Optional<Student> getStudentById(int id) {
        Student student = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM student WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                student = new Student();
                student.setId(resultSet.getInt("id"));
                student.setName(resultSet.getString("name"));
                student.setDprtmn(resultSet.getString("dprtmn"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (student != null) return Optional.of(student);
        else return Optional.empty();
    }

    public int insertStudentById(Student student) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            String params = student.getId() + ", \'" + student.getName() + "\',\'" + student.getDprtmn() + "\'";
            if (getStudentById(student.getId()).isPresent()) {
                result = -1;
            } else {
                String query = "INSERT INTO student (id, name, dprtm) VALUES (" + params + ");";
                result = statement.executeUpdate(query);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int updateStudentById(Student student) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            String params = student.getId() + ", \'" + student.getName() + "\',\'" + student.getDprtmn() + "\'";
            if(getStudentById(student.getId()).isPresent()) {
                String query = "UPDATE student SET " +
                        "name =  \'" + student.getName() +"\', " +
                        "dprtmn = \'" + student.getDprtmn() + "\' WHERE id = " + student.getId() + ";";
                result = statement.executeUpdate(query);
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return result;
    }

    public int deleteStudentById(int id) {
        int result = 0;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            String query = "DELETE FROM student WHERE id = " + id;
            result = statement.executeUpdate(query);
        } catch (Exception e){
            throw new RuntimeException(e);
        }
        return result;
    }
}
