package fr.istic.sbd;

public class Laplace {

	private double epsilon;
	private double epsilonTotal;
	private boolean test;
	
	public Laplace(double epsilon) {
		this.epsilon = epsilon;
		this.epsilonTotal=1;
		this.test=true;
	}


	public Laplace() {

	}

	public double genNoise(int sensibilite, double proportionBudget){
		double varAleatoire=0;
		double consommable = this.epsilon+proportionBudget;
		if(test || consommable<=this.epsilonTotal){
			//Verification du mode
			if(!test){
				this.epsilon+=proportionBudget;
				
			}
			//On definit une varaible u, tirée selon une loi uniforme continue dans l'intervalle [-1/2, 1/2], 
			double u=Math.random()-0.5;
			//Definition de la variable aleatoire
			varAleatoire=0-(sensibilite/proportionBudget)*Math.signum(u)*Math.log(1-2*Math.abs(u));
			
		}
		return varAleatoire;
	}
	
}
