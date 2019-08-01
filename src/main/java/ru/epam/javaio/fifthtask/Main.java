package ru.epam.javaio.fifthtask;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		File file = new File("datatask5" + File.separator + "studentGrades.txt");
		if (file.exists()) {
			try (Scanner scaner = new Scanner(file);
					PrintWriter printWriter = new PrintWriter(
							new File("datatask5" + File.separator + "studentGradesOut.txt"))) {
				String[] student;
				while (scaner.hasNextLine()) {
					student = scaner.nextLine().split("\\s+");
					double sum = 0;
					for (int i = 1; i < student.length; i++) {
						sum += Integer.parseInt(student[i]);
					}
					if (sum / (student.length - 1) > 7) {
						printWriter.println(student[0].toUpperCase());
					}
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}
}
