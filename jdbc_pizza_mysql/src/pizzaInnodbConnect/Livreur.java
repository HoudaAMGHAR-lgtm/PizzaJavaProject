package pizzaInnodbConnect;

import java.sql.Date;

public class Livreur {
	
	Integer NROLIVR;
	String  NOMLIVR;
	String  PRENOMLIVR;
	Date  DATEEMBAUCHLIVR;
	public Livreur(Integer nROLIVR, String nOMLIVR, String pRENOMLIVR, Date dATEEMBAUCHLIVR) {
		super();
		NROLIVR = nROLIVR;
		NOMLIVR = nOMLIVR;
		PRENOMLIVR = pRENOMLIVR;
		DATEEMBAUCHLIVR = dATEEMBAUCHLIVR;
	}
	@Override
	public String toString() {
		return "Livreur [NROLIVR=" + NROLIVR + ", NOMLIVR=" + NOMLIVR + ", PRENOMLIVR=" + PRENOMLIVR
				+ ", DATEEMBAUCHLIVR=" + DATEEMBAUCHLIVR + ", getClass()=" + getClass() + ", hashCode()=" + hashCode()
				+ ", toString()=" + super.toString() + "]";
	}
	
	
	
	
	
	

	 
	

}