package logic;

import java.util.ArrayList;

public class CalcRate {
	
	private ArrayList<String> joiner;
	//@SuppressWarnings("unused")
	private double A,T,C,G,GAP,gGAP,gA,gC,gT,gG,gR,gY,P1,P2,Q,Z;

	public CalcRate(ArrayList<String> joiner){
		this.setJoiner(joiner);
	}
	
	public void some() throws Exception{
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
				}else{
					throw new Exception("You have Ns");
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
		
		for(int a = 0; a < joiner.size() - 2; a+=2){
			P1 = 0.0;
			P2 = 0.0;
			Q = 0.0;
			Z = 0.0;
			for(int b = 0; b < joiner.get(a+1).length(); b++){
				if(joiner.get(a+1).charAt(b) == 'A' && joiner.get(a+3).charAt(b) == 'G'){
					P1++;
				}else if(joiner.get(a+1).charAt(b) == 'G' && joiner.get(a+3).charAt(b) == 'A'){
					P1++;
				}else if(joiner.get(a+1).charAt(b) == 'T' && joiner.get(a+3).charAt(b) == 'C'){
					P2++;
				}else if(joiner.get(a+1).charAt(b) == 'C' && joiner.get(a+3).charAt(b) == 'T'){
					P2++;
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
