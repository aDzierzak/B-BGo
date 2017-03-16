package bbgo;
import java.awt.Container;

import java.awt.GridLayout;

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;



import javax.swing.JButton;

import javax.swing.JFrame;

import javax.swing.JPanel;



public class MainMenuGui extends JFrame implements ActionListener {

	

	JButton button1 = new JButton("1");

	JButton button2 = new JButton("2");

	JButton button3 = new JButton("3");

	JButton button4 = new JButton("4");

	JButton button5 = new JButton("5");

	JButton button6 = new JButton("6");

	MainMenuGui(){

		

		GridLayout myLayout = new GridLayout(6,1);

		

		Container contentPane = getContentPane();

		JPanel myPanel = new JPanel();

		

		myPanel.setLayout(myLayout);

	

		

		myPanel.add(button1);

		myPanel.add(button2);

		myPanel.add(button3);

		myPanel.add(button4);

		myPanel.add(button5);

		myPanel.add(button6);

		

		contentPane.add(myPanel);

		

		setSize(500,300);

		setVisible(true);

		

	}




	@Override

	public void actionPerformed(ActionEvent e) {

		// TODO Auto-generated method stub

		

	}



}