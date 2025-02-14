package pizzaInnodbConnect;

public class Client {
	
	Integer NROCLIE;
	String  NOMCLIE;
	String  PRENOMCLIE;
	String  ADRESSECLIE;
	String  VILLECLIE;
	String  CODEPOSTALCLIE;
	String  TITRECLIE;
	String  NROTELCLIE;
	
	
	
	public Client(Integer nROCLIE, String nOMCLIE, String pRENOMCLIE, String aDRESSCLIE, String vILLECLIE,
			String cODEPOSTALCLIE, String tITRECLIE, String nROTELCLIE) {
		super();
		NROCLIE = nROCLIE;
		NOMCLIE = nOMCLIE;
		PRENOMCLIE = pRENOMCLIE;
		ADRESSECLIE = aDRESSCLIE;
		VILLECLIE = vILLECLIE;
		CODEPOSTALCLIE = cODEPOSTALCLIE;
		TITRECLIE = tITRECLIE;
		NROTELCLIE = nROTELCLIE;
	}

	

	@Override
	public String toString() {
		return "Client [NROCLIE=" + NROCLIE + ", NOMCLIE=" + NOMCLIE + ", PRENOMCLIE=" + PRENOMCLIE + ", ADRESSCLIE="
				+ ADRESSECLIE + ", VILLECLIE=" + VILLECLIE + ", CODEPOSTALCLIE=" + CODEPOSTALCLIE + ", TITRECLIE="
				+ TITRECLIE + ", NROTELCLIE=" + NROTELCLIE + "]";
	}
	
	 
	

}
