module com.sau.librraryplacment {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires java.sql;


    opens com.sau.librraryplacment to javafx.fxml;
    exports com.sau.librraryplacment;
    exports com.sau.librraryplacment.controller;
    opens com.sau.librraryplacment.controller to javafx.fxml;
    exports com.sau.librraryplacment.db;
    opens com.sau.librraryplacment.db to javafx.fxml;
}




