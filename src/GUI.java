import javax.swing.*;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class GUI extends LocaleData {

	private static final int JFRAME_WIDTH = 700;
	private static final int JFRAME_HEIGHT = 500;
	private static JFrame mframe;
	private static JPanel panel;
	private static JLabel statusbar;
	private static TextField fieldT;
	private static JButton btn1, btn2;
	private JTable table;

	public GUI() {	
		mframe = new JFrame("PokeDex");
		mframe.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		mframe.setLocationRelativeTo(null);
		mframe.getContentPane().setLayout(null);

		readC.importReader();

		String[][] data = new String[151][8];

		for (int i = 0; i < 151; i++){
			data[i][0] = name[i];
			data[i][1] = type1[i];
			data[i][2] = type2[i];
			data[i][3] = weight[i];
			data[i][4] = group1[i];
			data[i][5] = group2[i];
			data[i][6] = ability1[i];
			data[i][7] = ability2[i];
		}

		String[] columnames = {"name", 
				"type 1", 
				"type 2", 
				"weight", 
				"group 1", 
				"group 2", 
				"ability 1", 
		"ability 2"};

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 94, 674, 366);
		mframe.getContentPane().add(scrollPane);

		table = new JTable(data, columnames);
		scrollPane.setColumnHeaderView(table);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollPane.setViewportView(scrollBar);
		mframe.setResizable(false);
		//setUndecorated(true);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
	}

	public static void main (String[] args) {
		new GUI();
	}
}
