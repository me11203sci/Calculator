// Package declaration.
package verification;

// Import dependencies.
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    string = string.replaceAll(" ", "");

    // Check for consecutive operators, hanging decimal points and empty parentheses.
    return !(string.matches("(.*[\\d]+\\(.*)|(.*\\)[\\d].*)|(.*[-+\\*\\/^][+\\*\\/^\\)].*)|(.*\\.[\\d]*\\..*)|(.*^0{2,}\\..*)|(.*\\(\\).*)"));
  }

  // The "tokenize" method.
  public static String[] tokenize(String string)
  {
    // Declare and redefine local instances.
    string = string.replaceAll(" ", "");
    final Pattern pattern = Pattern.compile("((?<=^|[+-\\/\\^*])\\-?[\\d\\.]+)|([+-\\/\\^*\\)\\(])|([\\d\\.]+)", Pattern.MULTILINE);
    final Matcher matcher = pattern.matcher(string);
    final String[] result = matcher.replaceAll("$0 ").split("\\s");

    // Terminate the function.
    return result;
  }
}
