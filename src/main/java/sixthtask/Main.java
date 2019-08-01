package sixthtask;

import java.io.*;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Data type?");
		String userChoice = scanner.next();
		
		 Types type = userChoice.equals("int") ? Types.INT : userChoice.equals("char") ? Types.CHAR : userChoice
	                .equals("double") ? Types.DOUBLE : Types.STRING;
	        System.out.println("You have selected type: " + type);
		
		try(BufferedReader reader = new BufferedReader(new FileReader("datatask6" + File.separator + "file.txt"))){
			 String line = null;
		        TypeDetector detector = new TypeDetector();
		        while ((line = reader.readLine()) != null) {
		            String[] simbols = line.trim().split(" ");
		            for (String s : simbols) {
		                if (detector.getType(s) == type)	                   
	                	System.out.println(s);
	            }
	        }
			
	}catch(IOException ex) {
		ex.printStackTrace();
	}
	}
	
	
}
