package server;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.SuiviAnimal;

public class Server {
	public Server() {
	}
	
	public static void main(String[] args) throws AlreadyBoundException {
		
		System.setProperty("java.security.policy", "src/server/security.policy");
		if (System.getSecurityManager() == null) {
		    System.setSecurityManager(new SecurityManager());
		  }
		
		try {
			SuiviAnimal suivi = new SuiviAnimalImpl("12345");
			AnimalImpl animal = new AnimalImpl("medor","dupont","chien","labrador",suivi);
			Registry registry = LocateRegistry.createRegistry(1099);
			
			if (registry == null)
				System.err.println("Registry not found on port 1099");
			else {
				registry.rebind("Animal", animal);
				System.err.println("Server ready");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

