package commons;

import java.io.Serializable;

public class Espece implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String espece;
	
	public Espece() {
		// TODO Auto-generated constructor stub
	}
	
	public Espece(String espece) {
		this.espece = espece;
	}
	
	public String getNomEspece() {
		return espece;
	}
}
