package fr.istic.sbd;



public class IntArray {

	//Taille n du tableau d'entrée
	private int n=1000;
	//Valeur maximale m de chaque elt du tableau
	private int m=1000;
	// Generation du tableau
	private int[] tableau;
	//Nb valeur > à m/2
	private int testCount;
	//Somme des valeurs > à m/2
	int testSum;
	
	
	public IntArray() {

	}

	public IntArray(int n, int m) {
		this.n = n;
		this.m = m;
		this.tableau=new int[n];
		this.testCount=0;
		this.testSum=0;
		for(int i=0;i<n;i++){
			tableau[i]=(int) Math.round((Math.random()*m));
			//On compte les valeurs inferieurs à m/2
			if(tableau[i]>=m/2){
				//Incrementation du count
				testCount++;
				//Augmentation de la sum
				testSum+=tableau[i];

			}
		}

	}



	public int getN() {
		return n;
	}

	public void setN(int n) {
		this.n = n;
	}

	public int getM() {
		return m;
	}

	public void setM(int m) {
		this.m = m;
	}

	public int[] getTableau() {
		return tableau;
	}

	public void setTableau(int[] tableau) {
		this.tableau = tableau;
	}

	public int getTestCount() {
		return testCount;
	}

	public void setTestCount(int testCount) {
		this.testCount = testCount;
	}

	public int getTestSum() {
		return testSum;
	}

	public void setTestSum(int testSum) {
		this.testSum = testSum;
	}

	
}
