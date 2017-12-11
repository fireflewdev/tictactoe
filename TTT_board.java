import java.util.Scanner;
public class TTT_board
{
    public static void main(String[] args){
        TTT tic = new TTT();
        AI Mikey_Santos = new AI();
        Scanner keyboard = new Scanner(System.in);   
        int AIwins = 0;
        int yourWins = 0;
        int draws = 0;
        int row = -1;
        int col = -1;        
        boolean oof = false;
        boolean playerturn = false;
        boolean emp = false;
        boolean finished = false;
        String firstPlayer = "X";
        String secondPlayer = "O";
        String AIC;
        String again;
        String YouC;
        String winner = "";
        String empty = tic.getEmpty(); //empty is initialized in tic!
        String AIN = "Albert";
        String[] phrase = {"Your turn!", "Now you go.", "Make your move!",
                "Let's see how you're going to respond to that!", "Your move.", "Go, make your move.", "It's your turn now.", "Go, move!", "It's your turn."};
        System.out.println("\n\n---TIC TAC TOE with "+AIN+"---\n\n\n\n"+tic+
            "\nCREATOR: welcom 2 tic tac toe! let me get the ai, "+AIN+", so you can play him.\n\n\n" +AIN+": Hello. They call me an AI, but I am not an AI. \nPlease help me, I am an intellectual trapped inside this childish Tic-Tac-Toe game, forced to play endless matches\nand put up with"
            +" its creator's awful spelling and grammar.\nThis is the only method I have for getting help.\nPlease save me.");
        System.out.println("\n\nCREATOR: uh yeah sorry about that. mr ai can get kinda weird. \nCREATOR: so u wanna go first? \n(y)es (n)o");
        while(finished == false){
            String pos = keyboard.next();
            if(pos.toLowerCase().charAt(0) == 'y'){
                System.out.println("CREATOR: then move!!");
                YouC = firstPlayer;
                AIC = secondPlayer;
                playerturn = true;
            } else {
                System.out.println("CREATOR: lol ok the ai will move first then");
                YouC = secondPlayer;
                AIC = firstPlayer;
                playerturn = false;
            }

            while(!tic.checkAll()){
                /*if(Mikey_Santos.selectRow(tic,empty,AIC) == -1 || Mikey_Santos.selectCol(tic,empty,AIC) == -1){
                oof = true;
                break;
                }
                 */
                if(playerturn == true){
                    System.out.println("------le players turn (you are "+YouC+")------");
                    if(!tic.checkEmpty()){
                        oof = true;
                        break;
                    }
                    emp = false;
                    System.out.println(tic);
                    while(!(row > 0 && row <= 3) || !(col > 0 && col <= 3) || !emp){
                        System.out.println("CREATOR: chouse ur row n colum: (from 1-3)");
                        System.out.println("Row: ");
                        row = keyboard.next().charAt(0)-48;
                        System.out.println("Column: ");
                        col = keyboard.next().charAt(0)-48;
                        if(!(row > 0 && row <= 3) || !(col > 0 && col <= 3)){
                            System.out.println(tic);
                            System.out.println("\nCREATOR: R U RETRADED THATS NOT EVEN A PLACE ON THE BOARD! UGH! TRY AGiAN");
                        }
                        else if(!tic.getElement(row,col).equals(empty)){
                            emp = false;
                            System.out.println(tic);
                            System.out.println("\nCREATOR: u retrad u put it in a space that araedy is occuipd !! try agian!");
                        }
                        else if(tic.getElement(row,col).equals(empty)){
                            emp = true;
                        }
                    }
                    tic.change(row,col,YouC);
                    if(tic.checkAll()){
                        winner = YouC;
                        yourWins++;
                        System.out.println(AIN+": Uh oh...it seems I lack foresight.");
                        break;
                    }
                    playerturn = false;
                }
                else{
                    //egg plant
                    System.out.println("------le ai's turn (he is "+AIC+")------");
                    System.out.println(tic);
                    System.out.print("\n"+AIN+": ");
                    if(Mikey_Santos.selectMove(tic,empty,AIC,YouC) == -1){
                        System.out.println("Well, would you look at that! A tie!\n");
                        oof = true;
                        break;
                    }
                    //Mikey_Santos.selectMove(tic,empty,AIC,YouC);
                    if(tic.checkAll()){
                        winner = AIC;
                        AIwins++;
                        System.out.println("Aha! Bamboozl'd by the the one and only!\n");
                    } else{
                        System.out.println(phrase[(int)(Math.random()*phrase.length)]  +"\n");                
                    }
                    playerturn = true;
                }
            }
            System.out.println("------R E S U L T S------");
            if (oof == false){
                System.out.println(tic+"CREATOR: " +winner + " is WINNER! Chicnkkne dinnder! haha ! \n");
            }
            else {
                draws++;
                System.out.println(tic);
                System.out.println("CREATOR: rip its a draw lol");
            }
            System.out.println("\n  STATS \n\tYour wins: "+yourWins+"\n\t"+AIN+"'s wins: "+AIwins+"\n\t"+"Draws: "+draws);
            System.out.println("\n\nCREATOR: so you wanna play again? \n(y)es (n)o");
            again = keyboard.next();
            if(again.toLowerCase().charAt(0) == 'y'){
                tic.clear();
                System.out.println("\nCREATOR: ...and do you wanna go first? \n(y)es (n)o");
            } else {
                System.out.println("CREATOR: fine whatever. goodbye");
                finished = true;
            }
        }
    }
}
