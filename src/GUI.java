import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.table.AbstractTableModel;
import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class GUI extends LocaleData implements ActionListener{

	private static final int JFRAME_WIDTH = 800;
	private static final int JFRAME_HEIGHT = 600;
	//main components
	private JFrame mframe;
	private JPanel mpanel;
	private JLabel mlabel;
	//sub components
	private JPanel extraA, search, profileI;
	private JLabel credits, creditsA, searchL;
	private JButton close, min, pressS;
	private TextField searchID;
	//information components
	private JPanel parts;
	private JLabel backset, aloneNameL;
	private JLabel name, a1, a2, t1, t2, gr1, gr2, weight;

	public GUI() {	
		mframe = new JFrame("PokeDex");
		mframe.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		mframe.setLocationRelativeTo(null);
		mframe.setUndecorated(true);
		mframe.setResizable(false);
		mframe.getContentPane().setLayout(null);

		//buttons
		close = new JButton(new ImageIcon("images/close.PNG"));
		close.setBounds(93,15,29,29);
		close.setRolloverEnabled(true);
		close.setRolloverIcon(new ImageIcon("images/closeH.png"));
		close.setContentAreaFilled(false);
		close.setBorderPainted(false);
		close.setFocusPainted(false);
		close.addActionListener(this);
		mframe.getContentPane().add(close);

		pressS = new JButton(new ImageIcon("images/Search.PNG"));
		pressS.setBounds(7,3,100,100);
		pressS.setContentAreaFilled(false);
		pressS.setBorderPainted(false);
		pressS.setFocusPainted(false);
		pressS.addActionListener(this);
		mframe.getContentPane().add(pressS);

		//static components
		mpanel = new JPanel();
		mpanel.setBounds(660,2,120,100);
		mpanel.setBackground(Color.white);
		mframe.getContentPane().add(mpanel);
		String sText = "<html>Powered By: <br/>1. Nicolas <br/>2. Atul <br/>3. Yonghao</html>";
		credits = new JLabel(sText);
		credits.setFont(new Font("Monaco",3,16));
		mpanel.add(credits);

		extraA = new JPanel();
		extraA.setBounds(440,2,230,27);
		extraA.setBackground(Color.white);
		mframe.getContentPane().add(extraA);
		String sTextAddition = "<html>Synced March 5, 2017</html>";
		creditsA = new JLabel(sTextAddition);
		creditsA.setFont(new Font("Monaco",3,16));
		extraA.add(creditsA);

		search = new JPanel();
		search.setBounds(220,50,150,27);
		search.setOpaque(false);
		mframe.getContentPane().add(search);
		String sTextSearch = "<html>Pokemon Name:</html>";
		searchL = new JLabel(sTextSearch);
		searchL.setFont(new Font("Monaco",1,17));
		search.add(searchL);
		searchID = new TextField();
		searchID.setBounds(240,90,100,27);
		searchID.setFont(new Font("Work Sans",1,16));
		mframe.getContentPane().add(searchID);
		searchID.addActionListener(this);

		profileI = new JPanel();
		profileI.setBounds(30,155,327,332);
		profileI.setOpaque(false);
		mframe.getContentPane().add(profileI);

		aloneNameL = new JLabel("", SwingConstants.CENTER);
		aloneNameL.setBounds(540,178,170,40);
		mframe.getContentPane().add(aloneNameL);
		name = new JLabel("", SwingConstants.CENTER);
		name.setBounds(530,178,170,40);
		mframe.getContentPane().add(name);
		weight = new JLabel("", SwingConstants.CENTER);
		weight.setBounds(570,249,170,40);
		mframe.getContentPane().add(weight);
		t1 = new JLabel("", SwingConstants.CENTER);
		t1.setBounds(570,288,170,40);
		mframe.getContentPane().add(t1);
		t2 = new JLabel("", SwingConstants.CENTER);
		t2.setBounds(570,326,170,40);
		mframe.getContentPane().add(t2);
		gr1 = new JLabel("", SwingConstants.CENTER);
		gr1.setBounds(570,364,170,40);
		mframe.getContentPane().add(gr1);
		gr2 = new JLabel("", SwingConstants.CENTER);
		gr2.setBounds(570,399,170,40);
		mframe.getContentPane().add(gr2);
		a1 = new JLabel("", SwingConstants.CENTER);
		a1.setBounds(570,433,170,40);
		mframe.getContentPane().add(a1);
		a2 = new JLabel("", SwingConstants.CENTER);
		a2.setBounds(570,470,170,40);
		mframe.getContentPane().add(a2);
		
		//backset
		parts = new JPanel();
		parts.setBounds(467,160,296,369);
		parts.setOpaque(false);
		mframe.getContentPane().add(parts);
		backset = new JLabel(new ImageIcon("images/backset.png"));
		backset.setBounds(0,0,296,371);
		parts.add(backset);

		//background
		mlabel = new JLabel(new ImageIcon("images/mainG.png"));
		mlabel.setBounds(0,0,800,600);
		mframe.getContentPane().add(mlabel);

		readC.importReader();

		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
	}

	public static void main (String[] args) {
		new GUI();
	}

	public void actionPerformed(ActionEvent event){

		JButton clickedButton = (JButton) event.getSource();
		if (clickedButton == pressS) {
			String textEnter = searchID.getText();
			try {
				int ctr = 0;
				while (true) {
					if (textEnter.equals(data[ctr][0])) {
						searchID.setText("");
						aloneNameL.setText(textEnter);
						aloneNameL.setFont(new Font("Chiller", 1, 30));
						a1.setText(data[ctr][3]);
						a1.setFont(new Font("Tekton", 1, 17));
						a2.setText(data[ctr][4]);
						a2.setFont(new Font("Tekton", 1, 17));
						t1.setText(data[ctr][1]);
						t1.setFont(new Font("Tekton", 1, 17));
						t2.setText(data[ctr][2]);
						t2.setFont(new Font("Tekton", 1, 17));
						gr1.setText(data[ctr][6]);
						gr1.setFont(new Font("Tekton", 1, 17));
						gr2.setText(data[ctr][7]);
						gr2.setFont(new Font("Tekton", 1, 17));
						weight.setText(data[ctr][5]);
						weight.setFont(new Font("Tekton", 1, 17));
						break;
					}
					ctr++;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The name doesn't exist");
				searchID.setText("");
			}
		}
		if (clickedButton == close) {
			System.exit(0);
		}
	}
}
