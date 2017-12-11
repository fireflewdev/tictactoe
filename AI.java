public class AI
{
    private int col = -1;
    private int row = -1;
    public int selectMove(TTT board, String empty, String c, String p){
        if(lookMoves(board,empty,c,p) == -1){
            col = -1;
            row = -1;
            return -1;
        }
        board.change(row+1,col+1,c);
        return 0;
    }
    public int lookMoves(TTT board, String empty, String c, String p){
        String[] aPhrase = {"Haha, you almost got me there!", "Blocked you!", "Phew, you would've been able to win had I not stopped you!", "Blocked your three-in-a-row!","Phew, you almost got me there!"};
        String almost = aPhrase[(int)(Math.random()*aPhrase.length)]  +" ";
        almost = aPhrase[(int)(Math.random()*aPhrase.length)]  +" ";
        /*
         * First, checks if winning diag, then winning col. Then it checks for avaliable diag, then avaliable col. lastly, it returns -1 if there is nothing.
         */
        String[][] b = board.getBoard();
        int random = 0;
        if(b[1][1].equals(empty)){
            col = 1;
            row = 1;
            return 0;
        }
        boolean done = false;
        if (b[0][2].equals(empty) || b[2][0].equals(empty) || b[2][2].equals(empty) || b[0][0].equals(empty)){ //diags
            for(int perm = 0; perm < 4; perm++){//winning
                if (perm == 0){
                    if(b[0][0].equals(empty)){
                        board.change(1,1,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(1,1,empty);
                            col = 0;
                            row = 0;
                            return 0;
                        }
                        board.change(1,1,empty);
                    }
                }
                if (perm == 1){
                    if(b[2][0].equals(empty)){
                        board.change(3,1,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(3,1,empty);
                            col = 0;
                            row = 2;
                            return 2;
                        }
                        board.change(3,1,empty);
                    }
                }
                if (perm == 2){
                    if(b[0][2].equals(empty)){
                        board.change(1,3,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(1,3,empty);
                            col = 2;
                            row = 0;
                            return 0;
                        }
                        board.change(1,3,empty);
                    }    
                }
                if (perm == 3){
                    if(b[2][2].equals(empty)){
                        board.change(3,3,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(3,3,empty);
                            col = 2;
                            row = 2;
                            return 2;
                        }
                        board.change(3,3,empty);
                    } 
                }
            }
        }
        if (b[0][1].equals(empty) || b[1][0].equals(empty) || b[1][2].equals(empty) || b[2][1].equals(empty)){ //sides
            for(int perm = 0; perm < 4; perm++){//winning
                if (perm == 0){
                    if(b[0][1].equals(empty)){
                        board.change(1,2,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(1,2,empty);
                            row = 0;
                            col = 1;
                            return 0;
                        }
                        board.change(1,2,empty);
                    }
                }
                if (perm == 1){
                    if(b[1][0].equals(empty)){
                        board.change(2,1,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(2,1,empty);
                            row = 1;
                            col = 0;
                            return 1;
                        }
                        board.change(2,1,empty);
                    }
                }
                if (perm == 2){
                    if(b[1][2].equals(empty)){
                        board.change(2,3,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(2,3,empty);
                            row = 1;
                            col = 2;
                            return 1;
                        }
                        board.change(2,3,empty);
                    }    
                }
                if (perm == 3){
                    if(b[2][1].equals(empty)){
                        board.change(3,2,c);
                        if(board.checkAll()){
                            done = true;
                            board.change(3,2,empty);
                            row = 2;
                            col = 1;
                            return 2;
                        }
                        board.change(3,2,empty);
                    } 
                }
            }
        }
        if (b[0][2].equals(empty) || b[2][0].equals(empty) || b[2][2].equals(empty) || b[0][0].equals(empty)){ //diags        
            for(int perm = 0; perm < 4; perm++){//losing
                if (perm == 0){
                    if(b[0][0].equals(empty)){
                        board.change(1,1,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(1,1,empty);
                            col = 0;
                            row = 0;
                            return 0;
                        }
                        board.change(1,1,empty);
                    }
                }
                if (perm == 1){
                    if(b[2][0].equals(empty)){
                        board.change(3,1,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(3,1,empty);
                            col = 0;
                            row = 2;
                            return 2;
                        }
                        board.change(3,1,empty);
                    }
                }
                if (perm == 2){
                    if(b[0][2].equals(empty)){
                        board.change(1,3,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(1,3,empty);
                            col = 2;
                            row = 0;
                            return 0;
                        }
                        board.change(1,3,empty);
                    }    
                }
                if (perm == 3){
                    if(b[2][2].equals(empty)){
                        board.change(3,3,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(3,3,empty);
                            col = 2;
                            row = 2;                            
                            return 2;
                        }
                        board.change(3,3,empty);
                    } 
                }
            }
        }
        if (b[0][1].equals(empty) || b[1][0].equals(empty) || b[1][2].equals(empty) || b[2][1].equals(empty)){ //sides
            for(int perm = 0; perm < 4; perm++){//losing
                if (perm == 0){
                    if(b[0][1].equals(empty)){
                        board.change(1,2,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(1,2,empty);
                            row = 0;
                            col = 1;
                            return 0;
                        }
                        board.change(1,2,empty);
                    }
                }
                if (perm == 1){
                    if(b[1][0].equals(empty)){
                        board.change(2,1,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(2,1,empty);
                            row = 1;
                            col = 0;
                            return 1;
                        }
                        board.change(2,1,empty);
                    }
                }
                if (perm == 2){
                    if(b[1][2].equals(empty)){
                        board.change(2,3,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(2,3,empty);
                            row = 1;
                            col = 2;
                            return 0;
                        }
                        board.change(2,3,empty);
                    }    
                }
                if (perm == 3){
                    if(b[2][1].equals(empty)){
                        board.change(3,2,p);
                        if(board.checkAll()){
                            System.out.print(almost);
                            done = true;
                            board.change(3,2,empty);
                            row = 2;
                            col = 1;
                            return 2;
                        }
                        board.change(3,2,empty);
                    } 
                }
            }
        }
        //if no winning or losing found...
        if (b[0][2].equals(empty) || b[2][0].equals(empty) || b[2][2].equals(empty) || b[0][0].equals(empty)){ //diags
            while (done == false){
                random = (int)(Math.random()*4);
                if (random == 0){
                    if(b[0][0].equals(empty)){
                        done = true;
                        row = 0;
                        col = 0;
                        return 0;
                    }
                }
                if (random == 1){
                    if(b[2][0].equals(empty)){
                        done = true;
                        row = 2;
                        col = 0;
                        return 2;
                    }
                }
                if (random == 2){
                    if(b[0][2].equals(empty)){
                        done = true;
                        row = 0;
                        col = 2;
                        return 0;
                    }    
                }
                if (random == 3){
                    if(b[2][2].equals(empty)){
                        done = true;
                        row = 2;
                        col = 2;
                        return 2;
                    } 
                }
            }
        }
        if (b[0][1].equals(empty) || b[1][0].equals(empty) || b[1][2].equals(empty) || b[2][1].equals(empty)){ //sides
            while (done == false){
                random = (int)(Math.random()*4);
                if (random == 0){
                    if(b[0][1].equals(empty)){
                        done = true;
                        row = 0;
                        col = 1;
                        return 0;
                    }
                }
                if (random == 1){
                    if(b[1][0].equals(empty)){
                        done = true;
                        row = 1;
                        col = 0;
                        return 1;
                    }
                }
                if (random == 2){
                    if(b[1][2].equals(empty)){
                        done = true;
                        row = 1;
                        col = 2;
                        return 1;
                    }    
                }
                if (random == 3){
                    if(b[2][1].equals(empty)){
                        done = true;
                        row = 2;
                        col = 1;
                        return 2;
                    } 
                }
            }
        }
        return -1;
    }
}