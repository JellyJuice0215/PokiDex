import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class readC extends LocaleData{
	
	public static void importReader() {		
		
		try {
			File inFile = new File ("PokiDex.txt");
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
			ability1 = new String[index];
			ability2 = new String[index];
			weight = new String[index];
			group1 = new String[index];
			group2 = new String[index];

			//proceed
			String line;
			int ctr = 0;
			while((line = bufReader.readLine()) != null) {
				String[] values = line.split(",");
				int tempCt = 0;

				name[ctr] = values[tempCt];
				type1[ctr] = values[tempCt+1];
				type2[ctr] = values[tempCt+2];
				ability1[ctr] = values[tempCt+3];
				ability2[ctr] = values[tempCt+4];
				weight[ctr] = values[tempCt+5];
				group1[ctr] = values[tempCt+6];
				group2[ctr] = values[tempCt+7];
				if (ctr == 151) {
					break;
				}
				ctr++;
			}

			bufReader.close();
			bufReaderI.close();
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "unable to initialize file!");
		}
	}

	public static void main (String[] args) {
		importReader();
		
	}
}
