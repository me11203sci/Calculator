// Package declaration.
package verification;

// Import dependencies.
import java.util.Stack;

// Class declaration.
public class Verify
{
  // The "checkIfValid" method.
  public static boolean checkIfValid(String input)
  {
    // Evaulte validity and terminate function.
    return validCharacters(input) && validParentheses(input) && validSyntax(input);
  }

  // The "validCharacters" method.
  private static boolean validCharacters(String string)
  {
    // Check for invalid characters and invalid character placement.
    return !(Character.toString(string.charAt(0)).matches(".*[.+\\*/)].*") || Character.toString(string.charAt(string.length() - 1)).matches(".*[-.+\\*/(].*") || string.matches(".*[!@#$%&_=QWERTYUIOPqwertyuop{\\[}\\]|\\\\ASDFGHJKLasdfghjkl:;\"\'ZXCVBNMzxcvbnm<,>?`~].*"));
  }

  // The "validParentheses" method.
  private static boolean validParentheses(String string)
  {
    // Declare local instances.
    Stack<Character> stack = new Stack<Character>();

    // Begin to loop through "string".
    for(int i = 0; i < string.length(); i++)
    {
      if(Character.toString(string.charAt(i)).matches(".*[()].*"))
      {
        // Determine if the current index is a left parethesis.
        if(string.charAt(i) == '(')
        {
          stack.push(string.charAt(i));
        }
        // Determine if the current index is a left parethesis.
        else if(string.charAt(i) == ')' && !stack.empty())
        {
          stack.pop();
        }
        // Otherwise, return false, as a mismatch was found.
        else
        {
            return false;
        }
      }
    }

    // Check if the stack is empty, if not, as a mismatch was found.
    return stack.empty();
  }

  // The "validSyntax" method.
  private static boolean validSyntax(String string)
  {
    // Declare local instances.
    string = removeDelimiter(string);

    // Check for consecutive operators, hanging decimal points and empty parentheses.
    return !(string.matches("(.*[0-9]+\\(.*)|(.*\\)[0-9].*)|(.*[-+\\*\\/^][+\\*\\/^\\)].*)|(.*\\.[0-9]+\\..*)|(.*^0{2,}\\..*)|(.*\\(\\).*)"));
  }

  // The "addDelimiter" method.
  public static String addDelimiter(String string)
  {
    // Delcare local instances.
    String token;
    String previousToken;
    String earlierToken;
    String result = "";

    // Loop through "string".
    for(int i = 0; i < string.length(); i++)
    {
      // Assign value to "token" for this iteration.
      token = Character.toString(string.charAt(i));

      // Check that "result" has characters in it.
      if(result.length() > 0)
      {
        previousToken = Character.toString(result.charAt(result.length() - 1));
        earlierToken = (result.length() > 1)? Character.toString(string.charAt(i - 2)) : "";

        // If the current token is a number of decimal point and the previous token was either a number or a negative (not a minus sign), then append it to "result".
        if(token.matches(".*[.0-9].*") && (previousToken.matches(".*[.0-9].*") || (previousToken.equals("-") && !earlierToken.matches(".*[ 0-9)].*"))))
        {
          result = result + token;
        }
        // Ignore spaces.
        else if(token.equals(" "))
        {
          continue;
        }
        // Otherwise, append a space before "token".
        else
        {
          result = result + " " +token;
        }
      }
      // If the result has no characters in it.
      else
      {
        // Append "token" to "result", but ignore spaces.
        if(!token.equals(" "))
        {
          result = token;
        }
      }
    }

    // Terminate the function.
    return result;
  }

  // The "removeDelimiter" method.
  private static String removeDelimiter(String string)
  {
    // Delcare local instances.
    String result = "";

    // Loop through "string".
    for(int i = 0; i < string.length(); i++)
    {
      if(!(Character.toString(string.charAt(i)).equals(" ")))
        {
          result = result + string.charAt(i);
        }
    }

    // Terminate the function.
    return result;
  }
}
