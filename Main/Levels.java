package com.vinay.tictactoe.Main;

/**
 * Created by nams1t on 10/31/2016.
 */
public class Levels extends User {
    public void myTurn1(String[][] board, Inputs human)
    {
        StartPlay mySetup = new StartPlay();
        int bs = StartPlay.bs();
        int r1 = 0;
        int r2 = 0;
        boolean mademove = false;
        while(!mademove)
        {
            r1 = (int) (Math.random() * bs);
            r2 = (int) (Math.random() * bs);

            int rand11,rand22;

            if(!"X".equals(board[r1][r2]) && !"O".equals(board[r1][r2]))
            {
                rand11 = r1+1;
                rand22 = r2+1;
                System.out.println("\nI am placing the marker at: "+rand11+" "+rand22);
                board[r1][r2] = playerChar;
                mademove = true;
            }
        }
    }

    public void myTurn2(String[][] board, Inputs human)
    {
        boolean moving = false;

        StartPlay mySetup = new StartPlay();
        int bs = StartPlay.bs();
        int counter = 1;
        // check if you can take a win vertically
        for(int a = 0; a<bs; a++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[j][a].equals(board[j+1][a]) && board[j][a].equals(playerChar))
                        || (board[j][a].equals(board[j+2][a]) && board[j][a].equals(playerChar))
                        || (board[j+1][a].equals(board[j+2][a]) && board[j+1][a].equals(playerChar)))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0;k<bs;k++)
                    {
                        if(!board[k][a].equals(human.getPlayerChar()) && !board[k][a].equals(playerChar))
                        {
                            board[k][a] = playerChar;
                            moving = true;
                            return;
                        }
                    }
                }
            }
            counter = 1;
        }

        counter = 1;

        for(int i = 0; i<bs; i++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[i][j].equals(board[i][j+1]) && board[i][j].equals(playerChar))
                        ||(board[i][j].equals(board[i][j+2]) && board[i][j].equals(playerChar))
                        || (board[i][j+1].equals(board[i][j+2]) && board[i][j+1].equals(playerChar)))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0; k<bs; k++)
                    {
                        if(!board[i][k].equals(human.getPlayerChar()) && !board[i][k].equals(playerChar))
                        {
                            board[i][k] = playerChar;
                            moving = true;
                            return;
                        }
                    }
                }
            }
            counter = 1;
        }

        counter = 1;

        // check if you can take a win diagonally left-top to right-bottom
        for(int j=1;j<bs;j++)
        {
            int i=0;
            if(board[i][i].equals(board[j][j]) && board[j][j].equals(playerChar))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][k].equals(human.getPlayerChar()) && !board[k][k].equals(playerChar))
                    {
                        board[k][k] = playerChar;
                        moving = true;
                        return;
                    }
                }
            }
        }

        counter = 1;
        for(int j=bs-2;j>=0;j--)
        {
            int i=bs-1;
            if(board[i][i].equals(board[j][j]) && board[j][j].equals(playerChar))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][k].equals(human.getPlayerChar()) && !board[k][k].equals(playerChar))
                    {
                        board[k][k] = playerChar;
                        moving = true;
                        return;
                    }
                }
            }
        }

        counter = 1;

        for(int i=0;i<bs-2;i++)
        {
            if(board[i][bs-1-i].equals(board[i+1][bs-1-i-1]) && board[i][bs-1-i].equals(playerChar))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs-1;k++)
                {
                    if(!board[k][bs-1-k].equals(human.getPlayerChar()) && !board[k][bs-1-k].equals(playerChar))
                    {
                        board[k][bs-1-k] = playerChar;
                        moving = true;
                        return;
                    }
                }
            }
        }

        int r1 = 0;
        int r2 = 0;

        while(!moving)
        {
            r1 = (int) (Math.random() * bs);
            r2 = (int) (Math.random() * bs);

            int rand11,rand22;
            if(!"X".equals(board[r1][r2]) && !"O".equals(board[r1][r2]))
            {
                rand11 = r1+1;
                rand22 = r2+1;
                System.out.println("\nI am placing the marker at: "+rand11+" "+rand22);
                board[r1][r2] = playerChar;
                moving = true;
            }
        }
    }


    public void myTurn3(String[][] board, Inputs inputs)
    {
        boolean mademove = false;

        StartPlay mySetup = new StartPlay();
        int bs = StartPlay.bs();
        int counter = 1;
        for(int a = 0; a<bs; a++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[j][a].equals(board[j+1][a]) && board[j][a].equals(playerChar))
                        || (board[j][a].equals(board[j+2][a]) && board[j][a].equals(playerChar))
                        || (board[j+1][a].equals(board[j+2][a]) && board[j+1][a].equals(playerChar)))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0;k<bs;k++)
                    {
                        if(!board[k][a].equals(inputs.getPlayerChar()) && !board[k][a].equals(playerChar))
                        {
                            board[k][a] = playerChar;
                            mademove = true;
                            return;
                        }
                    }
                }
            }
            counter = 1;
        }

        counter = 1;
        for(int i = 0; i<bs; i++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[i][j].equals(board[i][j+1]) && board[i][j].equals(playerChar))
                        ||(board[i][j].equals(board[i][j+2]) && board[i][j].equals(playerChar))
                        || (board[i][j+1].equals(board[i][j+2]) && board[i][j+1].equals(playerChar)))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0; k<bs; k++)
                    {
                        if(!board[i][k].equals(inputs.getPlayerChar()) && !board[i][k].equals(playerChar))
                        {
                            board[i][k] = playerChar;
                            mademove = true;
                            return;
                        }
                    }
                }

            }
            counter = 1;
        }

        counter = 1;
        for(int i=0;i<bs;i++)
        {
            for(int j=0;j<bs;j++)
            {
                if(i!=j)
                {
                    if(board[i][i].equals(board[j][j]) && board[j][j].equals(playerChar))
                    {
                        counter = counter+1;
                    }
                    if(counter == bs-1)
                    {
                        for(int k=0;k<bs;k++)
                        {
                            if(!board[k][k].equals(inputs.getPlayerChar()) && !board[k][k].equals(playerChar))
                            {
                                board[k][k] = playerChar;
                                mademove = true;
                                return;
                            }
                        }
                    }
                }
            }
        }
        counter = 1;

        for(int j=bs-2;j>=0;j--)
        {
            int i=bs-1;
            if(board[i][i].equals(board[j][j]) && board[j][j].equals(playerChar))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][k].equals(inputs.getPlayerChar()) && !board[k][k].equals(playerChar))
                    {
                        board[k][k] = playerChar;
                        mademove = true;
                        return;
                    }
                }
            }
        }

        counter = 1;

        for(int i=0;i<bs-2;i++)
        {
            if(board[i][bs-1-i].equals(board[i+1][bs-1-i-1]) && board[i][bs-1-i].equals(playerChar))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs-1;k++)
                {
                    if(!board[k][bs-1-k].equals(inputs.getPlayerChar()) && !board[k][bs-1-k].equals(playerChar))
                    {
                        board[k][bs-1-k] = playerChar;
                        mademove = true;
                        return;
                    }
                }
            }
        }

        counter = 1;
        for(int a = 0; a<bs; a++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if((board[a][j].equals(board[a][j+1]) && board[a][j].equals(inputs.getPlayerChar()))
                        ||(board[a][j].equals(board[a][j+2]) && board[a][j].equals(inputs.getPlayerChar()))
                        || (board[a][j+1].equals(board[a][j+2]) && board[a][j+1].equals(inputs.getPlayerChar())))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0;k<bs;k++)
                    {
                        if(!board[a][k].equals(inputs.getPlayerChar()) && !board[a][k].equals(playerChar))
                        {
                            System.out.println("I am placing the marker at: "+a+" "+k);
                            board[a][k] = playerChar;
                            mademove = true;
                            return;
                        }
                    }
                }
            }
            counter = 1;
        }

        counter = 1;
        // check if you can block a win vertically
        for(int i = 0; i<bs; i++)
        {
            for(int j=0; j<bs-2; j++)
            {
                if(board[j][i].equals(board[j+1][i]) && board[j][i].equals(inputs.getPlayerChar())
                        || (board[j][i].equals(board[j+2][i]) && board[j][i].equals(inputs.getPlayerChar()))
                        || (board[j+1][i].equals(board[j+2][i]) && board[j+1][i].equals(inputs.getPlayerChar())))
                {
                    counter = counter+1;
                }
                if(counter == bs-1)
                {
                    for(int k=0; k<bs; k++)
                    {
                        if(!board[i][k].equals(inputs.getPlayerChar()) && !board[i][k].equals(playerChar))
                        {
                            System.out.println("I am placing the marker at: "+k+" "+i);
                            board[k][i] = playerChar;
                            mademove = true;
                            return;
                        }
                    }
                }
                //}
            }
            counter = 1;
        }


        counter = 1;
        for(int j=1;j<bs;j++)
        {
            int i=0;
            if(board[i][i].equals(board[j][j]) && board[j][j].equals(inputs.getPlayerChar()))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][k].equals(inputs.getPlayerChar()) && !board[k][k].equals(playerChar))
                    {
                        System.out.println("I am placing the marker at: "+k+" "+k);
                        board[k][k] = playerChar;
                        mademove = true;
                        return;
                    }
                }
            }
        }

        //Check if you can block a win diagonally from right-top to left-bottom
        counter = 1;
        for(int i=0;i<bs-1;i++)
        {
            if(board[i][bs-1-i].equals(board[i+1][bs-1-i-1]) && board[i][bs-1-i].equals(inputs.getPlayerChar()))
            {
                counter = counter+1;
            }
            if(counter == bs-1)
            {
                for(int k=0;k<bs;k++)
                {
                    if(!board[k][bs-1-k].equals(inputs.getPlayerChar()) && !board[k][bs-1-k].equals(playerChar))
                    {
                        System.out.println("I am placing the marker at: "+k+" "+(bs-1-k));
                        board[k][bs-1-k] = playerChar;
                        mademove = true;
                        return;
                    }
                }
            }
        }

        // make random move if above rules dont apply
        int r1 = 0;
        int r2 = 0;

        while(!mademove)
        {
            r1 = (int) (Math.random() * bs);
            r2 = (int) (Math.random() * bs);

            int r11,r22;
            if(!"X".equals(board[r1][r2]) && !"O".equals(board[r1][r2]))
            {
                r11 = r1+1;
                r22 = r2+1;
                System.out.println("\nI am placing the marker at: "+r11+" "+r22);
                board[r1][r2] = playerChar;
                mademove = true;
            }
        }
    }
}
