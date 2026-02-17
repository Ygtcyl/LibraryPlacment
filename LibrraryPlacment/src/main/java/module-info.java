module com.sau.librraryplacment {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.sau.librraryplacment to javafx.fxml;
    exports com.sau.librraryplacment;
}