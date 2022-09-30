// Here we have a Game board whit numbers in it, I think it's easier to understand the bord this way.
public class GameBoard {

    char[][] board;


    public GameBoard(){
        board = new char[][]{{' ', '|', ' ', '|', ' ' },//0
                {'-', '+', '-', '+', '-' },//1
                {' ', '|', ' ', '|', ' ' },//2
                {'-', '+', '-', '+', '-' },//3
                {' ', '|', ' ', '|', ' ' }};//4
        //        0         2         4

    }
    public void print () {
        // this for-each loop goes through all the rows in the gameboard
        for (char[] row : board) {
            //this for-each loop goes through every position in the row
            for (char position : row) {
                System.out.print(position);
            }
            System.out.println();


        }
    }




    public void WritePositionToBoard(String position, char symbol) {
        // I build this switch so that the player can choose a position.
        // The responsibility of this method is to write a symbol to a position on the board
        switch (position) {
            case "1":
                board[0][0] = symbol;
                break;
            case "2":
                board[0][2] = symbol;
                break;
            case "3":
                board[0][4] = symbol;
                break;
            case "4":
                board[2][0] = symbol;
                break;
            case "5":
                board[2][2] = symbol;
                break;
            case "6":
                board[2][4] = symbol;
                break;
            case "7":
                board[4][0] = symbol;
                break;
            case "8":
                board[4][2] = symbol;
                break;
            case "9":
                board[4][4] = symbol;
                break;

        }
    }    public boolean isValidPosition(String position){
        switch (position){
            case "1":
                if (board [0][0] ==' ')
                    return true;
                break;
            case "2":
                if (board[0][2] == ' ')
                    return true;
                break;
            case "3":
                if (board[0][4] == ' ')
                    return true;
                break;
            case "4":
                if (board[2][0] == ' ')
                    return true;
                break;
            case "5":
                if (board[2][2] == ' ')
                    return true;
                break;
            case "6":
                if (board [2][4] == ' ')
                    return true;
                break;
            case "7":
                if (board[4][0] == ' ')
                    return true;
                break;
            case "8":
                if (board[4][2] == ' ')
                    return true;
                break;
            case "9":
                if (board[4][4] == ' ')
                    return true;
                break;


        }
        return false;
    }
}

