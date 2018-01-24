public class Decrypt extends hw3
{
    protected void Statement()
    {
        System.out.println("Starting decryption...");
    }

    protected void Convert()
    {
        for (int i=0; i<input.length(); i+=3) {
            String chr = new String(input.substring(i, i+3));
            int ascii = -1;
            try {
                ascii = Integer.parseInt(chr);
            } catch (NumberFormatException ex) {
                System.out.print("~");
            }
            System.out.print((char)ascii);
        }
        System.out.print("\n");
    }
}
