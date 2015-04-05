package easy;
import java.util.*;
import java.lang.Double;
/**
 * Created by Lenovo on 2015/4/5.
 */
public class circle
{
    public static void main (String[] args) {
        final double limit = 1.0;
        System.out.println("Please enter r for a circle: ");
        Scanner i = new Scanner(System.in);
        Double in = i.nextDouble();
        for (int x = (int) (2*in); x >= 0; x--)
        {
            for (int y = 0; y <= 2 * in; y++)
            {
                if ((x - in) * (x - in) + (y - in) * (y - in) < in * in+limit &&
                        (x - in) * (x - in) + (y - in) * (y - in) > in*in-limit)
                    System.out.print("*  ");
                else
                    System.out.print("   ");
            }
            System.out.println();
        }
    }
}