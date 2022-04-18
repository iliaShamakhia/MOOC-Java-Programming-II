package ticTacToe;

public class GameLogic {
    
    private String[][] board;
    private String turn;
    private int moves;
    
    public GameLogic(){
        this.board = new String[3][3];
        for(int i = 0; i < 3; i++){
            for(int j = 0; j < 3; j++){
                board[i][j] = " " + i + j;
            }
        }
        this.turn = "X";
        this.moves = 0;
    }
    
    public String hasWon(){
        for(int i = 0; i < board.length; i++){
            if(board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2])){
                return board[i][0];
            }
            if(board[0][i].equals(board[1][i]) && board[0][i].equals(board[2][i])){
                return board[0][i];
            }
            if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){
                return board[0][0];
            }
            if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])){
                return board[2][0];
            }
        }
        if(moves == 9)return "full";
        return "no";
    }
    
    private void toggleTurn(){
        this.turn = this.turn.equals("X")? "O":"X";
    }
    
    public boolean setChoice(int i, int j){
        if(!board[i][j].equals("X") && !board[i][j].equals("O")){
            this.board[i][j] = this.turn;
            this.toggleTurn();
            this.moves++;
            return true;
        }
        return false;
    }
    
    public String getTurn(){
        return turn;
    }
}
