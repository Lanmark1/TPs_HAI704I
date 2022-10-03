package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import commons.Espece;

public class EspeceImpl extends UnicastRemoteObject implements Espece {

	private String espece; 
	
	public EspeceImpl(String espece) throws RemoteException{
		this.espece = espece;
	}
	
	@Override
	public String getNomEspece() throws RemoteException {
		return espece;
	}

}
