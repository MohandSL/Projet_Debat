package debat;

import java.util.ArrayList;


public class Debat {
	
	private static ArrayList<Argument> listeArguments = new ArrayList<Argument>();
	
	// ******************************
	// Public methods
	// ******************************

	/**
	* La methode qui s'occupe de creer les differents arguments du debat.
	* @param nombreArg le nombre d'arguments a creer pour ce debat.
	* @return Nothing.
	*/
	
	public static void createDebat(int nombreArg){
	    for(int i=0; i<nombreArg; i++){
	        Argument a = new Argument();
	        getListeArguments().add(a);
	    }
	}
	
	/**
	* La methode qui recupere la liste des arguments existant.
	* @return la liste de tous les arguments existant.
	*/

	public static ArrayList<Argument> getListeArguments() {
		return listeArguments;
	}
	
	/**
	* La methode qui s'occupe de chercher l'argument dans la liste a partir du nom de l'argument.
	* @param argumentName le nom de l'argument que l'on veut recuperer.
	* @return l'argument correspondant au nom donne en parametre.
	*/
	
	public static Argument getArgumentFromName(String argumentName) {
		Argument a = null;
		for (int i =0; i<Debat.getListeArguments().size(); i++) {
    		if(Debat.getListeArguments().get(i).getNomArg().equals(argumentName)){
    			 a = Debat.getListeArguments().get(i);
    		}
    	}
		return a;
	}
}
