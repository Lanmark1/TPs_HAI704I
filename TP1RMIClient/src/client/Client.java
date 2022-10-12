package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import commons.Animal;
import commons.CabinetVeterinaire;
import commons.Espece;

public class Client {
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
		    CabinetVeterinaire cabinet = (CabinetVeterinaire) registry.lookup("Cabinet");
		    Espece espece = new Chien();
		    cabinet.addAnimal("Fox", "Yoann", "Chat", "Labrador", "Bonne santé");
			cabinet.addAnimal("Matthieu", "Yoann", espece, "Labrador", "Bonne santé");
			
			// On suppose le cabinet déjà créer
			// On demande d'ajouter un animal 
			System.out.println(cabinet.searchAnimal("Fox"));
			System.out.println(cabinet.searchAnimal("Matthieu"));
			System.out.println(cabinet.size());
			System.out.println(cabinet.searchAnimal("Matthieu").getNomEspece());

			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
