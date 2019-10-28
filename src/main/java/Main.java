// Import dependencies.
import calculation.Calculate;
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

      // Check for blank input.
      if(_userInput.equals(""))
      {
        // Print out result.
        System.out.println("\n  = ");
      }
      // Check for valid user input.
      else if(Verify.checkIfValid(_userInput))
      {
        try
        {
          // Print out result.
          System.out.println("\n  = " + Calculate.evaluate(_userInput));
        }
        catch(ArithmeticException e)
        {
          // Inform the user of erroneous input.
          System.out.println("\nInvalid input detected. Please, try again.");
        }
        catch(NumberFormatException e)
        {
          // Inform the user of erroneous input.
          System.out.println("\nInsufficent memory. Please, try again.");
        }
      }
      else
      {
        // Inform the user of erroneous input.
        System.out.println("\nInvalid input detected. Please, try again.");
      }
    }
  }
}
