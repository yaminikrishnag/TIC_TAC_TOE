package com.vinay.tictactoe.Test;

import com.vinay.tictactoe.Main.Inputs;
import com.vinay.tictactoe.Main.Levels;
import com.vinay.tictactoe.Main.StartPlay;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import junit.textui.TestRunner;

/**
 * Created by nams1t on 10/31/2016.
 */

public class PerformTest extends TestCase {
    public static void main(String[] args)
    {
        TestRunner.run(new TestSuite(PerformTest.class));
    }

    public void test_matrixFill(){

        String mar1 = "x";
        String mar2 = "o";
        int continuePlay;

        StartPlay start = new StartPlay();

        do {
            // Determining the size of the board
            while (true) {
                StartPlay.N = start.getBoardSizebs();

                if (StartPlay.N <= 0) {
                    System.out.println("Size of the board must be greater than '0'!"
                            + "\nPlease enter a valid number for size!!");
                    continue;
                }
                // run board start
                break;
            }

            Inputs input_obj = new Inputs();
            Levels computer = new Levels();

            input_obj.setPlayerChar("X");
            computer.setPlayerChar("O");

            boolean won = false;
            int turns = 0;

            int first = start.decideFirstMover(turns);

            start.easyPlay(first, input_obj, computer, won, turns, start);

            continuePlay = start.startGame();

            //assertEquals();
        } while (continuePlay == 1);

    }
}
