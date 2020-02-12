package sample;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

/**
 * @author Martin Dolinsky
 */
public class MyFile {
	private String sourceFile;
	private String parentDirectory;

	public MyFile(String sourceFile, String parentDirectory) {
		this.sourceFile = sourceFile;
		this.parentDirectory = parentDirectory;
	}

	public String getSourceFile() {
		return sourceFile;
	}

	public String getParentDirectory() {
		return parentDirectory;
	}

	public String readFile(String sourceFile) {
		StringBuilder data = new StringBuilder();
		try{
			File file = new File(sourceFile);
			Scanner sc = new Scanner(file);
			while(sc.hasNextLine()){
				data.append("\n").append(sc.nextLine());
			}
			sc.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return data.toString();
	}


}
