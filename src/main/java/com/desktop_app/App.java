package com.desktop_app;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * JavaFX App - Mohamed El Ghali Geometre Topographe
 */
public class App extends Application {

    private static Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        // Load Primary.fxml (note the capital P to match your filename)
        scene = new Scene(loadFXML("Primary"), 1280, 720);
        
        // Set the scene to the stage
        stage.setScene(scene);
        
        // Set the window title
        stage.setTitle("Mohamed El Ghali - Geometre Topographe");
        
        // Make the window non-resizable (fixed at 1280x720)
        stage.setResizable(false);
        
        // Show the stage
        stage.show();
    }

    /**
     * Changes the root of the scene to a different FXML file
     * Used for navigation between pages
     */
    static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    /**
     * Loads an FXML file and returns its root node
     * @param fxml The name of the FXML file (without .fxml extension)
     * @return Parent node of the loaded FXML
     */
    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch();
    }

}
