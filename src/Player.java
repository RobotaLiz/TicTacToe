import java.util.Scanner;

public class Player {
    String name;
    char symbol;

    public Player(String name,char symbol){
        this.name = name;
        this.symbol = symbol;
    }
    public Player(Scanner createPlayerScan, char symbol){
        System.out.println("What is your name player "+symbol);
        this.name = createPlayerScan.nextLine();
        this.symbol = symbol;
    }
    public void placeMarker(Scanner scanPlayerinput, GameBoard gameBoard){
        System.out.println(name + " Choose between (1-9) in the game-board");
        while(true){
            String choosenum = scanPlayerinput.nextLine();
            if(gameBoard.isValidPosition(choosenum)){
                gameBoard.WritePositionToBoard(choosenum, this);
                break;

            }else{
                System.out.println("Your chosen number is not valid, please try again!");
            }
        }
    }

}
