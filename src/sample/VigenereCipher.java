package sample;

import java.io.*;
import java.nio.charset.StandardCharsets;

/**
 * @author Martin Dolinsky
 */
public class VigenereCipher {

	public String encrypt(String givenKey, String path) {
		if (givenKey.equals("")) {
			return "Wrong input";
		}
		StringBuilder data = new StringBuilder();
		String key = givenKey.toUpperCase();
		int keyPosition = 0;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			int character;
			while ((character = reader.read()) != -1) {
				if (key.charAt(keyPosition) < 65) {
					return "wrong input";
				}
				if ((char) character >= 65 && (char) character <= 90) {
					char letter = (char) (character + ((key.charAt(keyPosition)) - 65));
					if ((int) letter > 90) {
						letter -= 26;
					}
					data.append(letter);
				} else if ((char) character >= 97 && (char) character <= 122) {
					char letter = (char) (character + ((key.charAt(keyPosition)) - 65));
					if ((int) letter > 122) {
						letter -= 26;
					}
					data.append(letter);
				} else {
					data.append((char) character);
				}
				if (!(character >= 32 && character < 65)) {
					keyPosition++;
				}
				if (keyPosition >= key.length()) {
					keyPosition = 0;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/data_encrypt.txt"));
			writer.write(data.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return data.toString();
	}

	public String decrypt(String givenKey, String path) {
		if (givenKey.equals("")) {
			return "Wrong input";
		}
		StringBuilder data = new StringBuilder();
		String key = givenKey.toLowerCase();
		int keyPosition = 0;

		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path), StandardCharsets.UTF_8));
			int character;
			while ((character = reader.read()) != -1) {
				if (key.charAt(keyPosition) < 97) {
					return "Wrong input";
				}
				if ((char) character >= 65 && (char) character <= 90) {
					char letter = (char) (character - ((key.charAt(keyPosition)) - 97));
					if ((int) letter < 65) {
						letter += 26;
					}
					data.append(letter);
				} else if ((char) character >= 97 && (char) character <= 122) {
					char letter = (char) (character - ((key.charAt(keyPosition)) - 97));
					if ((int) letter < 97) {
						letter += 26;
					}
					data.append(letter);
				} else {
					data.append((char) character);
				}
				if (!(character >= 32 && character < 65)) {
					keyPosition++;
				}
				if (keyPosition >= key.length()) {
					keyPosition = 0;
				}
			}
			reader.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			BufferedWriter writer = new BufferedWriter(new FileWriter("src/data_decrypt.txt"));
			writer.write(data.toString());
			writer.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return data.toString();
	}
}
