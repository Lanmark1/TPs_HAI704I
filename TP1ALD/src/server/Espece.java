package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Espece extends UnicastRemoteObject {
	
	private static final long serialVersionUID = 1L;
	private String nomEspece;

	protected Espece() throws RemoteException {
		super();
		// TODO Auto-generated constructor stub
	}
	
	protected Espece(String nomE) throws RemoteException {
		super();
		this.nomEspece = nomE;
	}

	public String getNomEspece() {
		return nomEspece;
	}

}
