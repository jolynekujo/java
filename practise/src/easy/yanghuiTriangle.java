package easy;
import java.util.*;
/**
 * Created by Lenovo on 2015/4/6.
 */
public class yanghuiTriangle
{
    public static void main(String[] args)
    {
        System.out.println("Please enter an integer for yanghuiTriangle: ");
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.next());
        int[][] a = new int[n][2*n+1];
        for(int i=0; i<n; i++)
        {
            a[i][0] = 0;
            a[i][2*n] = 0;
        }
        for(int j=0; j<=2*n; j++)
        {
            if(j == n)
                a[0][j] = 1;
            else
                a[0][j] = 0;
        }
        for(int i=1; i<=n-1; i++)
            for(int j=1; j<=2*n-1; j++)
                a[i][j] = a[i-1][j-1] + a[i-1][j+1];
        for(int i=0; i<=n-1; i++)
        {
            for (int j = 0; j <= 2 * n; j++)
            {
                if(a[i][j] != 0)
                    System.out.printf("%3d", a[i][j]);
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}
