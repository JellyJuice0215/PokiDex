import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class GUI extends LocaleData implements ActionListener{

	private static final int JFRAME_WIDTH = 800;
	private static final int JFRAME_HEIGHT = 600;
	//main components
	private JFrame mframe;
	private JLabel mlabel;
	//sub components
	private JLabel readme;
	private JButton close, pressS, next, previous;
	private TextField searchID;
	//information components
	private JPanel parts;
	private JLabel backset;
	private JLabel a1, a2, t1, t2, gr1, gr2, weight;
	
	public GUI() {	
		mframe = new JFrame("PokeDex");
		mframe.setSize(JFRAME_WIDTH, JFRAME_HEIGHT);
		mframe.setLocationRelativeTo(null);
		mframe.setUndecorated(true);
		mframe.setResizable(false);
		mframe.getContentPane().setLayout(null);

		//readme components
		readme = new JLabel(new ImageIcon("images/readme.png"));
		readme.setBounds(33,155,322,330);
		mframe.getContentPane().add(readme);

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
		
		previous = new JButton(new ImageIcon("images/buttonPrevious.png"));
		previous.setBounds(118,490, 50, 50);
		previous.setContentAreaFilled(false);
		previous.setBorderPainted(false);
		previous.setFocusPainted(false);
		previous.addActionListener(this);
		mframe.getContentPane().add(previous);

		next = new JButton(new ImageIcon("images/buttonNext.png"));
		next.setBounds(188,490, 50, 50);
		next.setContentAreaFilled(false);
		next.setBorderPainted(false);
		next.setFocusPainted(false);
		next.addActionListener(this);
		mframe.getContentPane().add(next);

		//static components
		searchID = new TextField();
		searchID.setBounds(240,95,120,27);
		searchID.setFont(new Font("Work Sans",1,16));
		mframe.getContentPane().add(searchID);
		searchID.addActionListener(this);

		weight = new JLabel("", SwingConstants.CENTER);
		weight.setBounds(600,199,170,40);
		mframe.getContentPane().add(weight);
		t1 = new JLabel("", SwingConstants.CENTER);
		t1.setBounds(600,243,170,40);
		mframe.getContentPane().add(t1);
		t2 = new JLabel("", SwingConstants.CENTER);
		t2.setBounds(600,287,170,40);
		mframe.getContentPane().add(t2);
		gr1 = new JLabel("", SwingConstants.CENTER);
		gr1.setBounds(600,336,170,40);
		mframe.getContentPane().add(gr1);
		gr2 = new JLabel("", SwingConstants.CENTER);
		gr2.setBounds(600,385,170,40);
		mframe.getContentPane().add(gr2);
		a1 = new JLabel("", SwingConstants.CENTER);
		a1.setBounds(605,429,170,40);
		mframe.getContentPane().add(a1);
		a2 = new JLabel("", SwingConstants.CENTER);
		a2.setBounds(600,470,170,40);
		mframe.getContentPane().add(a2);

		//backset
		parts = new JPanel();
		parts.setBounds(467,160,296,369);
		parts.setOpaque(false);
		mframe.getContentPane().add(parts);
		backset = new JLabel(new ImageIcon("images/readmeR.png"));
		backset.setBounds(468,162,292,366);
		parts.add(backset);

		//background
		mlabel = new JLabel(new ImageIcon("images/mainG.png"));
		mlabel.setOpaque(false);
		mlabel.setBounds(0,0,800,600);
		mframe.getContentPane().add(mlabel);

		readC.importReader();

		mframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mframe.setVisible(true);
	}

	public static void main (String[] args) {	
		new GUI();
	}

	private int ctr = 0;
	public void actionPerformed(ActionEvent event){

		JButton clickedButton = (JButton) event.getSource();
		if (clickedButton == pressS) {
			ctr = 0;
			String textEnter = searchID.getText();
			try {
				while (true) {
					if (textEnter.equalsIgnoreCase(data[ctr][0])) {
						readme.setIcon(new ImageIcon("images/Pokemons/"+ imgIndex[ctr] + ".png"));
						backset.setIcon(new ImageIcon("images/backset.png"));
						a1.setText(data[ctr][3]);
						a1.setFont(new Font("Small Fonts",1,17));
						a2.setText(data[ctr][4]);
						a2.setFont(new Font("Small Fonts",1,17));
						t1.setText(data[ctr][1]);
						t1.setFont(new Font("Small Fonts",1,17));
						t2.setText(data[ctr][2]);
						t2.setFont(new Font("Small Fonts",1,17));
						gr1.setText(data[ctr][6]);
						gr1.setFont(new Font("Small Fonts",1,17));
						gr2.setText(data[ctr][7]);
						gr2.setFont(new Font("Small Fonts",1,17));
						weight.setText(data[ctr][5]);
						weight.setFont(new Font("Small Fonts",1,17));
						break;
					}
					ctr++;
				}
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "The name doesn't exist");
			}
		}
		if (clickedButton == previous) {
			if (ctr != 0 && ctr < 151) {
				ctr--;
				backset.setIcon(new ImageIcon("images/backset.png"));
				readme.setIcon(new ImageIcon("images/Pokemons/"+ imgIndex[ctr] + ".png"));
				searchID.setText(data[ctr][0]);
				a1.setText(data[ctr][3]);
				a1.setFont(new Font("Small Fonts",1,17));
				a2.setText(data[ctr][4]);
				a2.setFont(new Font("Small Fonts",1,17));
				t1.setText(data[ctr][1]);
				t1.setFont(new Font("Small Fonts",1,17));
				t2.setText(data[ctr][2]);
				t2.setFont(new Font("Small Fonts",1,17));
				gr1.setText(data[ctr][6]);
				gr1.setFont(new Font("Small Fonts",1,17));
				gr2.setText(data[ctr][7]);
				gr2.setFont(new Font("Small Fonts",1,17));
				weight.setText(data[ctr][5]);
				weight.setFont(new Font("Small Fonts",1,17));
			}
			if (ctr == 0) {
				JOptionPane.showMessageDialog(null, "This is the very first Pokemon!");
			}
		}
		if (clickedButton == next) {
			if (ctr < 150) {
				ctr++;
				backset.setIcon(new ImageIcon("images/backset.png"));
				readme.setIcon(new ImageIcon("images/Pokemons/"+ imgIndex[ctr] + ".png"));
				searchID.setText(data[ctr][0]);
				a1.setText(data[ctr][3]);
				a1.setFont(new Font("Small Fonts",1,17));
				a2.setText(data[ctr][4]);
				a2.setFont(new Font("Small Fonts",1,17));
				t1.setText(data[ctr][1]);
				t1.setFont(new Font("Small Fonts",1,17));
				t2.setText(data[ctr][2]);
				t2.setFont(new Font("Small Fonts",1,17));
				gr1.setText(data[ctr][6]);
				gr1.setFont(new Font("Small Fonts",1,17));
				gr2.setText(data[ctr][7]);
				gr2.setFont(new Font("Small Fonts",1,17));
				weight.setText(data[ctr][5]);
				weight.setFont(new Font("Small Fonts",1,17));
			}
			if (ctr == 150) {
				JOptionPane.showMessageDialog(null, "This is the very last Pokemon!");
			}
		}
		if (clickedButton == close) {
			System.exit(0);
		}
	}
}
