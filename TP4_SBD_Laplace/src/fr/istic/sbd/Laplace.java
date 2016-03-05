package fr.istic.sbd;

public class Laplace {

	private double epsilon;
	private double Budget;
	private boolean test;
	
	public Laplace() {

	}

	public Laplace(double epsilon) {
		this.epsilon = epsilon;
		this.Budget=10;
		this.test=true;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	/*
	 * Fonction de generation du bruit
	 */
	public double genNoise(int sensibilite, double proportionBudget){
		//Declaration de la variable a retourner
		double bruit=0;
		//On test si on ne depasse pas le seuil
		if(test || proportionBudget<=this.Budget){
			//Verification du mode
			if(!test){
				this.Budget-=proportionBudget;
			}
			//On definit une varaible u tirée selon une loi uniforme continue dans l'intervalle [-1/2, 1/2], 
			double u=Math.random()-0.5;
			//Definition de la variable aleatoire
			double b=sensibilite/this.epsilon;
			double uSign=Math.signum(u);
			bruit=0-b*uSign*Math.log(1-2*Math.abs(u));
		}
		return bruit;
	}
}