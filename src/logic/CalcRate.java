package logic;

import java.util.ArrayList;
import java.util.Hashtable;

public class CalcRate {
	
	private ArrayList<String> joiner;
	private Hashtable<String,Hashtable<String,Integer>> data = new Hashtable<String,Hashtable<String,Integer>>();
	private Hashtable<String,Integer> subdata = new Hashtable<String,Integer>();
	private int aCounter, tCounter, gCounter, cCounter,gapCounter;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	public void dataCreater(){
		for(int i = 0; i < joiner.size(); i+=2){
			aCounter = 0;
			tCounter = 0;
			gCounter = 0;
			cCounter = 0;
			gapCounter = 0;
			for(int j = 0; j < joiner.get(i+1).length(); j++){
				String variable = Character.toString(joiner.get(i+1).charAt(j));
				if(variable.equals("A")){
					aCounter++;
				}else if(variable.equals("T")){
					tCounter++;
				}else if(variable.equals("C")){
					cCounter++;
				} else if(variable.equals("G")){
					gCounter++;
				}else if(variable.equals("-")){
					gapCounter++;
				}else{
					throw new IllegalStateException("You have non-nucleotide symbols. Possible Ns were found");
				}
			}
			subdata.put("gA", (aCounter/joiner.get(i+1).length())/(joiner.size()/2));
			subdata.put("gT", (tCounter/joiner.get(i+1).length())/(joiner.size()/2));
			subdata.put("gG", (gCounter/joiner.get(i+1).length())/(joiner.size()/2));
			subdata.put("gC", (cCounter/joiner.get(i+1).length())/(joiner.size()/2));
			data.put(joiner.get(i), subdata);
		}
		
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
