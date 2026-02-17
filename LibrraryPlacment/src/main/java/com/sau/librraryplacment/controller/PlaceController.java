package com.sau.librraryplacment.controller;
import com.sau.librraryplacment.db.PlaceCrudOperations;
import com.sau.librraryplacment.dto.Place;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
public class PlaceController {
    @FXML
    TextField Id;

    @FXML
    TextField building;

    @FXML
    TextField floor;

    @FXML
    TextField room;

    @FXML
    TextField seat;

    @FXML
    private Button close;

    @FXML
    private Button deletePlace;

    @FXML
    private Button getDeletePlace;

    @FXML
    private TextField address;

    @FXML
    private Button savePlace;

    @FXML
    private Button clearPlace;

    @FXML
    void clearPlace(ActionEvent event){
        Id.clear();
        building.clear();
        floor.clear();
        room.clear();
        seat.clear();
    }

    @FXML
    void close(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void deletePlace(ActionEvent event){

    }

    @FXML
    void updatePlace(ActionEvent event){

    }

    @FXML
    void getPlace(ActionEvent event){

    }

    @FXML
    void savePlace(ActionEvent event){

    }

}