package fr.istic.sbd;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LaunchMe {
	
	public LaunchMe() {
		
	}

	public static void main(String[] args) {
		//Taille n du tableau d'entrée
		int n=1000;
		//Valeur maximale m de chaque elt du tableau
		int m=20;
		//Valeur parametre de confidentialite
		double epsilon=0.0001;
		// Generation du tableau
		int[] tableau=new int[n];
		int sensibilite=0;
		for(int i=0;i<n;i++){
			tableau[i]=(int) Math.round((Math.random()*m));
			//On compte les valeurs inferieurs à m/2
			if(tableau[i]>=m/2){
				//Count
				sensibilite++;
				//Sum
				//sensibilite+=tableau[i];
			}
		}
		System.out.println(Arrays.toString(tableau));
		//On instancie Laplace
		Laplace laplace = new Laplace(epsilon);
		//Affichage de la perturbation générée
		System.out.println("perturbation générée : "+ sensibilite);
		double valPerturbee=0;
		double sumValPerturbee=0;
		double moyValPerturbee=0;
		double ratio=0;
		for(int i=1;i<=50;i++){
			valPerturbee=sensibilite+laplace.genNoise(sensibilite, 1);
			sumValPerturbee+=valPerturbee;
			moyValPerturbee=sumValPerturbee/i;
			ratio=moyValPerturbee/sensibilite;
			System.out.println(ratio);
//			System.out.println(i+";"+valPerturbee+";"+valPerturbee+";"+sumValPerturbee+";"+moyValPerturbee+";"+ratio);
		}
	}
}