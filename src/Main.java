import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Board board = new Board();
        Scanner scanner = new Scanner(System.in);
        boolean endOfGame = true;
        int currentPlayer = 1, emptySquareInColumn;
        while (endOfGame) {
            System.out.println("Where do you want to place tour square? (1-7)");
            int userInput = scanner.nextInt();
            if (userInput >= 1 && userInput <= 7) {
                emptySquareInColumn = checkEmptySquare(board, userInput);
                while (!(emptySquareInColumn >= 1 && emptySquareInColumn <= 7)){
                    System.out.println("Column " + userInput + " Select another column");
                    userInput = scanner.nextInt();
                    emptySquareInColumn = checkEmptySquare(board, userInput);
                }
                board.placeSquare(userInput, emptySquareInColumn , currentPlayer);
                if (currentPlayer == 2) {
                    if (win(board)){
                        System.out.println("Coagulation user " + currentPlayer + " you won");
                        endOfGame = false;
                    }
                    currentPlayer = 1;
                } else {
                    if (win(board)){
                        System.out.println("Coagulation user " + currentPlayer + " you won");
                        endOfGame = false;
                    }
                    currentPlayer = 2;
                }
            } else {
                System.out.println("Invalid position");
            }

        }
    }
    public static int checkEmptySquare (Board board, int columns){
        for (int i = 1; i <= 7; i++) {
            if (board.getPlayerInSquare(columns, i) == 0)
                return i;
        }

        return 8;
    }


    public static boolean win (Board board) {
        if (checkWinRows(board))
            return true;
        if (checkWinColumns(board))
            return true;
        return checkWinDiagonal(board);
    }
    public static boolean checkWinRows(Board board) {
        int[] arr = {0, 0};
        for (int i = 1; i <= 7; i++){
            arr[0] = 0;
            arr[1] = 0;
            for (int j = 1; j <= 7; j++){
                int a = board.getPlayerInSquare(j, i);
                if (a == 1) {
                   arr[0] ++;
                   if (arr[0] == 4)
                       return true;
                }
                if (a == 2){
                    arr[1] ++;
                    if (arr[1] == 4)
                        return true;
                }
            }
        }
            return false;
    }
    public static boolean checkWinColumns(Board board) {
        int[] arr = {0, 0};
        for (int i = 1; i <= 7; i++){
            arr[0] = 0;
            arr[1] = 0;
            for (int j = 1; j <= 7; j++){
                int a = board.getPlayerInSquare(i, j);
                if (a == 1) {
                    arr[0] ++;
                    if (arr[0] == 4)
                        return true;
                }
                if (a == 2){
                    arr[1] ++;
                    if (arr[1] == 4)
                        return true;
                }
            }
        }
        return false;
    }
    public static boolean checkWinDiagonal(Board board) {

        return false;
    }








    //Method 1: Board board = new Board();
    //This method shows the initial empty board


    //Method 2: placeSquare (int x, int y, int player)
    //This method gets 3 arguments
    //x is the x position of the square to be placed
    //y is the y position of the square to be placed
    //player can be either of value 1 or 2. For the value 1, a red square is being placed, For the value 2, a yellow square


    //Method 2: int getPlayerInSquare (int x, int y)
    //This method gets 2 arguments
    //x is the x position of the asked square
    //y is the y position of the asked square
    //The method returns an int value: if the value is 0 - the square is empty, if the value is 1 - the square is occupied by
    //player 1, if the value is 2 - the square is occupied by player 2


}
