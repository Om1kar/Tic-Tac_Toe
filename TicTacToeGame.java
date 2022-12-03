package TicTacToe;

import java.util.Scanner;

public class TicTacToeGame {
    /*
    To create tic-tac-toe game by using class and methods
    */
    static char board[] = new char[10];
    static char playerLetter;
    static char computerLetter;

    public static void createBoard() {
        /*
        UC1->creating empty tic-tac-toe board
        */
        /*
        It takes board array indexes from 1 to 9 using for loo
         */
        for (int i = 1; i < board.length; i++) {
            System.out.print(board[i] + " ");
        }
    }

    public static void chooseLetter() {
        /*
        UC2->allow player to choose a letter
         */
        System.out.println("\nChoose your Letter Either X or O");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your Letter");
        playerLetter = scanner.next().toUpperCase().charAt(0);
        if (playerLetter == 'X') {
            System.out.println(playerLetter);
        } else {
            System.out.println(computerLetter == 'O');
        }
    }

    public static void toDisplayBoard() {
        /*
        UC3-> To print the current board
         */
        System.out.println(board[1] + "|" + board[2] + "|" + board[3]);
        System.out.println("------");
        System.out.println(board[4] + "|" + board[5] + "|" + board[6]);
        System.out.println("------");
        System.out.println(board[7] + "|" + board[8] + "|" + board[9]);
    }

    public static void main(String[] args) {
        System.out.println("Welcome To Tic-Tac-Toe Game");
        createBoard();
        chooseLetter();
        toDisplayBoard();

    }
}
