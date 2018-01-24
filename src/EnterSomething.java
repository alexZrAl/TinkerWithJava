import java.util.Scanner;

public class EnterSomething
{
    public static void main(String[] args)
    {
        System.out.println("CSCI-1010 hw3 refractored in java");

        Encrypt nsa = new Encrypt();
        nsa.AskInput("Enter the thing being encrypted:");
        Decrypt kiwileaks = new Decrypt();
        kiwileaks.AskInput("[censored]");
    }
}
