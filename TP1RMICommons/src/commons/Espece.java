package commons;

import java.io.Serializable;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Espece implements Serializable {
	
	private static final long serialVersionUID = 1L;
	private String espece; 
	
	public Espece() throws RemoteException {
		super();
	}
	
	public Espece(String espece) throws RemoteException{
		this.espece = espece;
	}

	public String getNomEspece() {
		return espece;
	}
}

