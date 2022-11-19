package appli;

import java.util.Scanner;
import debat.*;

public class Appli {

	/**
	* La methode principale de l'application.
	* @param args Unused.
	* @return Nothing.
	*/

	public static void main(String[] args) {

	    options1();

	    options2();
	    
	}
	
	// ******************************
	// Public methods
	// ******************************
	
	/**
	* La methode qui affiche le premier menu.
	* @param args Unused.
	* @return Nothing.
	*/
	
	public static void menu1() {
		System.out.println("Que voulez-vous faire maintenant ?");
	    System.out.println("1. ajouter une contradiction \n 2. Fin");
	}
	
	/**
	* La methode qui gere l'acces aux differentes actions possibles a partir du 1er menu.
	* @param args Unused.
	* @return Nothing.
	*/
	
	public static void options1() {
		boolean goodChoice = false;
		boolean finPartie1 = false;
		System.out.println("Donnez le nombre d'arguments : ");
	    Scanner sc = new Scanner(System.in);
	    int nbArg = sc.nextInt();
	    Debat.createDebat(nbArg);
	    
		while (!goodChoice) {
	    	
		    while(!finPartie1) {
		    	
			    	menu1();
			    	int nbChoix = sc.nextInt();
			    	
			    switch(nbChoix) {
			    
			    case 1 : 
			    	
			    	System.out.println("Ajoutez la contradiction que vous souhaitez\n En premier, entrez l'argument qui contredit et, en deuxième, celui qui est contredit");
			    	
			    	String a1 = sc.next();
			    	String a2 = sc.next();
			    	Argument arg1 = null;
			    	Argument arg2 = null;
		
			    	arg1 = Debat.getArgumentFromName(a1);
			    	arg2 = Debat.getArgumentFromName(a2);
			    	
			    	if (!arg1.equals(null) && !arg2.equals(null)) {
			    		Contradiction.ajouterContradiction(arg1, arg2);
			    		arg2.setArgContredit(true); // Indique à l'argument qu'il est contredit
			    	}
		
			    	
			    	// Fonction pour ajouter une contradiction
			    	goodChoice = true;
			    	break;
			    	
			    case 2: 
			    	System.out.println("Choix 2");
			    	goodChoice = true;
			    	finPartie1 = true;
			    	break;
			    	
			    default :
			    	System.out.println("Le choix que vous avez indiqué n'existe pas");
			    	break;
			    }	
		    }
	    }
	}
	
	/**
	* La methode qui affiche le deuxieme menu.
	* @param args Unused.
	* @return Nothing.
	*/
	
	public static void menu2() {
		System.out.println("Choisissez votre option : ");
		System.out.println("1. ajouter un argument");
		System.out.println("2. retirer un argument");
		System.out.println("3. vérifier la solution");
		System.out.println("4. fin");
	}
	
	/**
	* La methode qui gere l'acces aux differentes actions possibles a partir du 2eme menu.
	* @param args Unused.
	* @return Nothing.
	*/
	
	public static void options2() {
		boolean goodChoice = false;
		boolean finPartie2 = false;
		Solution E = new Solution();
	    Scanner sc = new Scanner(System.in);
	    
		while (!goodChoice) {
	    while(!finPartie2) {
	    	menu2();
	    	int nbChoix = sc.nextInt();
	    	
	    switch(nbChoix) {
	    
	    case 1 : 
	    	System.out.println("Sélectionnez le nom de l'argument que vous voulez ajouter à la solution");
	    	String a1 = sc.next();
	    	E.ajouterArgument(a1);
	    	System.out.println("Taille : "+E.Solution.size());
	    	goodChoice = true;
	    	break;
	    	
	    case 2 : 
	    	System.out.println("Sélectionnez le nom de l'argument que vous voulez retirer de la solution");
	    	String a2 = sc.next();
	    	E.retirerArgument(a2);	    	
	    	System.out.println("Taille : "+E.Solution.size());	    	
	    	goodChoice = true;
	    	break;
	    	
	    case 3 : 
	    	System.out.println("Vérification de la solution");
	    	if(E.solutionAdmissible()) {
	    		System.out.println("La solution est admissible");
	    	} else {
	    		System.out.println("La solution n'est pas admissible");
	    		System.out.println("Un argument contredit votre solution");
	    	}
	    	goodChoice = true;
	    	break;
	    	
	    case 4: 
	    	goodChoice = true;
	    	finPartie2 = true;
	    	System.out.println(E.toString());
	    	System.exit(0);
	    	break;
	    default :
	    	System.out.println("Le choix que vous avez indiqué n'existe pas");
	    	break;
	    }	
	    }
	    }
		sc.close();
	}
	
	
}
