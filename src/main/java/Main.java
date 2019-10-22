// Import dependencies.
import java.util.Scanner;
import verification.Verify;

// Class declaration.
class Main
{
  // Declare global instances.
  static Scanner _scanner = new Scanner(System.in);
  static String _userInput;

  // The "main" method.
  public static void main(String[] args)
  {
    // Print out start message.
    System.out.println("\nWelcome. At the prompt, enter your input.");

    // Start the program loop.
    while(true)
    {
      // Print prompt.
      System.out.print("\n> ");

      // Open scanner object.
      _userInput = _scanner.nextLine();

      // Check for valid user input.
      if(Verify.checkIfValid(_userInput))
      {
        // Print out result.
        System.out.println("\n  = " + _userInput);
      }
      else
      {
        // Inform the user of erroneous input.
        System.out.println("Invalid input detected. Please, try again.");
      }
    }
  }
}
