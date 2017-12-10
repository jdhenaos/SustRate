package logic;

import java.util.ArrayList;
import java.util.Hashtable;

public class CalcRate {
	
	private ArrayList<String> joiner;
	private Hashtable<String,Hashtable> data = new Hashtable<String,Hashtable>();
	private int aCounter, tCounter;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	public void dataCreater(){
		for(int i = 0; i < joiner.size(); i+=2){
			aCounter = 0;
			tCounter = 0;
			for(int j = 0; j < joiner.get(i+1).length(); j++){
				char variable = joiner.get(i+1).charAt(j);
				switch(variable){
					case 'A':
						aCounter++;
						break;
					case 'T':
						tCounter++;
						break;
				}
			}
		}
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
