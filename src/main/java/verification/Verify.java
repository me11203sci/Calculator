// Package declaration.
package verification;

// Import dependencies.

// Class declaration.
public class Verify
{
  // The "checkIfValid" method.
  public static boolean checkIfValid(String input)
  {
    // Evaulte validity and terminate function.
    return validCharaters(input) && validParentheses(input) && validSyntax(input);
  }

  // The "validCharaters" method.
  private static boolean validCharaters(String string)
  {
    // Check for invalid first character.
    if(Character.toString(string.charAt(0)).matches(".*[+\\*/)].*"))
    {
      // Terminate the function.
      return false;
    }
    // Check for invalid charaters.
    else if(string.matches(".*[!@#$%&_=QWERTYUIOPqwertyuop{\\[}\\]|\\\\ASDFGHJKLasdfghjkl:;\"\'ZXCVBNMzxcvbnm<,>?].*"))
    {
      // Terminate the function.
      return false;
    }
    // Otherwise, return true and terminate the function.
    return true;
  }

  // The "validParentheses" method.
  private static boolean validParentheses(String string)
  {
    // Terminate the function.
    return true;
  }

  // The "validSyntax" method.
  private static boolean validSyntax(String string)
  {
    // Terminate the function.
    return true;
  }
}
