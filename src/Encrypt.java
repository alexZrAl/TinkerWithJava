public class Encrypt extends hw3
{



    protected void Statement()
    {
        System.out.println("Starting encryption...");
    }
    protected void Convert()
    {
        for (int i=0; i<input.length(); ++i) {
            int ascii = (int)input.charAt(i);
            System.out.print(ascii);
        }
        System.out.print("\n");
    }
}
