package client;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import commons.Animal;
import commons.Espece;

public class Chien extends Espece{

	private String espece = "Chien";
	
	public Chien() throws RemoteException {
   // TODO document why this constructor is empty
 }
	
	@Override
	public String getNomEspece() {
		return espece;
	}

	
}
