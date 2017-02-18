import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;

public class GUI extends JFrame implements ActionListener {

	private static final int JFRAME_WIDTH = 700;
	private static final int JFRAME_HEIGHT = 500;
	private static JFrame mframe;
	private static JPanel panel;
	private static JLabel statusbar;
	private static TextField fieldT;
	private static JTable table;
	private static JButton btn1, btn2;
	private Object[][] data;
	private String[] columnames;
	static int ctr = 0;
	static int furtherIndex = 0;

	public GUI() {
		setTitle("PokeDex");
		setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		setLocationRelativeTo(null);
		setLayout(new FlowLayout());
		setResizable(false);
		//setUndecorated(true);
		setVisible(true);

		Container contentPane = getContentPane();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);

		control();
		
		table = new JTable(data, columnames) {
			public boolean isCellEditable(int data, int columnames) {
				return false;
			}
		};
		table.addKeyListener((KeyListener) this);
		table.setPreferredScrollableViewportSize(new Dimension(100, 100));
		table.setFillsViewportHeight(true);
		table.setVisible(true);

		JScrollPane scroll = new JScrollPane(table);
		contentPane.add(scroll);

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void control() {
		String[] columnames = {"name", 
				"type 1", 
				"type 2", 
				"weight", 
				"group 1", 
				"group 2", 
				"ability 1", 
		"ability 2"};

		for (int i = 0; i < readC.name.length; i++){
			data[ctr][i] = readC.name[furtherIndex];
			data[ctr][i+1] = readC.type1[furtherIndex];
			data[ctr][i+2] = readC.type2[furtherIndex];
			data[ctr][i+3] = readC.weight[furtherIndex];
			data[ctr][i+4] = readC.group1[furtherIndex];
			data[ctr][i+5] = readC.group2[furtherIndex];
			data[ctr][i+6] = readC.ability1[furtherIndex];
			data[ctr][i+7] = readC.ability2[furtherIndex];
			ctr++;
		}
	}

	public void actionPerformed(ActionEvent e) {

	}
	
	public static void main (String[] args) {
		GUI g = new GUI();
		g.setVisible(true);
	}

}

