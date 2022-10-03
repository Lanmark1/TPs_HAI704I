package tp1rmi.commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CabinetVeterinaire extends Remote{
	
	public void addAnimal(String nom, String race, String espece, String nomMaitre, String fileContent) throws RemoteException; 
	public Animal searchAnimal(String nom) throws RemoteException;
}
