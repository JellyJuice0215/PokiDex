import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Interface extends Frame implements ActionListener {

	private static final int JFRAME_WIDTH = 700;
	private static final int JFRAME_HEIGHT = 500;
	private static JFrame mframe;
	private static JPanel panel;
	private static TextField fieldT;
	private static JButton btn1, btn2;
	
	public static void main (String[] args) {
		new Interface();

	}
	
	public Interface() {
		mframe = new JFrame("Pokedex");
		mframe.setLayout(new FlowLayout());
		mframe.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		mframe.setLocationRelativeTo(null);
		mframe.setResizable(false);
		mframe.setUndecorated(true);
		mframe.setVisible(true);
		
		panel = new JPanel();
		
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}

}
