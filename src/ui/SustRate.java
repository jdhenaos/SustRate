package ui;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class SustRate {

	/**
	 * @param args
	 */
	static FileReader reader;
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		String line;
		
		BufferedReader buffer = new BufferedReader(reader = new FileReader("/home/juan/soft/SustRate/test.txt"));
		
		while((line = buffer.readLine()) != null){
			System.out.println(line);
		}

	}

}
