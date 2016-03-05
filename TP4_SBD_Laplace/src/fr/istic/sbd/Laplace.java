package fr.istic.sbd;

public class Laplace {

	private double epsilon;
	private double resteBudget;
	private boolean test;
	
	public Laplace() {

	}

	public Laplace(double epsilon) {
		this.epsilon = epsilon;
		this.test=true;
		this.resteBudget=epsilon;
	}

	public boolean isTest() {
		return test;
	}

	public void setTest(boolean test) {
		this.test = test;
	}

	public double getEpsilon() {
		return epsilon;
	}

	public void setEpsilon(double epsilon) {
		this.epsilon = epsilon;
	}

	public double getResteBudget() {
		return resteBudget;
	}

	public void setResteBudget(double resteBudget) {
		this.resteBudget = resteBudget;
	}

	/*
	 * Fonction de generation du bruit
	 */
	public double genNoise(int sensibilite, double proportionBudget){
		//Declaration de la variable a retourner
		double bruit=0;
		//On test si on ne depasse pas le seuil
		if(test || this.resteBudget+proportionBudget<=this.epsilon){
			//Verification du mode
			if(!test){
				this.resteBudget-=proportionBudget;
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