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
		//setUndecorated(true);
		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
	}

	public static void main (String[] args) {
		new GUI();
	}
}
