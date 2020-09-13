
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

@SuppressWarnings("serial")
public class Main extends JFrame implements ActionListener {

	static String expressionTxt = "";
	
	//Create two labels
	static JLabel enterInfixExpLbl = new JLabel("Enter Infix Expression", JLabel.CENTER);
	static JLabel resultLbl = new JLabel("Result", JLabel.CENTER);
			
	//Create two textfields
	static JTextField infixExpTxt = new JTextField(20);
	static JTextField resultTxt = new JTextField(20);		
			

	static //Create evaluate button
	JButton evaluateBtn = new JButton("Evaluate");
	
	
	public static void main(String[] args) {
			
		buildGUI();
		
		//Evaluator evalExpr = new Evaluator();
		//evalExpr.tokenizer(expressionTxt);

	}
	
	public static void buildGUI() {
		
				//Create Expression panel
				JPanel expressionPanel = new JPanel(new FlowLayout());
				expressionPanel.add(enterInfixExpLbl);
				expressionPanel.add(infixExpTxt);
				
				JPanel evaluateBtnPanel = new JPanel(new FlowLayout());
				evaluateBtnPanel.add(evaluateBtn);
				
						
				//Create Result Panel
				JPanel resultPanel = new JPanel(new FlowLayout());
				resultPanel.add(resultLbl);
				resultPanel.add(resultTxt);
				
				
				//Create Frame
				final int WIDTH = 450;
				final int HEIGHT = 130;
				
				JFrame evaluatorFrame = new JFrame();
				evaluatorFrame.setTitle("Infix Expression Evaluator");
				evaluatorFrame.setSize(WIDTH, HEIGHT);
				evaluatorFrame.setLocationRelativeTo(null);
				evaluatorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				evaluatorFrame.setVisible(true);
				evaluatorFrame.setForeground(Color.lightGray);
				
				
				evaluatorFrame.setLayout(new BorderLayout());
				evaluatorFrame.add(expressionPanel, BorderLayout.NORTH);
				evaluatorFrame.add(evaluateBtnPanel, BorderLayout.CENTER);
				evaluatorFrame.add(resultPanel, BorderLayout.SOUTH);
				
				evaluateBtn.setSize(20, 10);
				
				evaluateBtn.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("Evaluate Button Pressed");
						getExpTxt();
						System.out.println(expressionTxt);
						Evaluator evalExpr = new Evaluator();
						evalExpr.tokenizer(expressionTxt);
						resultTxt.setText(evalExpr.finalResult);
					}});
						
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
	
	
	public static String getExpTxt() {
		return expressionTxt = infixExpTxt.getText();
	}

	 

}
