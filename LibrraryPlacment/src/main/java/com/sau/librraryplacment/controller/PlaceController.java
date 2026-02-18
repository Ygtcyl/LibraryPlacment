package com.sau.librraryplacment.controller;
import com.sau.librraryplacment.db.PlaceCrudOperations;
import com.sau.librraryplacment.dto.Place;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Optional;

public class PlaceController {
    @FXML
    TextField placeId;

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
        placeId.setText("");
        building.setText("");
        floor.setText("");
        room.setText("");
        seat.setText("");
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
        checkId(placeId.getText(), event);
        PlaceCrudOperations placeCrudOperations = new PlaceCrudOperations();
        int id = Integer.parseInt(placeId.getText());
        Optional<Place> place = placeCrudOperations.getPlaceById(id);
        if(place.isPresent()){
            placeId.setText(Integer.toString(place.get().getId()));
            floor.setText(place.get().getFloor());
            building.setText(place.get().getBuilding());
            room.setText(place.get().getRoom());
            seat.setText(Integer.toString(place.get().getSeat()));

        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Placer with id " + id + " not found");
            alert.showAndWait();
        }
    }

    @FXML
    void savePlace(ActionEvent event){

    }

    public void checkId(String id, ActionEvent event) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Id is wrong!");
            alert.showAndWait();
            clearPlace(event);
        }
    }
}