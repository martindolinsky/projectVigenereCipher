package sample;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author Martin Dolinsky
 */
public class MyFile {

	public String readFile(String sourceFile) {
		String data = "";
		try {
			File myFile = new File(sourceFile);
			Scanner myReader = new Scanner(myFile);
			while (myReader.hasNextLine()) {
				data = myReader.nextLine();

			}
			myReader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data;
	}

	public void writeToFile(String sourceFile, String file) throws IOException {
		try {
			File newFile = new File(file);
			FileWriter write = new FileWriter(newFile);
			write.write(readFile(sourceFile));
			write.close();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void hash(String source, String target, String key) {
		try {
			File myFile = new File(source);
			File otherFile = new File(target);
			FileWriter write = new FileWriter(target);
			FileReader fr = new FileReader(source);
			BufferedReader read = new BufferedReader(fr);
			int data;


			if (!key.equals("")) {
				char[] array = key.toCharArray();
				List list = new ArrayList();

				while ((data = read.read()) != -1) { //123.,?
//					for (int i = 0; i < key.length(); i++) {
//						data = String.valueOf(data).charAt(i);
//						data = (char) (data + ('M' - 'A'));
//						if (data > 'Z') {
//							data = (char) (data -  26);
//						}
//					}

					if (data >= 32 && data <= 64) {
						write.write(data);
					}
					if (data >= 65 && data <= 90) { // ABC
						if (data >= 88) {
							data = data - 26;
						}
						write.write((char) (data) + 3);
					}
					if (data > 96 && data < 123) { //abc
						if (data > 119) {
							data = data - 26;
						}
						write.write((char) (data) + 3);
					}
				}
			}


			read.close();
			write.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
