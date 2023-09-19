package ploy.vehicle;

public class NumFormat {
    
    long hardToRead = 1000000000;
    long easierToRead = 1_000_000_000;
    long legalButSilly = 10_0000_0000;


    public static void main(String[] args) {
        long myBillion = 10_0000_0000;
        String s = String.format("%,d", myBillion);
        System.out.println(s);
        String b = String.format("I have %,.2f bugs to fix", 476578.09876);
        System.out.println(b);

    
    }
}
