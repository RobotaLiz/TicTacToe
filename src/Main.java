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
                }
            }
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
                }
            }
            if(!gameBoard.canGameContinue()){
                System.out.println("The game is unsettled, the game will now reset!");
                gameBoard.resetBoard();
            }
        }
        System.out.println("Funny to play with you, you're welcome back!");
    }
}


