package easy;

/**
 * Created by Lenovo on 2015/4/5.
 */
public class triangle
{
    public static void main (String[] args)
    {
        for(int y = 10; y>=0; y--) {
            for (int x = 0; x <= 10; x++) {
                if (y <= 2 * x && y <= (-2) * x + 16)
                    System.out.printf("*  ");
                else
                    System.out.printf("   ");
            }
            System.out.println();
        }
    }
}
