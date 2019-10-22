// Package.

// Import dependencies.
import java.util.Scanner;

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
    do
    {
      // Print prompt.
      System.out.print("\n> ");

      // Open scanner object.
      _userInput = _scanner.nextLine();

      // Check for valid user input.
      if(true)
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
    // Main loop conditional.
    while(true);
  }
}
