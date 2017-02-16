import javax.swing.*;
import java.io.*;

public class readC {

	static String[] name, type1, type2, height, weight, groups, ability;

	public static void ReadFile() {

		try {
			File inFile = new File ("Pokindex.txt");
			File inFileI = new File ("index.txt");
			FileReader fileReader = new FileReader(inFile);
			FileReader fileReaderI = new FileReader(inFileI);
			BufferedReader bufReader = new BufferedReader(fileReader);
			BufferedReader bufReaderI = new BufferedReader(fileReaderI);

			//get number of poki
			String strNumber;
			strNumber = bufReaderI.readLine();
			int index = Integer.parseInt(strNumber);
			//assigning length to pokiDex
			name = new String[index];
			type1 = new String[index];
			type2 = new String[index];
			height = new String[index];
			weight = new String[index];
			groups = new String[index];
			ability = new String[index];

			//proceed
			String line;
			int ctr = 0;
			while((line = bufReader.readLine()) != null) {
				String[] values = line.split(",");
				int tempCt = 0;

				name[ctr] = values[tempCt];
				type1[ctr] = values[tempCt+1];
				type2[ctr] = values[tempCt+2];
				height[ctr] = values[tempCt+3];
				weight[ctr] = values[tempCt+4];
				groups[ctr] = values[tempCt+5];
				ability[ctr] = values[tempCt+6];
				ctr++;
			}

			bufReader.close();
			bufReaderI.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "unable to initialize file!");
		}
	}
	
	public static void main (String[] args) {
		ReadFile();
	}

}
