package tp1rmi.commons;


import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

@SuppressWarnings("serial")
public class Species extends UnicastRemoteObject{
	
	protected String speciesName;
	protected int speciesAverageLifeSpan;

	public Species(String especeNom, int esperanceVieEspece) throws RemoteException {
		this.speciesName = especeNom;
		this.speciesAverageLifeSpan = esperanceVieEspece;
	}
	

	public Species() throws RemoteException {
		this.speciesName = "unknown";
		this.speciesAverageLifeSpan = 0;
	}


	public String getSpeciesName() {
		return speciesName;
	}
	
	public int getSpeciesAverageLifeSpan() {
		return speciesAverageLifeSpan;
	}

}
