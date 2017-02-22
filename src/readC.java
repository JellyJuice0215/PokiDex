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
			data = new String[151][8];

			//proceed
			String line;
			int tempCt = 0;
			while((line = bufReader.readLine()) != null) {
				String[] values = line.split(",");
				
				for (int i = 0; i < 8; i++) {
					data[tempCt][i] = values[i];
				}
				if (tempCt == 151) {
					break;
				}
				tempCt++;
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
