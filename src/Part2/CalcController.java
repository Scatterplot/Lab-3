package Part2;


import java.awt.event.*;

public class CalcController
{
  // There is a reference to both the view and the model
  private static CalcView view;
  private static CalcModel model;

  public static void main(String[] args)
  {
      view = new CalcView();
      model = new CalcModel();
    //
    // Create and set the listeners to the view
    //
    // Addition
    view.setAddListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        view.setResult(model.addValues(
          view.getOperand1(),
          view.getOperand2()));
      }
    });
  
    // Subtraction
    view.setSubtractListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        view.setResult(model.subtractValues(
          view.getOperand1(),
          view.getOperand2()));
      }
    });

    // Multiplication
    view.setMultiplyListener(new ActionListener(){
      public void actionPerformed(ActionEvent e){
        view.setResult(model.multiplyValues(
          view.getOperand1(),
          view.getOperand2()));
      }
    });

    // Division
    view.setDivideListener(new ActionListener(){
      public void actionPerformed(ActionEvent e)
      {
          try{
        view.setResult(model.divideValues(
          view.getOperand1(),
          view.getOperand2()));
          }
          catch (IllegalArgumentException iae)
          {
              view.setResult(Double.NaN);
          }
      }
    });
  }
}
