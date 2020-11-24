package productframe;


import java.util.ArrayList;

import javax.swing.JFrame;



public class main {
	public static void main(String[] args) {
		JFrame mainFrame = new JFrame();
		mainFrame.setBounds(100, 100, 1100, 600);
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);
		
		Home home = new Home();
		mainFrame.add(home);
		mainFrame.setVisible(true);
	}

}
