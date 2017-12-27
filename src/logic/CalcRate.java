package logic;

import java.util.ArrayList;
import java.util.Hashtable;

public class CalcRate {
	
	private ArrayList<String> joiner;
	private Hashtable<String,Hashtable<String,Double>> data = new Hashtable<String,Hashtable<String,Double>>();
	private Hashtable<String,Double> subdata = new Hashtable<String,Double>();
	private double aCounter, tCounter, gCounter, cCounter,gapCounter;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	@SuppressWarnings({ "unchecked", "rawtypes" })
	private Hashtable dataCreater(ArrayList<String> joiner){
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
			subdata.put("gA", aCounter/joiner.get(i+1).length());
			subdata.put("gT", tCounter/joiner.get(i+1).length());
			subdata.put("gG", gCounter/joiner.get(i+1).length());
			subdata.put("gC", cCounter/joiner.get(i+1).length());
			subdata.put("gGAP", gapCounter/joiner.get(i+1).length());
			data.put(joiner.get(i), (Hashtable<String, Double>) subdata.clone());
		}
		return(data);
	}
	
	public void P1ij(){
		
		Hashtable<String,Hashtable<String,Double>> input = new Hashtable<String,Hashtable<String,Double>>();
		
		input = dataCreater(this.joiner);
		
		System.out.println(input.size());
		
		Object[][] resultP1s = new Object[2][2];
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
