package logic;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;

public class CalcRate {
	
	private ArrayList<String> joiner;
	private Hashtable<String,Hashtable<String,Double>> data = new Hashtable<String,Hashtable<String,Double>>();
	private Hashtable<String,Double> subdata = new Hashtable<String,Double>();
	private double aCounter, tCounter, gCounter, cCounter,gapCounter;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	@SuppressWarnings({ "unchecked"})
	private Hashtable<String, Hashtable<String, Double>> dataCreater(){
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
	
	public double P1ij(String alfa, String beta){
		
		String seq1;
		String seq2;
		
		for(int z = 0; z < joiner.size(); z++){
			System.out.println(joiner.get(z));
		}
		
		return(0.9);
	}
	
	public void Results(){
		
		Hashtable<String,Hashtable<String,Double>> input = dataCreater();
		
		Object[][] K1 = new Object[input.size()][input.size()];
		
		Set<String> keys = input.keySet();
		String[] names = new String[input.size()];
		int counter1 = 0;
		for(String key : keys){
			names[counter1] = key;
			counter1++;
		}
		
		for(int o = 0; o < names.length; o++){
			for(int i = 0; i < names.length; i++){
				double gA = (input.get(names[o]).get("gA")+input.get(names[i]).get("gA"))/2;
				double gT = (input.get(names[o]).get("gT")+input.get(names[i]).get("gT"))/2;
				double gG = (input.get(names[o]).get("gG")+input.get(names[i]).get("gG"))/2;
				double gC = (input.get(names[o]).get("gC")+input.get(names[i]).get("gC"))/2;
				double gGAP = (input.get(names[o]).get("gGAP")+input.get(names[i]).get("gGAP"))/2;
				double gR = gA + gG;
				double gY = gT + gC;
				
				double P1 = P1ij(names[o],names[i]);
				
				K1[o][i] = gGAP;
			}
		}
		
		System.out.println(K1[5][4]);
		
		/*
		for(int a = 0; a < names.length; a++){
			for(int b = 0; b < names.length; b++){
				System.out.print(K1[a][b]);
				System.out.print("\t");
			}
			
			System.out.println();
		}
		*/
		
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
