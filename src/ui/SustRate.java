package ui;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class SustRate {

	/**
	 * @param args
	 */
	static FileReader reader;
	private static String line;
	private static ArrayList<String> joiner = new ArrayList<String>();
	
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		
		
		
		BufferedReader buffer = new BufferedReader(reader = new FileReader("/home/juan/soft/filogenia/ejemplo alignment.fa"));
		
		while((line = buffer.readLine()) != null){
			if(line.startsWith(">")){
				joiner.add(line);
			}else{
				if(joiner.get(joiner.size()-1).startsWith(">")){
					joiner.add(line);
				}else{
					joiner.set(joiner.size()-1, joiner.get(joiner.size()-1)+line);
				}
			}
		}
		
		for(int i = 0; i < joiner.size(); i++){
			System.out.println(joiner.get(i));
		}

	}

}
