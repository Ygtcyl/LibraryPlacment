package com.sau.librraryplacment.controller;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class StudentController {
    @FXML
    TextField Id;

    @FXML
    TextField name;

    @FXML
    TextField dprtm;

    @FXML
    private Button close;

    @FXML
    private Button deleteStudent;

    @FXML
    private Button saveStudent;

    @FXML
    private Button clearStudent;

    @FXML
    void clearStudent(ActionEvent event){
        Id.clear();
        name.clear();
        dprtm.clear();
    }

    @FXML
    void close(ActionEvent event){
        Platform.exit();
    }

    @FXML
    void deleteStudent(ActionEvent event){

    }

    @FXML
    void updateStudent(ActionEvent event){

    }

    @FXML
    void getStudent(ActionEvent event){

    }

    @FXML
    void saveStudent(ActionEvent event){

    }

}
