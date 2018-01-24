import java.util.Scanner;

public class hw3 {
    String input;

    protected void AskInput(String msg)
    {
        System.out.println(msg);
        Scanner scn = new Scanner(System.in);
        input = scn.nextLine();
        Statement();
        Convert();
    }

    protected void Statement() {}
    protected void Convert() {}
}
