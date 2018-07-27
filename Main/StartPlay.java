package com.yamini.tictactoe.Main;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by yamini on 10/31/2016.
 */
public class StartPlay {
    public static int N;

    public static void main(String[] args) {
        try {
            System.out.println(" ************ Tic-Tac-Toe ************ ");
            System.out.println();

            // creat markers
            String mar1 = "x";
            String mar2 = "o";
            int continuePlay;

            StartPlay start = new StartPlay();

            do {
                // Determining the size of the board
                while (true) {
                    N = getBoardSizebs();

                    if (N <= 0) {
                        System.out.println("Size of the board must be greater than '0'!"
                                + "\nPlease enter a valid number for size!!");
                        continue;
                    }
                    // run board start
                    break;
                }
                
                continuePlay = start.startGame();
            } while (continuePlay == 1);
        } catch (InputMismatchException e) {
            System.out.println("Invalid input!! \n ");
        }
    }

    public void setPlayer(Inputs input_obj, Levels computer){
        Scanner s = new Scanner(System.in);
        while (true) {
            System.out.println("please choose your marker");
            System.out.println("\n1 for 'X' \n2 for 'O'");

            int marker = s.nextInt();
            // set markers
            if (marker == 1) {
                // create player objects
                System.out.println("You chose cross 'X'");
                input_obj.setPlayerChar("X");
                computer.setPlayerChar("O");
                break;
            } else if (marker == 2) {
                System.out.println("You chose Knought 'O'");
                input_obj.setPlayerChar("O");
                computer.setPlayerChar("X");
                break;
            } else if ((marker != 1) && (marker != 2)) {
                System.out.println("Please choose either '1' or '2'!!");
                continue;
            }
        }
    }

    public int decideFirstMover(int turns){
        int first = (int) (Math.random() * 2);

        if (first == 0) {
            System.out.println("You got to make the first move!");
            if ((N == 1) || (N == 2)) {
                System.out.println("When the board is of size 1 X 1 or 2 X 2, "
                        + "\n first player wins the game!! " + "\nCongratulations!!! You won the game!!");
                System.exit(turns);
            }
        } else {
            System.out.println("I make the first move!");
            if ((N == 1) || (N == 2)) {
                System.out.println("When the board is of size 1 X 1 or 2 X 2, "
                        + "\n first player wins the game!! " + "\n I won the game!!");
                System.exit(turns);
            }
        }

        return first;
    }

    public int startGame() {

        Scanner s = new Scanner(System.in);
        StartPlay start = new StartPlay();

        start.arrangeTheBoard();
        start.writeBoard();
        int level;
        while(true)
        {
            System.out.println("\n1 for Easy\n2 for Medium\n3 for Hard" + "\nChoose the level : ");
            level = s.nextInt();
            if(level>=1 && level<=3)
                break;
            else{
                System.out.println("\nPlease enter valid number");
                continue;
            }
        }
        System.out.println("---------------------------------------------------------------");

        if (level == 1) {
            // create player objects
            Inputs input_obj = new Inputs();
            Levels computer = new Levels();

            setPlayer(input_obj, computer);

            boolean won = false;
            int turns = 0;

            // determine who goes first
            int first = decideFirstMover(turns);

            easyPlay(first, input_obj, computer, won, turns, start);

        } else if (level == 2) {
            // create player objects
            Inputs human = new Inputs();
            Levels computer = new Levels();

            setPlayer(human, computer);
            // determine who goes first
            boolean won = false;
            int turns = 0;

            int first = decideFirstMover(turns);

            mediumPlay(first, human, computer, won, turns, start);

        } else if (level == 3) {
            // create player objects
            Inputs human = new Inputs();
            Levels hard = new Levels();

            setPlayer(human, hard);
            // determine who goes first
            boolean won = false;
            int turns = 0;

            int first = decideFirstMover(turns);

            hardPlay(first, human, hard, won, turns, start);

        } // Close of 'hard' level
        else {
            System.out.println("Please enter a valid number!");
            System.exit(level);
        }
        System.out.println("Would you like to play again? Type '1' for yes!!\n");
        System.out.println();
        return s.nextInt();
    }

