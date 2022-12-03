package TicTacToe;

public class TicTacToeGame {
      /*
      To create tic-tac-toe game by using class and methods
      */
    public static void createBoard() {
        /*
        UC1->creating empty tic-tac-toe board
        */
        char[] board = new char[10];
        /*
        It takes board array indexes from 1 to 9 using for loop
        */
        for (int i = 1; i < board.length; i++) {
            System.out.print(board[i] + " ");
        }
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Tic-Tac-Toe Game");
        createBoard();
    }
}
