package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CabinetVeterinaire extends Remote{
	
	
	public boolean animalExists(String nom) throws RemoteException;
	public Animal searchAnimal(String nom) throws RemoteException;
	public int size() throws RemoteException;
	
	public void addAnimal(Animal animal) throws RemoteException; 
	void addAnimal(String name, String ownerName, String espece, String race, String suivi) throws RemoteException;
	void addAnimal(String name, String ownerName, Espece espece, String race, String suivi) throws RemoteException;
} 
