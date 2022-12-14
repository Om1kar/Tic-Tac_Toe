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
        It takes board array indexes from 1 to 9 using for loop
         */
        for (int i = 1; i < board.length; i++) {
            board[i] = ' ';
        }
    }

    public static void chooseLetter() {
        /*
        UC2->allow player to choose a letter
         */
        System.out.println("\nChoose your Letter X or O");
        Scanner scanner = new Scanner(System.in);
        playerLetter = scanner.next().toUpperCase().charAt(0);
        if (playerLetter == 'X') {
            computerLetter='O';
            System.out.println("You've selected =" + playerLetter);
            System.out.println("opponent Selected ="+computerLetter);
        } else{
            computerLetter= 'O';
            playerLetter ='X';
           System.out.println("You've selected =" + playerLetter);
            System.out.println("Opponent Selected =" + computerLetter);
        }
    }
    public static void toDisplayBoard() {
        /*
        UC3-> To print the board having 9 indexes
         */
        System.out.println(board[1] + " | " + board[2] + " | " + board[3]);
        System.out.println("----------");
        System.out.println(board[4] + " | " + board[5] + " | " + board[6]);
        System.out.println("----------");
        System.out.println(board[7] + " | " + board[8] + " | " + board[9]);
    }
    public static void toMakeAMove() {
        /*
        UC4->To make A move
        used if else condition
        */
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your number between 1 to 9 ");
        int position = scanner.nextInt();
        if (position <= 9 && position >= 1) {
            board[position] = playerLetter;
            toDisplayBoard();
            checkFreeSpace();
            decideWinner();
            toMakeAMove();

        } else if (board[position] != ' ') {
            System.err.println("You already choose");
            toMakeAMove();
        } else {
            System.err.println("Enter location between 1 to 9");
            toMakeAMove();
        }
    }
    public static void checkFreeSpace() {
        /*
        UC5->Check for free space in game board
         */
        boolean spaceAvailable = false;
        int freeSpace = 0;
        for (int i = 1; i < board.length; i++) {
            if ((board[i] == ' ')) {
                spaceAvailable = true;
                freeSpace++;
            }
        }
        if (spaceAvailable == false) {
            System.err.println("Board is full");
            System.exit(0);
        } else {
            System.out.println("You have " + freeSpace + " moves left To Play");
        }
    }
    public static void Toss() {
        /*
        UC6->Using math.random function to decide who plays first
         */
        int Toss = (int) Math.floor(Math.random() * 10) % 2 + 1;
        switch (Toss) {
            case 1:
                System.out.println("You Won the Toss Play First");
                break;
            default:
                System.out.println("Opponent Won The Toss");
        }
    }

    public static void decideWinner() {
        /*
       UC7-> checking letter filled horizontally and vertically in game board
         */
         if     ((board[1] == playerLetter && board[2] == playerLetter && board[3] == playerLetter) ||
                (board[4] == playerLetter && board[5] == playerLetter && board[6] == playerLetter) ||
                (board[7] == playerLetter && board[8] == playerLetter && board[9] == playerLetter) ||
                (board[1] == playerLetter && board[5] == playerLetter && board[9] == playerLetter) ||
                (board[3] == playerLetter && board[5] == playerLetter && board[7] == playerLetter) ||
                (board[1] == playerLetter && board[4] == playerLetter && board[7] == playerLetter) ||
                (board[2] == playerLetter && board[5] == playerLetter && board[8] == playerLetter)||
                 (board[3] == playerLetter && board[6] == playerLetter && board[9] == playerLetter)) {
            toDisplayBoard();
            System.out.println("YOU WON THE GAME");
            System.exit(0);
         } else if(((board[1] == computerLetter && board[2] == computerLetter && board[3] == computerLetter) ||
                 (board[4] == computerLetter && board[5] == computerLetter && board[6] == computerLetter) ||
                 (board[7] == computerLetter && board[8] == computerLetter && board[9] == computerLetter) ||
                 (board[1] == computerLetter && board[5] == computerLetter && board[9] == computerLetter) ||
                 (board[3] == computerLetter && board[5] == computerLetter && board[7] == computerLetter) ||
                 (board[1] ==computerLetter && board[4] == computerLetter && board[7] == computerLetter) ||
                 (board[2] == computerLetter && board[5] == computerLetter && board[8] == computerLetter)||
                 (board[3] == computerLetter && board[6] == computerLetter && board[9] == computerLetter))) {
             toDisplayBoard();
             System.out.println("YOU LOST THE GAME\nOPPONENT WON THE GAME");
             System.exit(0);
         } else if (board[1] != ' ' && board[2] != ' ' && board[3] != ' '
                    && board[4] != ' ' && board[5] != ' ' && board[6] != ' '
                    && board[7]!=' '&& board[8]!=' '&& board[9]!=' ') {
             System.out.println("MATCH IS DRAW PLAY AGAIN");
             System.exit(0);
         }
    }

    public static void playerMove() {
        int playerMove;
        while (true) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter No between[1 to 9] To Move Letter in Empty Box");
            playerMove = scanner.nextInt();
            if (board[playerMove] == ' ') {
                break;
            }
        }
        System.out.println("Player choose = " + playerMove);
        board[playerMove] = playerLetter;
    }

    public static void computerMove() {
        int computerMove;
        while (true) {
            computerMove = (int) Math.floor(Math.random() * 10) % 9 + 1;
            if (board[computerMove] == ' ') {
                break;
            }
        }
        System.out.println("Computer choose = " + computerMove);
        board[computerMove] = computerLetter;
    }

    public static void main(String[] args) {
        System.out.println("-----Welcome To Tic-Tac-Toe Game-----");
        /*
        Static Method Calling----
         */
        System.out.println("--------Toss a Coin To Begin Game-------");
        Toss();
        createBoard();
        toDisplayBoard();
        chooseLetter();
        while (true) {
            playerMove();
            computerMove();
            toDisplayBoard();
            checkFreeSpace();
            decideWinner();
        }
    }
}