import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class LoginGui extends JFrame implements ActionListener{

	JButton loginButton = new JButton("Login");
	JButton clearButton = new JButton("Clear");
	
	JTextField usernameField = new JTextField(20);
	JTextField passwordField = new JTextField(20);
	
	public LoginGui(){
		
		JLabel usernameLabel = new JLabel("Username:");
		JLabel passwordLabel = new JLabel("Password:");
		
		JLabel textLabel = new JLabel("B&B Go");
		textLabel.setForeground(Color.BLUE);
		 
		
		Container contentPane = getContentPane();
		JPanel myPanel = new JPanel();
		myPanel.setLayout(new GridLayout(4,1));
		JPanel usernamePanel = new JPanel();
		JPanel passwordPanel = new JPanel();
		JPanel buttonPanel = new JPanel();
		JPanel textPanel = new JPanel();
		
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
		
		
	}
	
	public static void main(String[] args){
		new LoginGui();
	}
	

}
