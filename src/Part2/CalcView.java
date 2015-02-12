package Part2;

/**
 * Demonstration of MVC pattern.
 *
 * CalcView.java
 *
 * This represents the View which is an output representation of the data.
 *
 * The view is how the user sees the representation of the data.
 */

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class CalcView{

  private JButton addButton = new JButton("Add");
  private JButton subtractButton = new JButton("Subtract");
  private JButton multiplyButton = new JButton("Multiply");
  private JButton divideButton = new JButton("Divide");
  private JTextField operand1Text = new JTextField("12");;
  private JTextField operand2Text = new JTextField("5");;
  private JTextField resultText = new JTextField("");;
  private JFrame frame;
    
  public void setAddListener(ActionListener al){
    addButton.addActionListener(al);
  }
  
  public void setSubtractListener(ActionListener al){
    subtractButton.addActionListener(al);
  }

  public void setMultiplyListener(ActionListener al){
    multiplyButton.addActionListener(al);
  }
  
  public void setDivideListener(ActionListener al)
  {
    divideButton.addActionListener(al);
  }
  
  public CalcView(){
    frame = new JFrame("MVC Pattern Example");
    frame.addWindowListener(new WindowAdapter() {
      @Override
      public void windowClosing(WindowEvent e) {
        System.exit(0);
      }
    });

    // create input field panel
    JPanel topPanel = new JPanel();
    topPanel.setLayout(new FlowLayout());
    topPanel.add(new JLabel("Op 1:"));
    operand1Text.setColumns(5);
    topPanel.add(operand1Text);
    topPanel.add(new JLabel("Op 2:"));
    operand2Text.setColumns(5);
    topPanel.add(operand2Text);
    topPanel.add(new JLabel("Result:"));
    resultText.setColumns(5);
    topPanel.add(resultText);
    
    // create button panel
    JPanel bottomPanel = new JPanel();
    bottomPanel.setLayout(new FlowLayout());
    bottomPanel.add(addButton);
    bottomPanel.add(subtractButton);
    bottomPanel.add(multiplyButton);
    bottomPanel.add(divideButton);
    
    // add the panels to the frame and show it
    frame.getContentPane().setLayout(new GridLayout(2,1));
    frame.getContentPane().add(topPanel);
    frame.getContentPane().add(bottomPanel);
    frame.pack();
    frame.setVisible(true);
  }
  
  // returns the first operand
  public double getOperand1(){
    return Double.parseDouble(operand1Text.getText());
  }
  
  // returns the second operand
  public double getOperand2(){
    return Double.parseDouble(operand2Text.getText());
  }

  // sets the result
  public void setResult(double result){
    resultText.setText(""+result);
  }
}

