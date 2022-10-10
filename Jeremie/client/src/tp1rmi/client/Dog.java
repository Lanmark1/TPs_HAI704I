package tp1rmi.client;

import java.io.Serializable;
import java.rmi.RemoteException;

import tp1rmi.commons.Species;

public class Dog extends Species implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	protected boolean barks;
	
	public Dog() throws RemoteException{
		this.speciesName = "chien";
		this.speciesAverageLifeSpan = 15;
	}
	
	public Dog(boolean barks) throws RemoteException{
		this.speciesName = "chien";
		this.speciesAverageLifeSpan = 15;
		this.barks = barks;
	}
	
	public void bark() {
		System.out.println("woof");
	}
	
	public boolean doesBarks() {
		return barks;
	}

	public void setBarks(boolean barks) {
		this.barks = barks;
	}

}
