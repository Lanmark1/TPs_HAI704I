package client;

import java.rmi.RemoteException;

import commons.Animal;
import commons.Espece;

public class Chien implements Espece {

	private String espece = "Chien";
	
	public Chien() throws RemoteException {
		this.espece = espece;
	}
	
	@Override
	public String getNomEspece() throws RemoteException {
		return espece;
	}

	
}
