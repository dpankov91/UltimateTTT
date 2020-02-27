/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulitmatettt.gui.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;

/**
 * FXML Controller class
 *
 * @author hp
 */
public class GameViewController implements Initializable {

    @FXML
    private GridPane grdGameBoard;
    @FXML
    private ImageView imgCircle;
    @FXML
    private Label lblPlayer2;
    @FXML
    private Label lblPlayer1Score;
    @FXML
    private Label lblPlayer2Score;
    @FXML
    private Button btnMainMenu;
    @FXML
    private Button btnNewGame;
    @FXML
    private ImageView imgCross;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void clickOnField(ActionEvent event) {
    }

    @FXML
    private void clickMainMenu(ActionEvent event) {
    }

    @FXML
    private void clickNewGame(ActionEvent event) {
    }
    
}
