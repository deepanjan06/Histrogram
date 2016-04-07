import java.io.*;
public class Histogram {

   // Main method to read the integers, store counts for each in an
   // array, and to report how many of each number there was.
   public static void main(java.lang.String[] args) throws IOException {

      DataInputStream stdin = new DataInputStream (System.in);
      final int MAXRANGE = 10;        // Largest range (times 10)
      final int MINRANGE = 1;         // Smallest range
      final int RANGE    = 10;        // 10 values in each interval

      int[] list = new int[MAXRANGE]; // Array has counters for each range

      // Initialize all locations in the array to zero
      for (int i=0; i<list.length; i++) {
         list[i] = 0;
      }

      // Prompt user to enter a list of integers
      System.out.println ("Enter a list of integers between 1 and 100.");
      System.out.println ("To stop, enter an integer not in this range.");

      // Enter first integer value before loop
      System.out.print ("Enter Integer: ");
      int value = Integer.parseInt (stdin.readLine());

      // As long as the integers entered are within the desired range,
      // keep entering integers and increasing the appropriate histogram
      // range index in the 'list' array.
      while (value >= MINRANGE && value <= (MAXRANGE*RANGE)) {

         // Divide by range to determine which range to increment
         list[(value-1)/RANGE] = list[(value-1)/RANGE] + 1;

         // Enter next integer value
         System.out.print ("Enter Integer: ");
         value = Integer.parseInt (stdin.readLine());
      }

      // Print the histogram
      System.out.println ("\nHere is your histogram:");
      for (int i=0; i<list.length; i++) {
         // Print histogram labels
         System.out.print ("   " + (i*RANGE+1) + " - " + (i+1)*RANGE + "\t| ");

         // Print as many asterisks as the value in list[i]
         for (int j=0 ; j<list[i] ; j++) {
            System.out.print ("*");
         }
         System.out.println ();   // starts new histogram line
      }
   }
}
