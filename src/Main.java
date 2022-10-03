import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner gameScan = new Scanner(System.in);
        GameBoard gameBoard = new GameBoard();

        System.out.println("Welcome to this funny little game called Tictactoe!!");

        Player p1 = new Player(gameScan,'X');
        Player p2 = new Player(gameScan,'O');


        while (true) {
            // Player number one (x)
            p1.placeMarker(gameScan, gameBoard);
            gameBoard.print();
            if(gameBoard.hasWon(p1)){
                System.out.println("Congratulations " + p1.name + ", you have won!");
                System.out.println("Would you like to play again? (yes/no)");
                String wantToContinue = gameScan.nextLine();
                if(wantToContinue.equals("no")){
                    break;
                }
                else {
                    System.out.println("The game will now reset.");
                    gameBoard.resetBoard();
                    gameBoard.print();
                }
            }
            // If the game-board cant continue then the game is reset.
            // we have already checked if the player has won, so here we only need to check if the board is full
            if(!gameBoard.canGameContinue()){
                System.out.println("The game is unsettled, the game will now reset!");
                gameBoard.resetBoard();
            }

            //Player number two (o)
            p2.placeMarker(gameScan,gameBoard);
            gameBoard.print();
            if(gameBoard.hasWon(p2)){
                System.out.println("Congratulations " + p2.name + ", you have won!");
                System.out.println("Would you like to play again? (yes/no)");
                String wantToContinue = gameScan.nextLine();
                if(wantToContinue.equals("no")){
                    break;
                }
                else {
                    System.out.println("The game will now reset.");
                    gameBoard.resetBoard();
                    gameBoard.print();
                }
            }
            // If the game-board cant continue then the game is reset.
            // we have already checked if the player has won, so here we only need to check if the board is full
            if(!gameBoard.canGameContinue()){
                System.out.println("The game is unsettled, the game will now reset!");
                gameBoard.resetBoard();
            }
            //end of loop
            // if player x has won or the game is unsettled, then the game will continue with player o as the first player.
        }
        System.out.println("Funny to play with you, you're welcome back!");
    }
}


