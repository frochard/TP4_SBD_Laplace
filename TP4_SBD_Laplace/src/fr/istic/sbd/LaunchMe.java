package fr.istic.sbd;

public class LaunchMe {

	public LaunchMe() {

	}

	public static void main(String[] args) {
		//Valeur parametre de confidentialite
		double epsilon=0.0001;
		//Initialisation de la sensibilite
		int sensibilite=0;

		System.out.println("*******************");
		System.out.println("Question 5");
		System.out.println("*******************");

		//On affecte la sensibilite du count
		sensibilite=1;
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tab1=new IntArray(10,1000);
		IntArray tab2=new IntArray(100,1000);
		IntArray tab3=new IntArray(1000,1000);
		//Creaion de la fonction de Laplace avec differentes valeus de Epsilon
		Laplace laplace1 = new Laplace(1000);
		Laplace laplace2 = new Laplace(1);
		Laplace laplace3 = new Laplace(0.01);
		Laplace laplace4 = new Laplace(0.0001);

		//Affichage desperturbations générées pour le tableau 1
		System.out.println("Pour un tableau de "+tab1.getN()+" entiers, On obtient pour un COUNT une valeur non perturbée de "+tab1.getTestCount()
		+". On obtient les valeurs perturbées : ");
		double perturbationGeneree1=laplace1.genNoise(sensibilite, 1000/4);
		double valPerturbee1=tab1.getTestCount()+perturbationGeneree1;
		System.out.println("- "+valPerturbee1+" avec epsilon =1000 (le bruit généré est "+perturbationGeneree1+" ). ");
		double perturbationGeneree2=laplace2.genNoise(sensibilite, 1/4);
		double valPerturbee2=tab1.getTestCount()+perturbationGeneree2;
		System.out.println("- "+valPerturbee2+" avec epsilon =1 (le bruit généré est "+perturbationGeneree2+" ). ");
		double perturbationGeneree3=laplace3.genNoise(sensibilite, 0.01/4);
		double valPerturbee3=tab1.getTestCount()+perturbationGeneree3;
		System.out.println("- "+valPerturbee3+" avec epsilon =0,01 (le bruit généré est "+perturbationGeneree3+" ). ");
		double perturbationGeneree4=laplace4.genNoise(sensibilite, 0.0001/4);
		double valPerturbee4=tab1.getTestCount()+perturbationGeneree4;
		System.out.println("- "+valPerturbee4+" avec epsilon =0,0001 (le bruit généré est "+perturbationGeneree4+" ). ");
		//Affichage desperturbations générées pour le tableau 2
		System.out.println("Pour un tableau de "+tab2.getN()+" entiers, On obtient pour un COUNT une valeur non perturbée de "+tab2.getTestCount()
		+". On obtient les valeurs perturbées : ");
		perturbationGeneree1=laplace1.genNoise(sensibilite, 1000/4);
		valPerturbee1=tab2.getTestCount()+perturbationGeneree1;
		System.out.println("- "+valPerturbee1+" avec epsilon =1000 (le bruit généré est "+perturbationGeneree1+" ). ");
		perturbationGeneree2=laplace2.genNoise(sensibilite, 1/4);
		valPerturbee2=tab2.getTestCount()+perturbationGeneree2;
		System.out.println("- "+valPerturbee2+" avec epsilon =1 (le bruit généré est "+perturbationGeneree2+" ). ");
		perturbationGeneree3=laplace3.genNoise(sensibilite, 0.01/4);
		valPerturbee3=tab2.getTestCount()+perturbationGeneree3;
		System.out.println("- "+valPerturbee3+" avec epsilon =0,01 (le bruit généré est "+perturbationGeneree3+" ). ");
		perturbationGeneree4=laplace4.genNoise(sensibilite, 0.0001/4);
		valPerturbee4=tab2.getTestCount()+perturbationGeneree4;
		System.out.println("- "+valPerturbee4+" avec epsilon =0,0001 (le bruit généré est "+perturbationGeneree4+" ). ");
		//Affichage desperturbations générées pour le tableau 3
		System.out.println("Pour un tableau de "+tab3.getN()+" entiers, On obtient pour un COUNT une valeur non perturbée de "+tab3.getTestCount()
		+". On obtient les valeurs perturbées : ");
		perturbationGeneree1=laplace1.genNoise(sensibilite, 1000/4);
		valPerturbee1=tab3.getTestCount()+perturbationGeneree1;
		System.out.println("- "+valPerturbee1+" avec epsilon =1000 (le bruit généré est "+perturbationGeneree1+" ). ");
		perturbationGeneree2=laplace2.genNoise(sensibilite, 1/4);
		valPerturbee2=tab3.getTestCount()+perturbationGeneree2;
		System.out.println("- "+valPerturbee2+" avec epsilon =1 (le bruit généré est "+perturbationGeneree2+" ). ");
		perturbationGeneree3=laplace3.genNoise(sensibilite, 0.01/4);
		valPerturbee3=tab3.getTestCount()+perturbationGeneree3;
		System.out.println("- "+valPerturbee3+" avec epsilon =0,01 (le bruit généré est "+perturbationGeneree3+" ). ");
		perturbationGeneree4=laplace4.genNoise(sensibilite, 0.0001/4);
		valPerturbee4=tab3.getTestCount()+perturbationGeneree4;
		System.out.println("- "+valPerturbee4+" avec epsilon =0,0001 (le bruit généré est "+perturbationGeneree4+" ). ");
		

		System.out.println("*******************");
		System.out.println("Question 6");
		System.out.println("*******************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ6=new IntArray(1000,1000);
		//On instancie Laplace
		Laplace laplace = new Laplace(epsilon);

		//On perturbe la valeur jusqu'a atteindre 5 valeurs consecutives du ratio comprises entre 0.9 et 1.1
		double valPerturbee=0;
		double sumValPerturbee=0;
		double moyValPerturbee=0;
		double ratio=0;
		int nbValPerturbee=0;
		int nbRatioOK=0;
		while(nbRatioOK<5 && laplace.getResteBudget()>=0){
			valPerturbee=tabQ6.getTestCount()+laplace.genNoise(sensibilite, epsilon/4);
			nbValPerturbee++;
			sumValPerturbee+=valPerturbee;
			moyValPerturbee=sumValPerturbee/nbValPerturbee;
			ratio=moyValPerturbee/tabQ6.getTestCount();
			//Test si le ratio est compris entre 0.9 et 1.1
			if(Math.abs(ratio-1)<=0.1){
				nbRatioOK++;
			}else{
				nbRatioOK=0;
			}
			System.out.println(ratio);
		}
		if(nbRatioOK==5){
			System.out.println("Le count est égal à "+ tabQ6.getTestCount() +". ");
			System.out.println("On obtient 5 valeurs  consecutives du ratio comprises entre 0.9 et 1.1 au bout de "+ nbValPerturbee +" perturbations. ");
		}else{
			System.out.println("Le budget a été consommé avant d'atteindre 5 valeurs  consecutives du ratio comprises entre 0.9 et 1.1. ");
		}

		System.out.println("*******************");
		System.out.println("Question 7");
		System.out.println("*******************");
		//On initialise la sensibilite
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ7=new IntArray(1000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ7.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		double errValPerturbee=0;
		double moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		System.out.println("**************************");
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ7.getTestSum());
		System.out.println("moyenne des erreurs pour un agregat de type SUM : " + moyErrValPerturbee);

		
		
		
		
		System.out.println("*******************");
		System.out.println("Question 10 : Evolution pour un agrégat de type SUM du ratio en fonction de la taille du tableau et "
				+ "affichage de taille de tableau losque le ratio devient inferieur a 10%");
		System.out.println("*******************");

		System.out.println("********* Tableau de 100 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10_2=new IntArray(100,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ10_2.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10_2.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ10_2.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 1.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10_3=new IntArray(1000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ10_3.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10_3.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ10_3.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 10.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10_4=new IntArray(10000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ10_4.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10_4.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ10_4.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 100.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10_5=new IntArray(100000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ10_5.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10_5.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ10_5.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 1.000.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10_6=new IntArray(1000000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ10_6.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10_6.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ10_6.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 265.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10_7=new IntArray(265000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=tabQ10_7.getM();
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10_7.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ10_7.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		
		
		
		
		
		
		
		
		
		
		
		System.out.println("*******************");
		System.out.println("Question 10c : Evolution pour un agrégat de type Count du ratio en fonction de la taille du tableau et "
				+ "affichage de taille de tableau losque le ratio devient inferieur a 10%");
		System.out.println("*******************");

		System.out.println("********* Tableau de 100 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10c_2=new IntArray(100,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=1;
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10c_2.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat COUNT est : "+tabQ10c_2.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 1.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10c_3=new IntArray(1000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=1;
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10c_3.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat COUNT est : "+tabQ10c_3.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 10.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10c_4=new IntArray(10000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=1;
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10c_4.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat COUNT est : "+tabQ10c_4.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 100.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10c_5=new IntArray(100000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=1;
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10c_5.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat COUNT est : "+tabQ10c_5.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 1.000.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10c_6=new IntArray(1000000,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=1;
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10c_6.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat COUNT est : "+tabQ10c_6.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

		System.out.println("********* Tableau de 265.000 éléments *****************");
		//Creation des tableau d'entiers avec differentes tailles de tableau
		IntArray tabQ10c_7=new IntArray(260,1000);
		//On fixe la sensibilite a la valeur max du tableau
		sensibilite=1;
		//On passe en mode TEST
		laplace.setTest(true);
		//On initialise les variables nécessaires au traitement
		errValPerturbee=0;
		moyErrValPerturbee=0;
		//On lance 1000 perturbations
		for(int i=1;i<=1000;i++){
			//On recupere la valeur absolue de la valeur perturbee
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, epsilon/4));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		//Calcul du ratio
		ratio=moyErrValPerturbee/tabQ10c_7.getTestSum();
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat COUNT est : "+tabQ10c_7.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		System.out.println("Le ratio est " + ratio);
		

	}
}