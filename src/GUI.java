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
	private Component mousepanel;
	private Container contentPane;
	
	public static void main (String[] args) {
		new GUI();
	}
	
	public GUI() {
		
		mframe.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		mframe.setLocationRelativeTo(null);
		mframe.setLayout(new FlowLayout());
		mframe.setResizable(false);
		mframe.setUndecorated(true);
		mframe.setDefaultCloseOperation(EXIT_ON_CLOSE);
		mframe.setVisible(true);
		
		contentPane = new Container();
		contentPane.setBackground(Color.white);
		contentPane.setLayout(null);
		
		table = new JTable(new TableLocale());
		table.setPreferredScrollableViewportSize(new Dimension(700, 300));
		table.setFillsViewportHeight(true);
		table.setVisible(true);
		
		JScrollPane scroll = new JScrollPane(table);
		contentPane.add(scroll);
		
		HandlerClass handler = new HandlerClass();
		mousepanel.addMouseListener(handler);
		mousepanel.addMouseMotionListener(handler);
		
	}
	

	class TableLocale extends AbstractTableModel {
		
		private String[] columnames = {"name", "type 1", "type 2", "weight", "group 1", "group 2", "ability 1", "ability 2"};
		private Object[][] data;
		
		@Override
		public int getColumnCount() {
			return columnames.length;
		}
		
		@Override
		public int getRowCount() {
			return data.length;
		}
		
		@Override
		public String getColumnName(int col) {
			return columnames[col];
		}
		
		@Override
		public Object getValueAt(int row, int col) {
			return data[row][col];
		}
		
		@Override
		public Class getColumnClass(int c) {
			return getValueAt(0,c).getClass();
		}
	}
	
	private class HandlerClass implements MouseListener, MouseMotionListener {
		
		@Override
		public void mouseClicked(MouseEvent e) {

		}
		
		@Override
		public void mouseReleased(MouseEvent event) {

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
		}

		@Override
		public void mouseMoved(MouseEvent e) {
			
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			
		}

		@Override
		public void mouseExited(MouseEvent e) {
			
		}

		@Override
		public void mousePressed(MouseEvent e) {
			
		}
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
	}
}
