package debat;

import java.util.ArrayList;

public class Solution {
	
	public static ArrayList<String> Solution;
	
	public Solution() {
		Solution = new ArrayList<String>();
	}
	
	
	// ******************************
	// Public methods
	// ******************************
	
	/**
	* La methode qui ajoute un argument a la solution.
	* @param nameArgument le nom de l'argument a ajouter a la solution
	* @return Nothing.
	*/
	
	public void ajouterArgument(String nameArgument) {
		boolean argTrouve=false;
		// Il faut aussi vérifier que l'argument existe
		for(String s : Solution) {
			if(s.equals(nameArgument)) {
			argTrouve = true;
			}
		}
		if(!argTrouve) {
			Solution.add(nameArgument);
		}
	}
	
	/**
	* La methode qui retire un argument de la solution.
	* @param nameArgument le nom de l'argument a retirer de la solution
	* @return Nothing.
	*/
	
	public void retirerArgument(String nameArgument) {
		Solution.remove(nameArgument);
	}
	
	/**
	* La methode qui verifie si toutes les conditions sont reunies pour que la solution soit admissible.
	* @return True si la solution est admissible.
	*/
	
	public boolean solutionAdmissible() {
		if(!checkSolutionContradictoire()) {
			if(checkSolutionValide()) {
				return true;
			} else {
				return false;
			  }
		} else {
			return false;
		  }
	}
	
	/**
	* La methode qui permet l'affichage de la solution.
	* @return un String avec la solution.
	*/
	
	public String toString() {
		String solution ="Solution : { ";
		for(int i =0; i<Solution.size(); i++) {
			solution += Solution.get(i)+", ";
		}
		solution += " }";
		return solution;
	}
	
	// ******************************
	// Private methods
	// ******************************
	
	/**
	* La methode qui verifie si 2 arguments presents dans la solution ne se contredisent pas.
	* @return True s'il y a 2 arguments qui se contredisent.
	*/

	private boolean checkSolutionContradictoire() {
		
		for(int i=0; i<Solution.size(); i++) { // Boucle sur l'argument que l'on veut vérifier

			for(int j=0; j<Solution.size(); j++) { //Boucle sur les autres arguments de la solution
				
				if(Contradiction.getContradiction(Solution.get(i), Solution.get(j))) {
					System.out.println("La solution n'est pas admissible : "+ Solution.get(i)+ " et "+ Solution.get(j)+ " créent une contradiction interne.");
					return true;
				}
			}
		}
		return false;
	}
	
	
	/**
	* La methode qui verifie si aucun argument de la solution n'est contredit ou au minimum qu'il soit defendu par un autre argument de la solution
	* @return True si la solution est valide.
	*/
	
	private boolean checkSolutionValide() {
		boolean solutionValide = true;
		
		while(solutionValide) {
			for(int i=0; i<Debat.getListeArguments().size(); i++) {
				if(!Solution.contains(Debat.getListeArguments().get(i).getNomArg())) {
					if(checkArgumentContreditSolution(Debat.getListeArguments().get(i).getNomArg())) {
						solutionValide = false;
					} 
				}
			} 
			break;
		}
		return solutionValide;
	}
	
	/**
	* La methode qui verifie si la solution contredit un argument.
	* @param name le nom de l'argument pour lequel on veut verifier s'il est contredit par un argument de la solution
	* @return True si un element de la solution contredit l'argument donne en parametre.
	*/
	
	// True signifie que c'est bon notre élément de la solution est défendu par un autre élément de la solution
	private boolean checkSolutionContreditElementArgument(String name) { // Vérifie si un élément de la solution contredit l'argument contre lequel on se défend
		boolean SolutionDefendue = false;;
		for(int i=0; i<Solution.size(); i++) {
			if(Contradiction.getContradiction(Solution.get(i),name)) {
				SolutionDefendue = true;
			} 
		}
		return SolutionDefendue;
	}
	
	/**
	* La methode qui verifie si un argument en-dehors solution contredit un argument de la solution.
	* @param name le nom de l'argument pour lequel on veut verifier s'il contredit un argument de la solution
	* @return True si l'argument contredit un argument de la solution.
	*/
	
	private boolean checkArgumentContreditSolution(String name) {
		boolean ArgumentContredit = false;
		for(int i=0; i<Solution.size(); i++) {
			if(!Contradiction.getContradiction(name, Solution.get(i))) {
				ArgumentContredit = false;
			} else if(checkSolutionContreditElementArgument(name)){
				ArgumentContredit = false;
			} else ArgumentContredit = true;
			}
		return ArgumentContredit;
	}

}
