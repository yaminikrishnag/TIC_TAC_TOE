package com.yamini.tictactoe.Main;

import java.util.Scanner;


public class Inputs extends User {
    public void myTurn(String[][] board)
    {
        Scanner myScan = new Scanner(System.in);
        boolean myTurn = true;
        int bs = StartPlay.bs();
        int row,col;
        System.out.println("---------------------------------------------------------------");
        while(myTurn)
        {
            while(true){
                System.out.println("please enter row");
                row = myScan.nextInt();
                System.out.println("please enter col");
                col = myScan.nextInt();

                System.out.print("you entered "+row+" "+col);
                System.out.println();
                if(row<1 || row>bs || col<1 ||col>bs)
                {
                    System.out.println("Enter valid numbers for placing the marker!!");
                    continue;
                }
                break;
            }
            if(!"X".equals(board[row - 1][col - 1]) && !"O".equals(board[row - 1][col - 1]))
            {
                board[row - 1][col - 1] = playerChar;
                myTurn = false;
            } // closes if
            else
            {
                System.out.println("Already Marker here! please guess again!");

            }
        }
    }
}
