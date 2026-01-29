package com.desktop_app;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Controller for the Primary (Home) view
 * Handles navigation and button state management
 */
public class PrimaryController {

    @FXML private Button navHome;
    @FXML private Button navFiles;
    @FXML private Button navInvoices;
    @FXML private Button navOtherServices;
    @FXML private Button navRealEstateFees;

    private List<Button> navButtons;
    private static final String ACTIVE_CLASS = "nav-button-active";

    /**
     * Initialize method called after FXML loading
     */
    @FXML
    public void initialize() {
        // Initialize navigation buttons list
        navButtons = new ArrayList<>();
        navButtons.add(navHome);
        navButtons.add(navFiles);
        navButtons.add(navInvoices);
        navButtons.add(navOtherServices);
        navButtons.add(navRealEstateFees);

        // Set home as active by default
        setActiveNavButton(navHome);
    }

    /**
     * Sets the active state for the specified navigation button
     * @param activeButton The button to set as active
     */
    private void setActiveNavButton(Button activeButton) {
        // Remove active class from all buttons
        for (Button button : navButtons) {
            button.getStyleClass().remove(ACTIVE_CLASS);
        }
        
        // Add active class to the selected button
        if (activeButton != null && !activeButton.getStyleClass().contains(ACTIVE_CLASS)) {
            activeButton.getStyleClass().add(ACTIVE_CLASS);
        }
    }

    // ============================================
    // MAIN CONTENT AREA BUTTON HANDLERS
    // ============================================

    @FXML
    private void handleRealEstateDrawings() {
        navigateToRealEstateFees();
    }

    @FXML
    private void handleOtherServices() {
        navigateToOtherServices();
    }

    @FXML
    private void handleFiles() {
        navigateToFiles();
    }

    @FXML
    private void handleInvoices() {
        navigateToInvoices();
    }

    // ============================================
    // NAVIGATION HANDLERS
    // ============================================

    @FXML
    private void navigateToHome() {
        setActiveNavButton(navHome);
        // Already on home page
        System.out.println("Navigation: Home (Current Page)");
    }

    @FXML
    private void navigateToFiles() {
        setActiveNavButton(navFiles);
        loadPage("Files.fxml", "الملفات - Files");
    }

    @FXML
    private void navigateToInvoices() {
        setActiveNavButton(navInvoices);
        loadPage("Invoices.fxml", "الفواتير - Invoices");
    }

    @FXML
    private void navigateToOtherServices() {
        setActiveNavButton(navOtherServices);
        loadPage("OtherServices.fxml", "خدمات أخرى - Other Services");
    }

    @FXML
    private void navigateToRealEstateFees() {
        setActiveNavButton(navRealEstateFees);
        loadPage("RealEstateFees.fxml", "الرسوم العقارية - Real Estate Fees");
    }

    // ============================================
    // PAGE LOADING UTILITY
    // ============================================

    /**
     * Loads a new FXML page
     * @param fxmlFile The FXML file name
     * @param title The window title
     */
    private void loadPage(String fxmlFile, String title) {
        try {
            // Get the current stage
            Stage stage = (Stage) navHome.getScene().getWindow();
            
            // Load the new FXML
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxmlFile));
            Parent root = loader.load();
            
            // Create new scene
            Scene scene = new Scene(root, 1280, 720);
            
            // Set the scene
            stage.setScene(scene);
            stage.setTitle(title);
            
            System.out.println("Navigation: Loaded " + fxmlFile);
            
        } catch (IOException e) {
            System.err.println("Error loading page: " + fxmlFile);
            e.printStackTrace();
            
            // If page doesn't exist yet, show a message
            System.out.println("Page " + fxmlFile + " is not yet implemented.");
        }
    }
}
