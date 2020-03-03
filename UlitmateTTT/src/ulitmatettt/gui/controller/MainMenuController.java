/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulitmatettt.gui.controller;

import com.jfoenix.controls.JFXButton;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.StackPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class MainMenuController implements Initializable {

    @FXML
    private JFXButton exitButton;
    @FXML
    private Button startButton;
    @FXML
    private ToggleButton btnPlayerVsPlayer;
    @FXML
    private ToggleGroup GameMode;
    @FXML
    private ToggleButton btnPlayerVsBot;
    @FXML
    private ToggleButton btnAIvsAI;
    @FXML
    private StackPane stcFirstOption;
    @FXML
    private StackPane stcSecondOption;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickExit(ActionEvent event) {
    }

    @FXML
    private void clickStart(ActionEvent event) {
    }

    @FXML
    private void clickPlayerVsPlayer(ActionEvent event) {
    }

    @FXML
    private void clickPlayerVsBot(ActionEvent event) {
    }

    @FXML
    private void clickAIvsAI(ActionEvent event) {
    }
    
}
