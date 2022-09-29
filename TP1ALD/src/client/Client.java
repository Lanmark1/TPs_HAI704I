package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Animal;
import common.CabinetVeterinaire;
import common.SuiviAnimal;

public class Client {
	private Client() {
		
	}
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			
			Animal animal = (Animal) registry.lookup("Animal");
			CabinetVeterinaire cabinet = (CabinetVeterinaire) registry.lookup("Cabinet");
			cabinet.addAnimal(animal);
			String nom = animal.getnom();
			System.out.println(cabinet.size());
			System.out.println("NomAnimal: " + nom);
			
			String nomsuivi = animal.getSuiviAn();
			System.out.println("Espece : " + animal.getNomEspece());
			System.out.println("NomSuivi: " + nomsuivi);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
