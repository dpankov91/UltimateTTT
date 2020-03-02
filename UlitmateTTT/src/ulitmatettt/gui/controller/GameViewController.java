/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulitmatettt.gui.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.ResourceBundle;
import javafx.animation.ParallelTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import ulitmatettt.bll.game.GameManager.GameMode;
import ulitmatettt.bll.move.IMove;
import ulitmatettt.gui.model.GameModel;

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
    private HashMap<Integer, HashMap<Integer, Button>> board = new HashMap();
    private GameModel model;
    private GameMode mode;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        model = new GameModel();
    }

    @FXML
    private void clickOnField(ActionEvent event) {
        if (performPlayerMove(event)) {
            if (mode == GameMode.HumanVsBot) 
            
        }
    }

    private boolean performPlayerMove(ActionEvent event) {
        int currentPlayer = model.getCurrentPlayer();
        int[] fieldPosition = getFieldPosition(event);
        if (model.performPlayerMove(fieldPosition[0], fieldPosition[1])) {
            updateGameboard(currentPlayer, fieldPosition[0], fieldPosition[1]);
            return true;
        }
        return false;
    }

    @FXML
    private void clickMainMenu(ActionEvent event) {
    }

    @FXML
    private void clickNewGame(ActionEvent event) {
    }

    private void initializeBoard() {
        for (Node microboard : grdGameBoard.getChildren()) {
            Integer microboardXPosition = GridPane.getRowIndex(microboard);
            Integer microboardYPosition = GridPane.getColumnIndex(microboard);
            int microboardX = (microboardXPosition == null) ? 0 : microboardXPosition;
            int microboardY = (microboardYPosition == null) ? 0 : microboardYPosition;
            for (Node field : ((GridPane) ((StackPane) microboard).getChildren().get(0)).getChildren()) {
                Integer row = GridPane.getRowIndex(field);
                Integer col = GridPane.getColumnIndex(field);
                int fieldXPosition = (row == null) ? microboardX * 3 + 0 : microboardX * 3 + row;
                int fieldYPosition = (col == null) ? microboardY * 3 + 0 : microboardY * 3 + col;
                Button button = ((Button) ((StackPane) field).getChildren().get(0));
                addToBoard(fieldXPosition, fieldYPosition, button);
            }
        }
    }

    private void addToBoard(int fieldXPosition, int fieldYPosition, Button field) {
        if (board.get(fieldXPosition) == null) {
            HashMap<Integer, Button> map = new HashMap();
            map.put(fieldYPosition, field);
            board.put(fieldXPosition, map);
        } else {
            board.get(fieldXPosition).put(fieldYPosition, field);
        }
    }

    private int[] getFieldPosition(ActionEvent event) {
        int[] macroboardPosition = getPositionOnMacroboard(event);
        int[] microboardPosition = getPositionOnMicroboard(event);
        int fieldXPosition = macroboardPosition[0] * 3 + microboardPosition[0];
        int fieldYPosition = macroboardPosition[1] * 3 + microboardPosition[1];
        int[] fieldPosition = {fieldXPosition, fieldYPosition};
        return fieldPosition;
    }

    private int[] getPositionOnMacroboard(ActionEvent event) {
        Integer macroboardXPosition = GridPane.getRowIndex(((Node) event.getSource()).getParent().getParent().getParent());
        Integer macroboardYPosition = GridPane.getColumnIndex(((Node) event.getSource()).getParent().getParent().getParent());
        macroboardXPosition = (macroboardXPosition == null) ? 0 : macroboardXPosition;
        macroboardYPosition = (macroboardYPosition == null) ? 0 : macroboardYPosition;
        int[] macroboardPosition = {macroboardXPosition, macroboardYPosition};
        return macroboardPosition;
    }

    private int[] getPositionOnMicroboard(ActionEvent event) {
        Integer microboardXPosition = GridPane.getRowIndex(((Node) event.getSource()).getParent());
        Integer microboardYPosition = GridPane.getColumnIndex(((Node) event.getSource()).getParent());
        microboardXPosition = (microboardXPosition == null) ? 0 : microboardXPosition;
        microboardYPosition = (microboardYPosition == null) ? 0 : microboardYPosition;
        int[] microboardPosition = {microboardXPosition, microboardYPosition};
        return microboardPosition;
    }

    private void updateGameboard(int currentPlayer, int fieldXPosition, int fieldYPosition) {
        updateBoard(currentPlayer, fieldXPosition, fieldYPosition);
        updateMacroboard(currentPlayer, fieldXPosition, fieldYPosition);
        updateGameState(currentPlayer, fieldXPosition, fieldYPosition);
        if (!model.isGameOver()) {
            setPlayerPointer((currentPlayer + 1) % 2);
        }
    }

    private void updateBoard(int currentPlayer, int fieldXPosition, int fieldYPosition) 
    {
        Button field = board.get(fieldXPosition).get(fieldYPosition);
        ImageView imageView = new ImageView(getPlayerMarker(player));
        field.setGraphic(imageView);
    }

    private void updateMacroboard(int currentPlayer, int fieldXPosition, int fieldYPosition) 
    {
        updateMicroboardState(currentPlayer, fieldXPosition, fieldYPosition);
        updateMicroboardsAvailability();
    }

    private void updateMicroboardState(int currentPlayer, int fieldXPosition, int fieldYPosition) 
    {
        if (model.isMicroboardWon(fieldXPosition / 3, fieldYPosition / 3)) {
            GridPane microboard = (GridPane) board.get(fieldXPosition).get(fieldYPosition).getParent().getParent();
            setMicroboardToWon(currentPlayer, microboard);
        }
    }

    private void updateMicroboardsAvailability() {
        List<IMove> availableMoves = model.getAvailableMoves();
        for (int x = 0; x < 9; x++) {
            for (int y = 0; y < 9; y++) {
                board.get(x).get(y).setDisable(true);
                for (IMove move : availableMoves) {
                    if (move.getX() == x && move.getY() == y) {
                        board.get(x).get(y).setDisable(false);
                    }
                }
            }
        }
    }

    private void updateGameState(int currentPlayer, int fieldXPosition, int fieldYPosition) 
    {
        if(model.isMacroboardWon())
        {
            setGameOver(currentPlayer);
        }
        else if(model.isDraw())
        {
            setDraw();
        }     
    }

    private void setPlayerPointer(int i) {
        ParallelTransition transition = new ParallelTransition();

        List<Node> cross = new ArrayList();
        cross.add(imgCrossPartOne);
        cross.add(imgCrossPartTwo);

        if (currentPlayer == 0 && activePointer == 1) {
            ParallelTransition showTransition = AnimationUtil.createShowCrossAnimation(cross);
            ParallelTransition hideTransition = AnimationUtil.createHideCircleAnimation(imgCirclePartOne, imgCirclePartTwo);
            transition.getChildren().addAll(showTransition, hideTransition);
            activePointer = 0;
        } else if (currentPlayer == 1 && activePointer == 0) {
            ParallelTransition hideTransition = AnimationUtil.createHideCrossAnimation(cross);
            ParallelTransition showTransition = AnimationUtil.createShowCircleAnimation(imgCirclePartOne, imgCirclePartTwo);
            transition.getChildren().addAll(showTransition, hideTransition);
            activePointer = 1;
        }
        transition.play();
    }

    private void setMicroboardToWon(int currentPlayer, GridPane microboard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setGameOver(int currentPlayer) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void setDraw() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
