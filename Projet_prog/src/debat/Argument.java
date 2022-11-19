package debat;

public class Argument {
	
	private static int numArg = 1;
	private String nomArg = "A";
	private boolean argContredit=false;

	public Argument() {
	    nomArg += numArg;
	    numArg++;
	}

	// ******************************
	// Public methods
	// ******************************
	
	public static int getNumArg() {
		return numArg;
	}

	public static void setNumArg(int numArg) {
		Argument.numArg = numArg;
	}

	public String getNomArg() {
		return nomArg;
	}

	public void setNomArg(String nomArg) {
		this.nomArg = nomArg;
	}

	public boolean isArgContredit() {
		return argContredit;
	}

	public void setArgContredit(boolean argContredit) {
		this.argContredit = argContredit;
	}

}
