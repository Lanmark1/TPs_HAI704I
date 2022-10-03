package tp1rmi.server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class Species extends UnicastRemoteObject implements Serializable {
	
	private String speciesName;

	protected Species() throws RemoteException {
		super();
	}
	
	protected Species(String speciesName) throws RemoteException {
		super();
		this.speciesName = speciesName;
	}

	public String getSpeciesName() {
		return speciesName;
	}

}
