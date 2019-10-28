// Package declaration.
package calculation;

//
import java.util.HashMap;
import java.util.Stack;
import verification.Verify;

// Class declaration.
public class Calculate
{
  // The "evaluate" method.
  public static String evaluate(String string)
  {
    // Declare local instacnes.
    Stack<String> result = new Stack<String>();
    String[] tokenStream = reversePolishConverter(string).split("\\s");

    // Loop through "tokenStream".
    for(String token : tokenStream)
    {
      if(token.matches(".*[0-9].*"))
      {
        result.push(token);
      }
      else if (!result.empty() && token.matches(".*[-+\\*/^].*"))
      {
        result.push(Double.toString(operate(Double.parseDouble(result.pop()), Double.parseDouble(result.pop()), token)));
      }
    }

    // Return the modified value of "result" and terminate the method.
    return result.toString().replace('[', '\0').replace(']', '\0');
  }

  // The "reversePolishConverter" method.
  public static String reversePolishConverter(String string)
  {
    // Declare local instances.
    Stack<String> operators = new Stack<String>();
    String result = "";
    String[] tokenStream = Verify.addDelimiter(string).split("\\s");

    // Loop through the "tokenStream".
    for(String token : tokenStream)
    {
        // Check if current token is an operand.
        if(token.matches(".*[0-9].*"))
        {
          // If so, push it to the result.
          result = result + " " + token;
        }
        // Check if current token is an operator.
        else if(token.matches(".*[-+\\*/^].*"))
        {
          // If the "operators" stack is empty, push it to the stack.
          if(operators.empty())
          {
            operators.push(token);
          }
          // Otherwise, pop operators into the result until all higher presedence operators are in the result.
          else
          {
            while(!operators.empty() && greaterPresedence(operators.peek(), token))
            {
              result = result + " " + operators.pop();
            }
            operators.push(token);
          }
        }
        // Check if current token is a left parethesis.
        else if(token.equals("("))
        {
          operators.push(token);
        }
        // Otherwise, the token is a right parethesis.
        else
        {
          // Pop operators into the result until the next left parethesis.
          while(!operators.peek().equals("("))
          {
            result = result + " " + operators.pop();
          }
          operators.pop();
        }
    }

    // Finally, add the remaining operators to the result.
    while(!operators.empty())
    {
      result = result + " " + operators.pop();
    }

    // Terminate the method.
    return result;
  }

  // The "greaterPresedence" method.
  private static boolean greaterPresedence(String a, String b)
  {
    // Declare local instances.
    HashMap<String, Integer> map = new HashMap<String, Integer>()
    {{
      put("(", 0);
      put("+", 1);
      put("-", 1);
      put("*", 2);
      put("/", 2);
      put("^", 3);
    }};

    // Check if the presedence of current token is less than or equal to the most recent operand.
    return map.get(a) >= map.get(b);
  }

  // The "operate" method.
  private static double operate(Double a, Double b, String c)
  {
    // Declare local instacnes.
    double result;

    // Apply the appropriate operation.
    switch(c)
    {
      case "+":
        result = a + b;
        break;
      case "-":
      result = b - a;
        break;
      case "*":
        result = a * b;
        break;
      case "/":
        result = b / a;
        break;
      default:
        result = Math.pow(b, a);
       break;
    }

    // Terminate the function.
    return result;
  }
}
