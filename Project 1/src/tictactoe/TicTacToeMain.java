package tictactoe;

import java.util.Scanner;

public class TicTacToeMain {
    public static void main(String[] args) {
        TicTacToeClass ticTacToeClass = new TicTacToeClass();
        Scanner scan = new Scanner(System.in);
        int playerCount = 1;
        boolean whileLoopBool = !ticTacToeClass.gameFinished(playerCount);

        while(whileLoopBool){
            System.out.println(ticTacToeClass.toString());
            System.out.println("Where would you like to place your character?");
            System.out.println("Please enter a number 1 through 9.");
            int space = scan.nextInt();

            if (ticTacToeClass.isOpen(space)){
                ticTacToeClass.playTurn(space, playerCount);

                if(ticTacToeClass.gameFinished(playerCount)){
                    whileLoopBool = false;
                }
                else{
                    playerCount++;
                }
            }
            else{
                System.out.println("Either that space is taken, or that is an invalid number, please try again.");
            }
        }
        System.out.println(ticTacToeClass.toString());
        System.out.println("The game is finished!");
    }
}

//https://hendrix-cs.github.io/csci151/inclass/LightsOut.java
//https://hendrix-cs.github.io/csci151/inclass/Main.java
// I used these as models to get the project started, and took examples like the toString method, the use of the scanner try and catch.
