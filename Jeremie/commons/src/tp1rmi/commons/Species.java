package tp1rmi.commons;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Species extends UnicastRemoteObject implements Serializable {
	
	private String speciesName;

	public Species() throws RemoteException {
		super();
	}
	
	public Species(String speciesName) throws RemoteException {
		super();
		this.speciesName = speciesName;
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
