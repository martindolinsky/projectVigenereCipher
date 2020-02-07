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
			Scanner read = new Scanner(myFile);
			String data = null;
			ArrayList<Character> list = new ArrayList();

			ArrayList<Character> keyArray = new ArrayList();
			ArrayList<Character> resultList = new ArrayList();

			for (int i = 0; i < key.length(); i++) {
				keyArray.add(Character.toUpperCase(key.charAt(i)));
			}

			System.out.println(keyArray);

			int count = 0;

			if (!key.equals("")) {
				while (read.hasNextLine()) { //123.,?
					data = read.nextLine();
				}
				for (int i = 0; i < data.length(); i++) {
					list.add(data.charAt(i));
				}
				for (int i = 0; i < key.length(); i++) {
					keyArray.add(Character.toUpperCase(key.charAt(i)));
				}
				for (int i = 0; i < list.size(); i++) {
					if (count == keyArray.size()) {
						count = 0;
					}
					int value = (int) list.get(i);
					if (value < 91 && value > 64 || value < 123 && value > 96) {
						resultList.add((char) (list.get(i) + keyArray.get(count)));
						count++;
					} else {
						resultList.add(list.get(i));
					}
				}
				String result = "";
				for (int i = 0; i < resultList.size(); i++) {
					result += String.valueOf(resultList.get(i));
				}
				System.out.println(list);
				System.out.println(resultList);
				System.out.println(result);
			}
			read.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
