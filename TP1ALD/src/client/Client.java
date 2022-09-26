package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import common.Animal;
import common.SuiviAnimal;

public class Client {
	private Client() {
		
	}
	
	public static void main(String[] args) {
		try {
			Registry registry = LocateRegistry.getRegistry();
			Animal animal = (Animal) registry.lookup("Animal");
			String nom = animal.getnom();
			System.out.println("NomAnimal: " + nom);
			String nomsuivi = animal.getSuiviAn();
			System.out.println("NomSuivi: " + nomsuivi);
		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
}