    public static int getBoardSizebs() {
        Scanner s = new Scanner(System.in);
        System.out.println(
                "Please choose the size of the board! \n" + " 3 for 3X3 board,\n 4 for 4X4 board,\n 5 for 5X5 board,\n etc...");
        int _boardSize;
        _boardSize = s.nextInt();
        System.out.print("You chose a " + _boardSize + "X" + _boardSize + " board.\n");
        return _boardSize;
    }

    public static int bs() {
        return N;
    }


    int _boardSize = StartPlay.bs();
    public String[][] my_board_1 = new String [_boardSize][_boardSize];
    public boolean hasWon (String [] [] my_board)
    {
        int counter = 1;
        //horizontal
        for(int i = 0; i< _boardSize; i++)
        {
            for(int j = 0; j< _boardSize -1; j++)
            {
                if(my_board[i][j].equals(my_board[i][j+1]))
                {
                    counter = counter+1;
                }
                if(counter == _boardSize)
                {
                    return true;
                }
            }
            counter = 1;
        }

        counter = 1;
        //vertical
        for(int i = 0; i< _boardSize; i++)
        {
            for(int j = 0; j< _boardSize -1; j++)
            {
                if(my_board [j][i].equals(my_board[j+1][i]))
                {
                    counter = counter+1;
                }
                if(counter == _boardSize)
                {
                    return true;
                }
            }
            counter = 1;
        }

        counter = 1;
        //diagonal from left-top to right-bottom
        for(int i = 0; i< _boardSize -1; i++)
        {
            if(my_board[i][i].equals(my_board[i+1][i+1]))
            {
                counter = counter+1;
            }
            if (counter== _boardSize)
            {
                return true;
            }
            //counter = 1;
        }

        counter = 1;
        //diagonal from right-top to left-bottom
        for(int i = 0; i< _boardSize -1; i++)
        {
            if(my_board[i][_boardSize -1-i].equals(my_board[i+1][_boardSize -1-(i+1)]))
            {
                counter = counter+1;
            }
            if (counter== _boardSize)
            {
                return true;
            }
            //counter = 1;
        }
        return false;
    }


    int x = 1;

    public void arrangeTheBoard()
    {
        for(int i = 0; i < my_board_1.length; i++)
        {
            for(int j = 0; j < my_board_1.length; j++)
            {
                my_board_1[i][j] = "" + (x);
                x++;
            }
        }
    }

    public void writeBoard()
    {
        for(int i = 0; i < my_board_1.length; i++)
        {
            for(int j = 0; j < my_board_1.length; j++)
            {
                //System.out.print("[ - ] ");
                System.out.print("[ " + my_board_1[i][j] + " ]" + " ");
                //System.out.print(" - ");
            }
            System.out.println();
        }
    }

    public String[][] getBoard()
    {
        return my_board_1;
    }

    public void easyPlay(int first, Inputs input_obj, Levels computer, boolean won, int turns, StartPlay start){
        if (first == 0) {
            System.out.println();
            while (!won) {
                input_obj.myTurn(start.getBoard());
                turns++;
                start.writeBoard();
                if (start.hasWon(start.getBoard())) {
                    won = true;
                    System.out.println("Congrats, you won!");
                }
                if (turns == N * N) {
                    won = true;
                    // System.out.println(_boardSize*_boardSize);
                    System.out.println("Its a Tie!");
                    break;
                }
                if (!won) {
                    computer.myTurn1(start.getBoard(), input_obj);
                    turns++;
                    System.out.println();
                    start.writeBoard();
                    System.out.println();
                    if (start.hasWon(start.getBoard())) {
                        won = true;
                        System.out.println("You just lost the game");
                    }
                    if (turns == N * N) {
                        won = true;
                        System.out.println("Its a Tie!");
                        break;
                    }
                }
            } // close while 1
        } else {
            System.out.println();
            while (!won) {
                computer.myTurn1(start.getBoard(), input_obj);
                turns++;
                start.writeBoard();
                if (start.hasWon(start.getBoard())) {
                    won = true;
                    System.out.println("You just lost the game");
                }

                // checks if maximum moves are made and declares a
                // draw
                if (turns == N * N) {
                    won = true;
                    System.out.println("Its a Tie!");
                    break;
                }
                if (!won) {
                    input_obj.myTurn(start.getBoard());
                    turns++;
                    System.out.println();
                    start.writeBoard();
                    System.out.println();
                    if (start.hasWon(start.getBoard())) {
                        won = true;
                        System.out.println("You won the game!");
                    }
                    if (turns == N * N) {
                        won = true;
                        System.out.println("Its a Tie!");
                        break;
                    }
                }
            } // close while 2
        }
    }

