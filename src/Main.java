import java.lang.management.GarbageCollectorMXBean;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner gameScan = new Scanner(System.in);
        // Here we have a Game board whit numbers in it, I think it's easier to understand the bord this way.
        char[][] GameBoard = {{' ', '|', ' ', '|', ' ' },//0
                {'-', '+', '-', '+', '-' },//1
                {' ', '|', ' ', '|', ' ' },//2
                {'-', '+', '-', '+', '-' },//3
                {' ', '|', ' ', '|', ' ' }};//4
        //0         2         4

        while (true) {
            // Player number one (x)
            System.out.println("Choose between (1-9) in the game-board");
            String choosenum = gameScan.nextLine();
            if (isValidPosition(GameBoard, choosenum)){
                WritePositionToBoard(GameBoard, choosenum, 'x');
                
            }
            System.out.println(hasWon(GameBoard, "xxx"));
            printBoard(GameBoard);
            if(!canGameContinue(GameBoard)){
                break;
            }

            //Player number two (o)
            System.out.println("Choose between (1-9) in the game-board");
            String choosenum1 = gameScan.nextLine();
            System.out.println( "is valid" + isValidPosition(GameBoard, choosenum1));
            if (isValidPosition(GameBoard,choosenum1)){
                WritePositionToBoard(GameBoard, choosenum1, 'o');
            }

            System.out.println(hasWon(GameBoard, "ooo"));
            printBoard(GameBoard);
            if(!canGameContinue(GameBoard)){
                break;
            }


        }


    }
    public static boolean isValidPosition(char[][]gameBoard, String position){
        switch (position){
            case "1":
                if (gameBoard[0][0] ==' ')
                    return true;
                break;
            case "2":
               if (gameBoard[0][2] == ' ')
                   return true;
                break;
            case "3":
                if (gameBoard[0][4] == ' ')
                    return true;
                break;
            case "4":
                if (gameBoard[2][0] == ' ')
                    return true;
                break;
            case "5":
                if (gameBoard[2][2] == ' ')
                    return true;
                break;
            case "6":
                if (gameBoard[2][4] == ' ')
                    return true;
                break;
            case "7":
               if (gameBoard[4][0] == ' ')
                    return true;
                break;
            case "8":
                if (gameBoard[4][2] == ' ')
                    return true;
                break;
            case "9":
               if (gameBoard[4][4] == ' ')
                   return true;
                break;


        }
        return false;
    }

    // This method writes the chosen position to the board
    public static void WritePositionToBoard(char[][] gameBoard, String position, char symbol) {
        // I build this switch so that the player can choose a position.
        // The responsibility of this method is to write a symbol to a position on the board
        switch (position) {
            case "1":
                gameBoard[0][0] = symbol;
                break;
            case "2":
                gameBoard[0][2] = symbol;
                break;
            case "3":
                gameBoard[0][4] = symbol;
                break;
            case "4":
                gameBoard[2][0] = symbol;
                break;
            case "5":
                gameBoard[2][2] = symbol;
                break;
            case "6":
                gameBoard[2][4] = symbol;
                break;
            case "7":
                gameBoard[4][0] = symbol;
                break;
            case "8":
                gameBoard[4][2] = symbol;
                break;
            case "9":
                gameBoard[4][4] = symbol;
                break;

        }
    }

    // Here is the method for printing out the game board.
    //this method takes a two-dimensional-char-array gameBoard
    public static void printBoard(char[][] GameBoard) {
        // this for-each loop goes through all the rows in the gameboard
        for (char[] row : GameBoard) {
            //this for-each loop goes through every position in the row
            for (char position : row) {
                System.out.print(position);
            }
            System.out.println();


        }
    }

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


