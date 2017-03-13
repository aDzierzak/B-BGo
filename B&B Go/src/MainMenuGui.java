import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainMenuGui extends JFrame implements ActionListener {
	
	MainMenuGui(){
		
		Container contentPane = getContentPane();
		JPanel myPanel = new JPanel();
		setSize(500,300);
		setVisible(true);
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
