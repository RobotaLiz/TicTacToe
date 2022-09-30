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
    public void WritePositionToBoard(String position, Player player) {
        // I build this switch so that the player can choose a position.
        // The responsibility of this method is to write a symbol to a position on the board
        switch (position) {
            case "1":
                board[0][0] = player.symbol;
                break;
            case "2":
                board[0][2] = player.symbol;
                break;
            case "3":
                board[0][4] = player.symbol;
                break;
            case "4":
                board[2][0] = player.symbol;
                break;
            case "5":
                board[2][2] = player.symbol;
                break;
            case "6":
                board[2][4] = player.symbol;
                break;
            case "7":
                board[4][0] = player.symbol;
                break;
            case "8":
                board[4][2] = player.symbol;
                break;
            case "9":
                board[4][4] = player.symbol;
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
    }   private boolean diagonal(String player) {
        String firstRow = charsToString(board[0][0], board[2][2], board[4][4]);
        String secondRow = charsToString(board[0][4], board[2][2], board[4][0]);
        if (firstRow.equals(player)) {
            return true;
        } else if (secondRow.equals(player)) {
            return true;
        }
        return false;

    }
    // method that checks if someone has won in horizontal way.
    private boolean horizontal(String player) {
        String firstRow = charsToString(board[0][0], board[0][2], board[0][4]);
        String secondRow = charsToString(board[2][0], board[2][2], board[2][4]);
        String thirdRow = charsToString(board[4][0], board[4][2], board[4][4]);
        if (firstRow.equals(player)) {
            return true;

        } else if (secondRow.equals(player)) {
            return true;
        } else if (thirdRow.equals(player)) {
            return true;
        }
        return false;

    }

    private boolean vertical(String player) {
        String firstRow = charsToString(board[0][0], board[2][0], board[4][0]);
        String secondRow = charsToString(board[0][2], board[2][2], board[4][2]);
        String thirdRow = charsToString(board[0][4], board[2][4], board[4][4]);
        if (firstRow.equals(player)) {
            return true;
        } else if (secondRow.equals(player)) {
            return true;
        } else if (thirdRow.equals(player)) {
            return true;
        }
        return false;
    }


    // this method converts three seperate chars to a string.
    private String charsToString(char a, char b, char c) {
        char[] array = new char[]{a, b, c};
        return String.valueOf(array);
    }
    //method that is checking if a player won.
    public boolean hasWon (Player player) {
        String playerRow = charsToString(player.symbol, player.symbol, player.symbol);
        if (diagonal(playerRow) || horizontal(playerRow) || vertical(playerRow)) {
            return true;
        }
        return false;
    }
    public boolean canGameContinue (){
        int counter = 0;
        for(int i = 0; i < board.length; i += 2 ){
            char[] row = board[i];
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

