package logic;

import java.util.ArrayList;

public class CalcRate {
	
	private ArrayList<String> joiner;
	@SuppressWarnings("unused")
	private double A,T,C,G,GAP,gA,gC,gT,gG,gGAP,gR,gY;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	public void some(){
		gA = 0.0;
		gT = 0.0;
		gC = 0.0;
		gG = 0.0;
		gGAP = 0.0;
		for(int i = 1; i < joiner.size(); i+=2){
			A = 0.0;
			T = 0.0;
			C = 0.0;
			G = 0.0;
			GAP = 0.0;
			
			for(int j = 0; j < joiner.get(i).length(); j++){
				if(joiner.get(i).charAt(j) == 'A'){
					A++;
				}else if(joiner.get(i).charAt(j) == 'T'){
					T++;
				}else if(joiner.get(i).charAt(j) == 'C'){
					C++;
				}else if(joiner.get(i).charAt(j) == 'G'){
					G++;
				}else if(joiner.get(i).charAt(j) == '-'){
					GAP++;
				}
			}
			
			gA+=A/((double) joiner.get(i).length());
			gT+=T/(double) joiner.get(i).length();
			gC+=C/(double) joiner.get(i).length();
			gG+=G/(double) joiner.get(i).length();
			gGAP+=GAP/(double) joiner.get(i).length();
		}
		gA=gA/((double) joiner.size()/2);
		gT=gT/((double) joiner.size()/2);
		gC=gC/((double) joiner.size()/2);
		gG=gG/((double) joiner.size()/2);
		gGAP=GAP/((double) joiner.size()/2);
		
		gR = gA + gG;
		gY = gT + gC;
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