    public void mediumPlay(int first, Inputs human, Levels computer, boolean won, int turns, StartPlay start) {
        if (first == 0) {
            System.out.println();
            while (!won) {
                human.myTurn(start.getBoard());
                turns++;
                start.writeBoard();
                if (start.hasWon(start.getBoard())) {
                    won = true;
                    System.out.println("Congrats you won!");
                }
                if (turns == N * N) {
                    won = true;
                    // System.out.println(_boardSize*_boardSize);
                    System.out.println("Its a Tie!");
                    break;
                }
                if (!won) {
                    computer.myTurn2(start.getBoard(), human);
                    turns++;
                    System.out.println();
                    start.writeBoard();
                    System.out.println();
                    if (start.hasWon(start.getBoard())) {
                        won = true;
                        System.out.println("You just lost a game to an A.I"
                                + " with an incomplete rule set.\nFACEPALM. :D");
                    }
                    if (turns == N * N) {
                        won = true;
                        System.out.println("Its a bore draw!");
                        break;
                    }
                }
            } // close while 1
        } else {
            System.out.println();
            while (!won) {
                computer.myTurn2(start.getBoard(), human);
                turns++;
                start.writeBoard();
                if (start.hasWon(start.getBoard())) {
                    won = true;
                    System.out.println("You just lost a game to an"
                            + " A.I with an incomplete rule set.\nFACEPALM. :D");
                }

                // checks if maximum moves are made and declares a
                // draw
                if (turns == N * N) {
                    won = true;
                    System.out.println("Its a draw!");
                    break;
                }
                if (!won) {
                    human.myTurn(start.getBoard());
                    turns++;
                    System.out.println();
                    start.writeBoard();
                    System.out.println();
                    if (start.hasWon(start.getBoard())) {
                        won = true;
                        System.out.println("You win!");
                    }
                    if (turns == N * N) {
                        won = true;
                        System.out.println("Its a draw!");
                        break;
                    }
                }
            } // close while 2
        }
    }

    public void hardPlay(int first, Inputs human, Levels hard, boolean won, int turns, StartPlay start) {
        if (first == 0) {
            System.out.println();
            while (!won) {
                human.myTurn(start.getBoard());
                turns++;
                start.writeBoard();
                if (start.hasWon(start.getBoard())) {
                    won = true;
                    System.out.println("Congrats you won!");
                }
                if (turns == N * N) {
                    won = true;
                    // System.out.println(_boardSize*_boardSize);
                    System.out.println("Its a Tie!");
                    break;
                }
                if (!won) {
                    hard.myTurn3(start.getBoard(), human);
                    turns++;
                    System.out.println();
                    start.writeBoard();
                    System.out.println();
                    if (start.hasWon(start.getBoard())) {
                        won = true;
                        System.out.println("You just lost the game");
                    }
                    if (turns == N * N) {
                        won = true;
                        // System.out.println(_boardSize*_boardSize);
                        System.out.println("Its a Tie!");
                        break;
                    }
                }
            } // close while 1
        } else {
            System.out.println();
            while (!won) {
                hard.myTurn3(start.getBoard(), human);
                turns++;
                start.writeBoard();
                if (start.hasWon(start.getBoard())) {
                    won = true;
                    System.out.println("You just lost a game! :(");
                }

                // checks if maximum moves are made and declares a
                // draw
                if (turns == N * N) {
                    won = true;
                    System.out.println("Its a draw!");
                    break;
                }
                if (!won) {
                    human.myTurn(start.getBoard());
                    turns++;
                    System.out.println();
                    start.writeBoard();
                    System.out.println();
                    if (start.hasWon(start.getBoard())) {
                        won = true;
                        System.out.println("Congratulations! You won! you owe me a chocolate! :D");
                    }
                    if (turns == N * N) {
                        won = true;
                        System.out.println("Its a Tie!");
                        break;
                    }
                }
            } // close while 2
        }
    }
}
