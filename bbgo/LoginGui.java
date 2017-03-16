package bbgo;
import java.awt.*;

import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

import javax.swing.*;





public class LoginGui extends JFrame implements ActionListener{
	
	

	JButton loginButton = new JButton("Login");

	JButton clearButton = new JButton("Clear");

	

	JLabel usernameLabel = new JLabel("Username:");

	JLabel passwordLabel = new JLabel("Password:");

	

	JTextField usernameField = new JTextField(20);

	JPasswordField passwordField = new JPasswordField(20);

	

	public LoginGui(){

		
		

		

		

		JLabel textLabel = new JLabel("B&B Go");

		textLabel.setForeground(Color.BLUE);

		 

		

		Container contentPane = getContentPane();

		JPanel myPanel = new JPanel();

		myPanel.setLayout(new GridLayout(4,1));

		JPanel usernamePanel = new JPanel();

		JPanel passwordPanel = new JPanel();

		JPanel buttonPanel = new JPanel();

		JPanel textPanel = new JPanel();

		

		loginButton.addActionListener(this);

		clearButton.addActionListener(this);

		

		textPanel.add(textLabel);

		

		usernamePanel.add(usernameLabel);

		usernamePanel.add(usernameField);

		

		passwordPanel.add(passwordLabel);

		passwordPanel.add(passwordField);

		

		buttonPanel.add(loginButton);

		buttonPanel.add(clearButton);

		

		myPanel.add(textPanel);

		myPanel.add(usernamePanel);

		myPanel.add(passwordPanel);

		myPanel.add(buttonPanel);

		

		contentPane.setBackground(Color.WHITE);

		contentPane.add(myPanel);

		

		

		setSize(500,300);

		setVisible(true);

		

	}



	

	public void actionPerformed(ActionEvent e) {

		if(e.getSource()==clearButton){

			usernameField.setText(null);

			passwordField.setText(null);

			

		}else if(e.getSource()==loginButton){
			
			

			String textUsername = usernameField.getText();

			String textPassword = passwordField.getText();

			

			if(textUsername.equals("root") && textPassword.equals("root")){

				new MainMenuGui();

				this.dispose();

				

			}if(!"root".equals(textUsername) || !"root".equals(textPassword) ){

				

				 JOptionPane.showMessageDialog(null, "Username or password incorrect, please try again");

				 usernameField.setText(null);

				 passwordField.setText(null);

				 

			}

			

			

			

		}

		

	}

	




}