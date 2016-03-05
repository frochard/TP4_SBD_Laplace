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
		System.out.println("Pour un tableau de "+tab1.getN()+" entiers, on obtient les valeurs perturbées : ");
		double valPerturbee1=tab1.getTestCount()+laplace1.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee1+" avec epsilon =1000. ");
		double valPerturbee2=tab1.getTestCount()+laplace2.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee2+" avec epsilon =1. ");
		double valPerturbee3=tab1.getTestCount()+laplace3.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee3+" avec epsilon =0,01. ");
		double valPerturbee4=tab1.getTestCount()+laplace4.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee4+" avec epsilon =0,0001. ");
		//Affichage desperturbations générées pour le tableau 2
		System.out.println("Pour un tableau de "+tab2.getN()+" entiers, on obtient les valeurs perturbées : ");
		valPerturbee1=tab2.getTestCount()+laplace1.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee1+" avec epsilon =1000. ");
		valPerturbee2=tab2.getTestCount()+laplace2.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee2+" avec epsilon =1. ");
		valPerturbee3=tab2.getTestCount()+laplace3.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee3+" avec epsilon =0,01. ");
		valPerturbee4=tab2.getTestCount()+laplace4.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee4+" avec epsilon =0,0001. ");
		//Affichage desperturbations générées pour le tableau 1
		System.out.println("Pour un tableau de "+tab3.getN()+" entiers, on obtient les valeurs perturbées : ");
		valPerturbee1=tab3.getTestCount()+laplace1.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee1+" avec epsilon =1000. ");
		valPerturbee2=tab3.getTestCount()+laplace2.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee2+" avec epsilon =1. ");
		valPerturbee3=tab3.getTestCount()+laplace3.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee3+" avec epsilon =0,01. ");
		valPerturbee4=tab3.getTestCount()+laplace4.genNoise(sensibilite, 1);
		System.out.println("- "+valPerturbee4+" avec epsilon =0,01. ");
		
		
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
		while(nbRatioOK<5){
			valPerturbee=tabQ6.getTestCount()+laplace.genNoise(sensibilite, 1);
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
		System.out.println("Le count est égal à "+ tabQ6.getTestCount() +". ");
		System.out.println("On obtient 5 valeurs  consecutives du ratio comprises entre 0.9 et 1.1 au bout de "+ nbValPerturbee +" perturbations. ");
		

		
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
			errValPerturbee+=Math.abs(laplace.genNoise(sensibilite, 1));
			//On calcule la moyenne des erreurs des valeurs perturbées
			moyErrValPerturbee=errValPerturbee/i;
		}
		System.out.println("**************************");
		System.out.println("La sensibilite est  : "+sensibilite);
		System.out.println("L'agregat SUM est : "+tabQ7.getTestSum());
		System.out.println("moyenne des erreurs pour un agreegat de type SUM : " + moyErrValPerturbee);
		

	}
}