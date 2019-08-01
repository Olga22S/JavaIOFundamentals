package ru.epam.javaio.secondtask;

import java.io.*;

public class Main {

	public static void main(String[] args) {
		File file = new File("datatask2" + File.separator + "file.txt");
		if (file.exists()) {
			try (BufferedReader bufferedReader = new BufferedReader(new FileReader(file));
					BufferedWriter bufferedWriter = new BufferedWriter(
							new FileWriter(new File("datatask2" + File.separator + "changedFile.txt")))) {
				String line;
				while ((line = bufferedReader.readLine()) != null) {
					bufferedWriter.append(line.replace("public", "private")).append(System.lineSeparator());
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
