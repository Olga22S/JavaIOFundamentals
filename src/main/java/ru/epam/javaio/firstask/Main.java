package ru.epam.javaio.firstask;

import java.io.*;
import java.util.Arrays;
import java.util.Random;

public class Main {

	public static void main(String[] args) throws IOException {
		File directory = new File("datatask1");
		directory.mkdir();
		File file = new File(directory + File.separator + "randomNumbers.txt");
		Random random = new Random();
		int[] randomNumbers = random.ints(10, 1, 11).toArray();
		write(file, randomNumbers);
		int[] numbersFromFile = readFile(file);
		Arrays.sort(numbersFromFile);
		write(new File(directory + File.separator + "numbersAfterSorting.txt"), numbersFromFile);
	}

	private static void write(File file, int[] numbers) {
		try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
			for (int i = 0; i < numbers.length; i++) {
				writer.write(Integer.toString(numbers[i]));
				writer.write(System.lineSeparator());
			}
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static int[] readFile(File file) {
		int[] array = null;
		try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
			array = reader.lines().mapToInt(Integer::parseInt).toArray();
		} catch (IOException | NumberFormatException ex) {
			ex.printStackTrace();
		}
		return array;
	}
}
