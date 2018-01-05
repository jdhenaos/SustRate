package logic;

import java.util.ArrayList;

public class CalcRate {
	
	private ArrayList<String> joiner;
	private double A,T,C,G,GAP,gGAP,gA,gC,gT,gG,gR,gY,P1,P2,Q,Z,K1,K2,B,K3;

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
		
		System.out.print("First ID");
		System.out.print("\t");
		System.out.print("Second ID");
		System.out.print("\t");
		System.out.print("P1ij");
		System.out.print("\t");
		System.out.print("P2ij");
		System.out.print("\t");
		System.out.print("Qij");
		System.out.print("\t");
		System.out.print("GAPij");
		System.out.print("\t");
		System.out.print("K1");
		System.out.print("\t");
		System.out.print("K2");
		System.out.print("\t");
		System.out.print("Bij");
		System.out.print("\t");
		System.out.println("K3");
		
		for(int a = 0; a < joiner.size() - 2; a+=2){
			P1 = 0.0;
			P2 = 0.0;
			Q = 0.0;
			Z = 0.0;
			K1 = 0.0;
			K2 = 0.0;
			B = 0.0;
			K3 = 0.0;
			for(int b = 0; b < joiner.get(a+1).length(); b++){
				if(joiner.get(a+1).charAt(b) == 'A' && joiner.get(a+3).charAt(b) == 'G'){
					P1++;
				}else if(joiner.get(a+1).charAt(b) == 'G' && joiner.get(a+3).charAt(b) == 'A'){
					P1++;
				}else if(joiner.get(a+1).charAt(b) == 'T' && joiner.get(a+3).charAt(b) == 'C'){
					P2++;
				}else if(joiner.get(a+1).charAt(b) == 'C' && joiner.get(a+3).charAt(b) == 'T'){
					P2++;
				}else if(joiner.get(a+1).charAt(b) == 'A' && joiner.get(a+3).charAt(b) == 'T'){
					Q++;
				}else if(joiner.get(a+1).charAt(b) == 'T' && joiner.get(a+3).charAt(b) == 'A'){
					Q++;
				}else if(joiner.get(a+1).charAt(b) == 'C' && joiner.get(a+3).charAt(b) == 'G'){
					Q++;
				}else if(joiner.get(a+1).charAt(b) == 'G' && joiner.get(a+3).charAt(b) == 'C'){
					Q++;
				}else if(joiner.get(a+1).charAt(b) == '-'){
					Z++;
				}
			}
			P1/=(double) joiner.get(a+1).length();
			P2/=(double) joiner.get(a+1).length();
			Q/=(double) joiner.get(a+1).length();
			Z/=(double) joiner.get(a+1).length();
			
			K1 = (P1/(double) (gA*gG))/(Q/(gR*gY*gGAP));
			K2 = (P2/(double) (gA*gG))/(Q/(gR*gY*gGAP));
			B = Q/(4.0*(double) (gR*gY*gGAP));
			K3 = Z/(4.0*(double) (gR*gY*gGAP));
			
			System.out.print(joiner.get(a));
			System.out.print("\t");
			System.out.print(joiner.get(a+2));
			System.out.print("\t");
			System.out.print(P1);
			System.out.print("\t");
			System.out.print(P2);
			System.out.print("\t");
			System.out.print(Q);
			System.out.print("\t");
			System.out.print(Z);
			System.out.print("\t");
			System.out.print(K1);
			System.out.print("\t");
			System.out.print(K2);
			System.out.print("\t");
			System.out.print(B);
			System.out.print("\t");
			System.out.println(K3);
		}
	}
	
	public ArrayList<String> getJoiner() {
		return joiner;
	}

	public void setJoiner(ArrayList<String> joiner) {
		this.joiner = joiner;
	}

}
