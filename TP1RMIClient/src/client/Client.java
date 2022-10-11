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
					
		    cabinet.addAnimal("Fox", "Yoann", "Chat", "Labrador", "Bonne santé");
			
		    Espece espece = new Chien();
			
			cabinet.addAnimal("Matthieu", "Yoann", espece, "Labrador", "Bonne santé");
			
			Animal fox = cabinet.searchAnimal("Fox");
//			Animal matthieu = cabinet.searchAnimal("Matthieu");
			System.out.println(fox.getNomEspece());
//			System.out.println(matthieu.getEspece().getNomEspece());
			
			
			System.out.println(cabinet.size());

			System.out.println("Animal : " + cabinet.animalExists("Fox"));
			
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
