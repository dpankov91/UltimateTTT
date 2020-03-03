/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulitmatettt.gui.model;

import java.util.List;
import ulitmatettt.bll.game.GameManager;
import ulitmatettt.bll.game.GameState;
import ulitmatettt.bll.game.IGameState;
import ulitmatettt.bll.move.IMove;
import ulitmatettt.bll.move.Move;

/**
 *
 * @author dpank
 */
public class GameModel {
    
    private GameManager game;
    private IGameState gameState;

    public GameModel() 
    {
        
    }
    
    public void newPlayerVsPlayerGame()
    {
        gameState = new GameState();
        game = new GameManager(gameState);
    }
    
    public boolean performPlayerMove(int fieldXPosition, int fieldYPosition)
    {
        return game.updateGame(new Move(fieldXPosition, fieldYPosition));
    }
    
    public int getCurrentPlayer()
    {
        return game.getCurrentPlayer();
    }

    public boolean isGameOver() 
    {
        return game.isGameOver();    
    }

    public boolean isMicroboardWon() 
    {
        return game.hasWinner();    
    }

    public List<IMove> getAvailableMoves() 
    {
        return gameState.getField().getAvailableMoves();    
    }

    public boolean isMacroboardWon() 
    {
        return game.hasWinner();
    }

    public boolean isDraw() 
    {
        return !game.hasWinner() && game.isGameOver();    
    }

    /*public boolean isMicroboardWon(int microboardXPosition, int microboardYPosition) 
    {
        String microboardValue = gameState.getField().getMacroboard()[microboardXPosition][microboardYPosition];
        return microboardValue.equals(game.PLAYER_0_MARKER) || microboardValue.equals(game.PLAYER_1_MARKER);    
    }
    */

    public boolean isMicroboardWon(int i, int i0) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
