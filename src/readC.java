import javax.swing.*;
import java.io.*;
import java.util.Arrays;

public class readC {

	public static String[] name, type1, type2, weight, group1, group2, ability1, ability2;
	
	public static void readC() {		
		
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
		readC();
		
		System.out.println(Arrays.toString(name));

		System.out.println(Arrays.toString(type1));

		System.out.println(Arrays.toString(type2));

		System.out.println(Arrays.toString(weight));

		System.out.println(Arrays.toString(group1));

		System.out.println(Arrays.toString(group2));

		System.out.println(Arrays.toString(ability1));

		System.out.println(Arrays.toString(ability2));
		
	}

	public static String[] returnName() {
		return (name);
	}
	public static String[] returnType1() {
		return (type1);
	}
	public static String[] returnType2() {
		return (type2);
	}
	public static String[] returnWeight() {
		return (weight);
	}
	public static String[] returnGroup1() {
		return (group1);
	}
	public static String[] returnGroup2() {
		return (group2);
	}
	public static String[] returnAbility1() {
		return (ability1);
	}
	public static String[] returnAbility2() {
		return (ability2);
	}

}
