module com.example.javafx_one {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.javafx_one to javafx.fxml;
    exports com.example.javafx_one;
}