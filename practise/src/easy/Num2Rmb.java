package easy;
import java.util.*;
/**
 * ����һ��������������й����ҵĶ��������λǧ�ڣ����λ��
 * Created by Lenovo on 2015/4/6.
 */
public class Num2Rmb
{
    public static void main(String[] args)
    {
        System.out.println("Please enter a double number: ");
        Scanner in = new Scanner(System.in);
        double num = in.nextDouble();
        String read = changeToRmb(num);
        System.out.println(num + " in China can be read as " + read);

    }

    private static String changeToRmb(double num)
    {
        long n, n1;
        String result = new String();
        String[] unitArr = new String[]{"ʰ", "��", "Ǫ"};
        long zheng = Num2Rmb.getZheng(num);
        long temp = zheng;
        long xiao = Num2Rmb.getXiao(num);
        int lenZheng = Num2Rmb.getLength(zheng);
        boolean isZero = false;
        for (int i = lenZheng - 1; i >= 0; i--)
        {
            n = zheng / newPow(10, i);
            zheng = zheng - n * newPow(10, i);
            n1 = i % 4;
            if (n != 0)
            {
                result += numToHan(n);
                if(n==1 && n1==1)
                    result = result.substring(0, result.length()-1);
                if (n1 > 0)
                    result += unitArr[(int) (n1 - 1)];
                if(isZero==true)
                    isZero = false;
            }
            else
            {   if((i+1)%4==0)
                    result += "��";
                if(isZero == false)
                {
                    result = result + "��";
                    isZero = true;
                }
            }
            if(i%4==0)
            {
                if (isZero==true && lenZheng>1)
                    result = result.substring(0, result.length() - 1);
                if (i == 8)
                    result += "��";
                else if (i == 4)
                    result += "��";
                else if (i == 0)
                    result += "Ԫ";
            }
        }
        if (temp==0 && xiao!=0)
            result = "";
        if (xiao / 10 != 0)
            result += numToHan(xiao / 10) + "��";
        if (xiao % 10 != 0)
            result += numToHan(xiao % 10) + "��";
        return result;
    }

    public static long getZheng(double num)
    {
        return (long)num;
    }

    public static long getXiao(double num)
    {
        return (long) ((num - getZheng(num)) * 100);
    }

    public static int getLength(long num)
    {
        String str = String.valueOf(num);
        return str.length();
    }

    public static long newPow(int a, int b)
    {
        long result = 1;
        for(int i=1; i<=b; i++)
            result *= a;
        return result;
    }

    public static String numToHan(long n)
    {
        String han = new String();
        String[] hanArr = new String[]{"��","Ҽ","��","��","��","��","½","��","��","��"};
        han = hanArr[(int)n];
        return han;
    }
}
