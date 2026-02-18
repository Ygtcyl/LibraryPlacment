package com.sau.librraryplacment.controller;

import com.sau.librraryplacment.db.StudentCrudOperations;
import com.sau.librraryplacment.dto.Student;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

import java.util.Optional;

public class StudentController {
    @FXML
    TextField studentId;

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
    void clearStudent(ActionEvent event) {
        studentId.setText("");
        name.setText("");
        dprtm.setText("");
    }

    @FXML
    void close(ActionEvent event) {
        Platform.exit();
    }

    @FXML
    void deleteStudent(ActionEvent event) {
        checkId(studentId.getText(), event);
        StudentCrudOperations studentCrudOperations = new StudentCrudOperations();
        int id = Integer.parseInt(studentId.getText());
        int result = studentCrudOperations.deleteStudentById(id);
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Done.");
        alert.setHeaderText("Student with id (" + studentId.getText() + ") has been deleted.");

    }

    @FXML
    void updateStudent(ActionEvent event) {
        checkId(studentId.getText(), event);
        Student student = new Student();
        student.setName(name.getText());
        student.setDprtmn(dprtm.getText());
        student.setId(Integer.parseInt(studentId.getText()));
        StudentCrudOperations studentCrudOperations = new StudentCrudOperations();
        int res = studentCrudOperations.updateStudentById(student);
        if(res > 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done.");
            alert.setHeaderText("Student with id (" + studentId.getText() + ") has been updated.");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText("Student couldn't be updated");
            alert.showAndWait();
        }
    }

    @FXML
    void getStudent(ActionEvent event) {
        checkId(studentId.getText(), event);
        StudentCrudOperations studentCrudOperations = new StudentCrudOperations();
        int id = Integer.parseInt(studentId.getText());
        Optional<Student> student = studentCrudOperations.getStudentById(id);
        if(student.isPresent()){
            studentId.setText(Integer.toString(student.get().getId()));
            name.setText(student.get().getName());
            dprtm.setText(student.get().getDprtmn());
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText("Student with id (" + id + ") has not been found.");
            alert.showAndWait();
        }
    }

    @FXML
    void saveStudent(ActionEvent event) {
        checkId(studentId.getText(), event);
        Student student = new Student();
        student.setName(name.getText());
        student.setDprtmn(dprtm.getText());
        student.setId(Integer.parseInt(studentId.getText()));
        StudentCrudOperations studentCrudOperations = new StudentCrudOperations();
        int res = studentCrudOperations.insertStudentById(student);
        if(res > 0){
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Done.");
            alert.setHeaderText("Student with id (" + studentId.getText() + ") saved.");
            alert.showAndWait();
        } else if(res == -1){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText("There is another student with id: (" + studentId.getText() + ")");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error.");
            alert.setHeaderText("Student couldn't be saved.");
            alert.showAndWait();
        }
    }

    public void checkId(String id, ActionEvent event) {
        if (id.isEmpty() || Integer.parseInt(id) <= 0) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText("Id seems to be wrong.");
            alert.showAndWait();
            clearStudent(event);
        }
    }
}
