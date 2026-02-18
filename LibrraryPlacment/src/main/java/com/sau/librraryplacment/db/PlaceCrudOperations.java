package com.sau.librraryplacment.db;
import com.sau.librraryplacment.dto.Place;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;
import java.util.Optional;

public class PlaceCrudOperations {
    static final String DB_URL = "jdbc:postgresql://localhost:5432/lb-App";
    static final String USER = "postgres";
    static final String PASS = "123456";


    public Optional<Place> getPlaceById(int id) {
        Place place = null;
        try (Connection connection = DriverManager.getConnection(DB_URL, USER, PASS)) {
            Statement statement = connection.createStatement();
            String query = "SELECT * FROM places WHERE id = " + id;
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                place = new Place();
                place.setId(resultSet.getInt("id"));
                place.setBuilding(resultSet.getString("building"));
                place.setFloor(resultSet.getString("floor"));
                place.setRoom(resultSet.getString("room"));
                place.setSeat(resultSet.getInt("seat"));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        if (place != null)
            return Optional.of(place);
        else
            return Optional.empty();
    }

}