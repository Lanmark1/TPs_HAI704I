package server;


import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Animal;
import common.CabinetVeterinaire;
import common.SuiviAnimal;

public class Server {
	public Server() {
	}

	public static void main(String[] args) throws AlreadyBoundException {
		
		System.setProperty("java.security.policy", "src/server/security.policy");
		
		
		try {
			Registry registry = LocateRegistry.createRegistry(1099);
			SuiviAnimal suivi = new SuiviAnimalImpl("12345");
			Espece especeAnimal = new Espece("Labrador");
			Animal animal = new AnimalImpl("medor","dupont",especeAnimal,"Race1",suivi);
			
			CabinetVeterinaire cabinet = new CabinetVeterinaireImpl();
			
			if (registry == null)
				System.err.println("Registry not found on port 1099");
			else {
				registry.rebind("Cabinet", cabinet);
				registry.rebind("Animal", animal);
				System.err.println("Server ready");
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}
}

