import java.util.Scanner;

public class Player {
    // These are instansvariabels.
    String name;
    char symbol;

    // A constructor that takes a scanner and a symbol and then lets the player chose the name.
    public Player(Scanner createPlayerScan, char symbol){
        System.out.println("What is your name player "+symbol + " ?");
        this.name = createPlayerScan.nextLine();
        this.symbol = symbol;
    }
    // This is a method that is responsible for letting the player chose a position and then write that position to the
    // board. If the player chooses a position that is not valid they have to try a new position.
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
