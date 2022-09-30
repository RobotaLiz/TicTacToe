import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner gameScan = new Scanner(System.in);

             GameBoard playGround = new GameBoard();
             Player p1 = new Player("Liza", 'o');
             Player p2 = new Player("Anders", 'x');






        while (true) {
            // Player number one (x)
            System.out.println(p1.name + " Choose between (1-9) in the game-board");
            String choosenum = gameScan.nextLine();
            if (playGround.isValidPosition(choosenum)){
                playGround.WritePositionToBoard( choosenum, p1);
                
            }
            System.out.println(playGround.hasWon(p1));
            playGround.print();
            if(!playGround.canGameContinue()){
                break;
            }

            //Player number two (o)
            System.out.println(p2.name + " Choose between (1-9) in the game-board");
            String choosenum1 = gameScan.nextLine();
            System.out.println( "is valid" + playGround.isValidPosition(choosenum1));
            if (playGround.isValidPosition(choosenum1)){
                playGround.WritePositionToBoard( choosenum1, p2);
            }

            System.out.println( playGround.hasWon ( p2));
            playGround.print();
            if(!playGround.canGameContinue()){
                break;
            }


        }


    }


}


