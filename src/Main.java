import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner gameScan = new Scanner(System.in);

             GameBoard playGround = new GameBoard();



        while (true) {
            // Player number one (x)
            System.out.println("Choose between (1-9) in the game-board");
            String choosenum = gameScan.nextLine();
            if (playGround.isValidPosition(choosenum)){
                playGround.WritePositionToBoard( choosenum, 'x');
                
            }
            System.out.println(hasWon(playGround.board, "xxx"));
            playGround.print();
            if(!canGameContinue(playGround.board)){
                break;
            }

            //Player number two (o)
            System.out.println("Choose between (1-9) in the game-board");
            String choosenum1 = gameScan.nextLine();
            System.out.println( "is valid" + playGround.isValidPosition(choosenum1));
            if (playGround.isValidPosition(choosenum1)){
                playGround.WritePositionToBoard( choosenum1, 'o');
            }

            System.out.println(hasWon(playGround.board, "ooo"));
            playGround.print();
            if(!canGameContinue(playGround.board)){
                break;
            }


        }


    }


    // This method writes the chosen position to the board


    // Here is the method for printing out the game board.
    //this method takes a two-dimensional-char-array gameBoard


    // method that checks if someone has won in horizontal way.
    public static boolean horizontal(char[][] gameBoard, String player) {
        String firstRow = charsToString(gameBoard[0][0], gameBoard[0][2], gameBoard[0][4]);
        String secondRow = charsToString(gameBoard[2][0], gameBoard[2][2], gameBoard[2][4]);
        String thirdRow = charsToString(gameBoard[4][0], gameBoard[4][2], gameBoard[4][4]);
        if (firstRow.equals(player)) {
            return true;

        } else if (secondRow.equals(player)) {
            return true;
        } else if (thirdRow.equals(player)) {
            return true;
        }
        return false;

    }

    public static boolean vertical(char[][] gameBoard, String player) {
        String firstRow = charsToString(gameBoard[0][0], gameBoard[2][0], gameBoard[4][0]);
        String secondRow = charsToString(gameBoard[0][2], gameBoard[2][2], gameBoard[4][2]);
        String thirdRow = charsToString(gameBoard[0][4], gameBoard[2][4], gameBoard[4][4]);
        if (firstRow.equals(player)) {
            return true;
        } else if (secondRow.equals(player)) {
            return true;
        } else if (thirdRow.equals(player)) {
            return true;
        }
        return false;
    }

    public static boolean diagonal(char[][] gameBoard, String player) {
        String firstRow = charsToString(gameBoard[0][0], gameBoard[2][2], gameBoard[4][4]);
        String secondRow = charsToString(gameBoard[0][4], gameBoard[2][2], gameBoard[4][0]);
        if (firstRow.equals(player)) {
            return true;
        } else if (secondRow.equals(player)) {
            return true;
        }
        return false;

    }

    // this method converts three seperate chars to a string.
    public static String charsToString(char a, char b, char c) {
        char[] array = new char[]{a, b, c};
        return String.valueOf(array);
    }
     //method that is checking if a player won.
    public static boolean hasWon(char[][] gameBoard, String player) {

        if (diagonal(gameBoard, player) || horizontal(gameBoard, player) || vertical(gameBoard, player)) {
            return true;
        }
        return false;
    }
    //in this method we check if we can continue the game.
    public static boolean canGameContinue (char[][]gameBoard){
        int counter = 0;
        for(int i = 0; i < gameBoard.length; i += 2 ){
            char[] row = gameBoard[i];
            for(int k = 0 ; k < row.length; k += 2){
                char symbol = row [k];
                if(symbol != ' '){
                    counter ++;


                }
            }

        }
        if(counter == 9){
            return false;
        }else{
            return true;

        }
    }
}


