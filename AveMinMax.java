//Jacob Gaylord
//jigaylord16@ole.augie.edu
//AveMinMax.java
//Description: This program finds the average, the minimum, and the maximum of a
//             file of doubles. The file must be named "number.txt". It must
//             a sequence of doubles seperated by white space. Thus, a line
//             could contain any number of doubles. The program will print the
//             the doubles that the file contains on the screen. Then, the
//             the average, the minimum, and the maximum will be printed on the
//             screen.
//Input:       An input file with the name of "number.txt" is read by the
//             scanner.
//Output:      The doubles the the file contains as well as their average,
//             minimum, and the maximum will be printed on the screen.
import java.util.Scanner;
import java.util.Vector;
import java.util.Iterator;
import java.io.FileNotFoundException;
import java.io.File;
public class AveMinMax
{
  public static void main(String[] arr) throws FileNotFoundException
  {
    File f = new File("number.txt");
    if(!f.exists())
    {
      System.out.println("number.txt does not exist.");
      System.out.println("Please prepare number.txt and rerun the program.");
      System.exit(0);
    }
    else
    {
    printDoubles(f);
    printAverage(f);
    printMinimum(f);
    printMaximum(f);
    }
  }
  //Pre:  File "number.txt" must contains a sequence of doubles seperated by
  //      white space.
  //Post: The doubles that "number.txt" contains are printed on the screen.
  public static void printDoubles(File f) throws FileNotFoundException
  {
      Vector<Double> v = new Vector<Double>();
      Scanner input = new Scanner(f);
      while (input.hasNextDouble())
      {
        v.add(input.nextDouble());
      }
      System.out.print("The file has: ");
      Iterator<Double> iter = v.iterator();
      while(iter.hasNext())
      {
        System.out.print(iter.next()+" ");
      }
      System.out.println();
  }
  //Pre:  File "number.txt" must contains a sequence of doubles seperated by
  //      white space.
  //Post: The average of the doubles in "number.txt" is printed on the screen.
  public static void printAverage(File f) throws FileNotFoundException
  {
      double num = 0.0, sum = 0.0, ave = 0.0;
      int count = 0;
      Scanner input = new Scanner(f);
      while (input.hasNextDouble())
      {
        num = input.nextDouble();
        sum += num;
        ++count;
      }
      ave = sum/count;
      ave = Math.round(ave * 100.0) / 100.0;
      System.out.print("The average is "+ave);
      System.out.println();
  }
  //Pre:  File "number.txt" must contains a sequence of doubles seperated by
  //      white space.
  //Post: The maximum of the doubles in "number.txt" is printed on the screen.
  public static void printMaximum(File f) throws FileNotFoundException
  {
      double num = 0.0, max = 0.0;
      Scanner input = new Scanner(f);
      while (input.hasNextDouble())
      {
        num = input.nextDouble();
        if (num > max) max = num;
        else continue;
      }
      System.out.print("The max is "+max);
      System.out.println();
  }
  //Pre:  File "number.txt" must contains a sequence of doubles seperated by
  //      white space.
  //Post: The minimum of the doubles in "number.txt" is printed on the screen.
  public static void printMinimum(File f) throws FileNotFoundException
  {
      double num = 0.0, min = Double.POSITIVE_INFINITY;
      Scanner input = new Scanner(f);
      while (input.hasNextDouble())
      {
        num = input.nextDouble();
        if (num < min) min = num;
        else continue;
      }
      System.out.print("The min is "+min);
      System.out.println();
  }
}
