package normal;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Random;

/**
 * 五子棋，输入坐标实现落子，电脑随机落子
 * Created by Lenovo on 2015/4/7.
 */

public class Gobang
{
    private final int BOARD_SIZE = 15;
    private String[][] dot = new String[BOARD_SIZE][BOARD_SIZE];
    private static int count1, count2;

    public static void main(String[] args) throws Exception
    {
        Gobang gb = new Gobang();
        gb.initBoard();
        gb.printBoard();
        System.out.println("Please select a dot: ");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = null;
        while((inputStr=br.readLine()) != null)
        {
            String[] posStrArr = inputStr.split(",");
            int xPos = Integer.parseInt(posStrArr[0]);
            int yPos = Integer.parseInt(posStrArr[1]);
            gb.player(xPos, yPos);
            gb.computer();
            if(gb.isHaveFive())
                break;
            System.out.println("Please select a dot: ");
        }
        if(count1==5)
            System.out.println("YOU WIN!");
        else if(count2==5)
            System.out.println("YOU LOSE!");
    }

    public void initBoard()
    {
        dot = new String[BOARD_SIZE][BOARD_SIZE];
        for (int i = 0; i < BOARD_SIZE; i++)
            for (int j = 0; j < BOARD_SIZE; j++)
                dot[i][j] = "╋";
    }

    public void printBoard()
    {
        for(int i=0; i<BOARD_SIZE; i++)
        {
            for(int j=0; j<BOARD_SIZE; j++)
                System.out.print(dot[i][j]);
            System.out.println();
        }
    }

    public void player(int x, int y)
    {
        dot[x-1][y-1] = "●";
    }

    public void computer()
    {
        int[] d = new int[2];
        randDot(d);
        while(dot[d[0]][d[1]] != "╋")
            randDot(d);
        dot[d[0]][d[1]] = "〇";
        printBoard();
    }

    void randDot(int[] s)
    {

        Random rd = new Random();
        s[0] =(int) rd.nextInt(BOARD_SIZE);
        s[1] =(int) rd.nextInt(BOARD_SIZE);
    }

    boolean isHaveFive()
    {
        for(int k=0; k<BOARD_SIZE; k++)
            if(haveFiveInOneLine(k, 0, k, BOARD_SIZE, 1))
                return true;
        for(int k=0; k<BOARD_SIZE; k++)
            if(haveFiveInOneLine(0, k, BOARD_SIZE, k, 2))
                return true;
        for(int k=0; k<BOARD_SIZE-4; k++)
        {
            if(haveFiveInOneLine(k, 0, BOARD_SIZE-1, BOARD_SIZE-k-1, 3))
                return true;
            if(haveFiveInOneLine(0, k, BOARD_SIZE-k-1, BOARD_SIZE, 3))
                return true;
        }
        for(int k=BOARD_SIZE-1; k>=4; k--)
            if(haveFiveInOneLine(k, 0, 0, k, 4))
                return true;
        for(int k=1; k<=BOARD_SIZE-5; k++)
            if(haveFiveInOneLine(BOARD_SIZE-1, k, k, BOARD_SIZE-1, 4))
                return true;
        return false;
    }

    int max(int m, int n)
    {
        return (m>n)?m:n;
    }

    int min(int m, int n)
    {
        return (m<n)?m:n;
    }

    boolean haveFiveInOneLine(int startXIndex, int startYIndex, int endXIndex, int endYIndex, int type)
    {
        int k;
        count1=0;
        count2=0;
        boolean isBlack=false, isWhite=false;
        while (startXIndex != endXIndex && startYIndex != endYIndex) {
            if (count1 < 5 && count2 < 5) {
                if (dot[startXIndex][startYIndex] == "●") {
                    count1++;
                    isBlack = true;
                    if (isWhite == true) {
                        isWhite = false;
                        count2 = 0;
                    }
                }
                else if (dot[startXIndex][startYIndex] == "〇") {
                    count2++;
                    isWhite = true;
                    if (isBlack == true) {
                        isBlack = false;
                        count1 = 0;
                    }
                } else {
                    if (isBlack == true) {
                        isBlack = false;
                        count1 = 0;
                    } else if (isWhite == true) {
                        isWhite = false;
                        count2 = 0;
                    }
                }
            }
            switch(type) {
                case 1: startYIndex++; break;
                case 2: startYIndex++; break;
                case 3: startXIndex++; startYIndex++; break;
                case 4: startXIndex--; startYIndex++; break;
            }
            if(count1==5 || count2==5)
                break;
        }
        if(count1==5 || count2==5)
            return true;
        else
            return false;
    }
}
