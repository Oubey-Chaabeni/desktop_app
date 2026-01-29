module com.desktop_app {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.desktop_app to javafx.fxml;
    exports com.desktop_app;
}
