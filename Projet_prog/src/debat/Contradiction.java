package debat;

import java.util.ArrayList;
import java.util.HashMap;

public class Contradiction {
	
	private static HashMap<String, ArrayList<Argument>> mapContradictions = new HashMap<String, ArrayList<Argument>>(); // HashMap avec comme clé l'argument et on met tous les arguments que celui de la clé contredit

	// ******************************
	// Public methods
	// ******************************
	
	/**
	* La methode qui cree une contradiction entre 2 arguments.
	* @param a1 le premier argument.
	* @param a2 le deuxieme argument.
	* @return Nothing.
	*/
	
	public static void ajouterContradiction(Argument a1, Argument a2) {
		
		if(!mapContradictions.containsKey(a1.getNomArg())) {
			ArrayList<Argument> listeArgumentsContredits = new ArrayList<Argument>();
			mapContradictions.put(a1.getNomArg(), listeArgumentsContredits);
			mapContradictions.get(a1.getNomArg()).add(a2);
		}
		else {
			if(!mapContradictions.get(a1.getNomArg()).contains(a2)) {
				System.out.println("a2 ne contient pas a1");
				mapContradictions.get(a1.getNomArg()).add(a2);
			}
		}
	}

	
	public static HashMap<String, ArrayList<Argument>> getMapContradictions() {
		return mapContradictions;
	}


	public static void setMapContradictions(HashMap<String, ArrayList<Argument>> mapContradictions) {
		Contradiction.mapContradictions = mapContradictions;
	}
	
	/**
	* La methode qui verifie si le 1er argument contredit le deuxieme.
	* @param a1 le nom du premier argument.
	* @param a2 le nom du deuxieme argument.
	* @return True si a1 contredit a2.
	*/
	
	// On donne 2 arguments et la méthode renvoie si l'un est 
	public static boolean getContradiction(String a1, String a2) {
		Argument a = Debat.getArgumentFromName(a2);
		if(!mapContradictions.containsKey(a1)) {
			return false;
		}
		else if(mapContradictions.get(a1).contains(a)) {
			return true;
		}else
			return false;
	}
	
}
