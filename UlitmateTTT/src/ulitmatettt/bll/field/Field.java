/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulitmatettt.bll.field;

import java.util.ArrayList;
import java.util.List;
import ulitmatettt.bll.move.IMove;

/**
 *
 * @author dpank
 */
public class Field implements IField
            
    

{

    private String[][] board;
    private String[][] macroboard;

    public Field() {
        board = new String[9][9];
        macroboard = new String [3][3];
        clearBoard();
    }

     
    
    @Override
    public void clearBoard() {
         clearBoard();
         clearMacroboard();
    }

    @Override
    public List<IMove> getAvailableMoves() {
        List<IMove> availableMoves = new ArrayList();
        for(int x = 0; x < macroboard.length; x++) {
            for(int y = 0; y < macroboard.length; y++) {
                if(macroboard[x][y].equals(AVAILABLE_FIELD)) {
                    availableMoves.addAll(getAvailableMovesFromMicroboard(x, y));
                }
                    
            }
        }
        return availableMoves;
    }

    @Override
    public String getPlayerId(int column, int row) {
         return board[column][row];
    }

    @Override
    public boolean isEmpty() {
        for(int x = 0; x < board.length; x++) {
            for(int y = 0; y < board.length; y++) {
                if(!board[x][y].equals(EMPTY_FIELD)) {
                    return false;
                }
            }
        }
        return true;
    }

    @Override
    public boolean isFull() {
       for(int x = 0; x < macroboard.length; x++)
        {
            for(int y = 0; y < macroboard[x].length; y++)
            {
                if(macroboard[x][y].equals(EMPTY_FIELD) || macroboard[x][y].equals(AVAILABLE_FIELD))
                {
                    return false;
                }
            }
        }
        return true;
       }
    }

    @Override
    public Boolean isInActiveMicroboard(int x, int y) {
          int macroboardXPosition = x/3;
        int macroboardYPosition = y/3;
        return macroboard[macroboardXPosition][macroboardYPosition].equals(AVAILABLE_FIELD);
    }
 
    @Override
    public String[][] getBoard() {
         this.board = board;
    }

    @Override
    public String[][] getMacroboard() {
        return macroboard;
        }
    }

    @Override
    public void setBoard(String[][] board) 
    {
       this.board = board;
    }

    @Override
    public void setMacroboard(String[][] macroboard) 
    {
        this.macroboard = macroboard;
    }
    
      
           
    
}
