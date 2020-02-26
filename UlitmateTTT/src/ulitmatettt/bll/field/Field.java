/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ulitmatettt.bll.field;

import java.util.List;
import ulitmatettt.bll.move.IMove;

/**
 *
 * @author dpank
 */
public class Field implements IField
            
    

{

    @Override
    public void clearBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<IMove> getAvailableMoves() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getPlayerId(int column, int row) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public void setBoard(String[][] board) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setMacroboard(String[][] macroboard) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
