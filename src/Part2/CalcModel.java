package Part2;

/**
 * Demonstration of MVC pattern.
 *
 * CalcModel.java
 *
 * This represents the Model which is a representation of the data
 * and its state. This may also include logic, functions, business
 * rules, etc.
 */

public class CalcModel{
  // add two values
  public double addValues(double op1, double op2){
    return op1 + op2;
  }
    
  // subtract two values
  public double subtractValues(double op1, double op2){
    return op1 - op2;
  }
    
  // multiply two values
  public double multiplyValues(double op1, double op2){
    return op1 * op2;
  }
    
  public double divideValues(double op1, double op2)
  {
      if (op2 != 0)
      {
          return op1 / op2;
      }
      else
      {
          throw new IllegalArgumentException("Division by zero");
      }
  }
}
