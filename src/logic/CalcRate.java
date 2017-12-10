package logic;

import java.util.ArrayList;

public class CalcRate {
	
	private ArrayList<String> joiner;
	private ArrayList<Object> data = new ArrayList<Object>();

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	public void dataCreater(){
		for(int i = 0; i < joiner.size(); i++){
			System.out.println(joiner.get(i));
		}
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
