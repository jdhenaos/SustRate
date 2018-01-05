package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class CalcRate {
	
	private ArrayList<String> joiner;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
