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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Boolean isInActiveMicroboard(int x, int y) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] getBoard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[][] getMacroboard() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
