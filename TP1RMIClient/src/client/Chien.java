package client;

import java.rmi.RemoteException;
import commons.Espece;

public class Chien extends Espece{

	private static final long serialVersionUID = 1L;
	private String espece = "Chien";
	
	public Chien() throws RemoteException {
   // TODO document why this constructor is empty
	}
	
	@Override
	public String getNomEspece() {
		return espece;
	}

	
}
