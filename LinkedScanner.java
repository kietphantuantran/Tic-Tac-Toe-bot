import java.util.Scanner;

// A "Singleton" design pattern, to make it easier for everyone to use the same
// scanner object for System.in, so that different classes are not competing
// for the same resource.
public class LinkedScanner
{
  private static Scanner scanner = new Scanner(System.in);

  static Scanner getScanner()
  {
    return scanner;
  }
}