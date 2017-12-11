public class TTT {
    private String board[][];
    private String empty = " ";
    public TTT()
    {
        board = new String[3][3];
        for(int r = 0; r < 3; r++){
            for(int c  = 0; c < 3; c++){
                board[r][c] = empty;
            }
        }
    }
    public void clear(){
        for(int r = 0; r < 3; r++){
            for(int c  = 0; c < 3; c++){
                board[r][c] = empty;
            }
        }
    }
    public boolean checkEmpty(){
        boolean e = false;
        for(int r = 0; r < 3; r++){
            for(int c  = 0; c < 3; c++){
                if(board[r][c].equals(empty)){
                    e = true;
                }
            }
        }
        return e;
    }
    public String getEmpty(){
        return empty;
    }
    public String getElement(int r, int c){
        return(board[r-1][c-1]);
    }
    public String[][] getBoard(){
        return board;
    }
    
    public void change(int r, int c, String letter)
    {
        board[r-1][c-1] = letter;
    }

    public boolean checkAll(){
        return checkCols() || checkRows() || checkDiags();
    }
    
    public boolean checkCols(){
        return checkSingleCol(0) || checkSingleCol(1) || checkSingleCol(2);
    }

    public boolean checkDiags(){
        return checkSingleDiag() || checkSingleDiag() || checkSingleDiag();
    }
    
    public boolean checkRows(){
        return checkSingleRow(0) || checkSingleRow(1) || checkSingleRow(2);
    }
    
    public boolean checkSingleCol(int col){
        if(board[0][col].equals(board[1][col]) && board[0][col].equals(board[2][col])){
            if(!(board[0][col].equals(empty)&&board[0][col].equals(empty)&&board[0][col].equals(empty))){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkSingleDiag(){
        if(board[0][0].equals(board[1][1]) && board[0][0].equals(board[2][2])){
            if(!(board[0][0].equals(empty)&&board[1][1].equals(empty)&&board[2][2].equals(empty))){
                return true;
            }
        }
        if(board[2][0].equals(board[1][1]) && board[2][0].equals(board[0][2])){
            if(!(board[2][0].equals(empty)&&board[1][1].equals(empty)&&board[0][2].equals(empty))){
                return true;
            }
        }
        return false;
    }
    
    public boolean checkSingleRow(int row){
        if(board[row][0].equals(board[row][1]) && board[row][0].equals(board[row][2])){
            if(!(board[row][0].equals(empty)&&board[row][0].equals(empty)&&board[row][0].equals(empty))){
                return true;
            }
        }
        return false;
    }

    public String toString(){
        String out = " --------\n";
        for(int r = 0; r < 3; r++){
            for(int c  = 0; c < 3; c++){
                out+="| "+board[r][c];
            }
            out+="|\n --------\n";
        }
        return out;
    }
}