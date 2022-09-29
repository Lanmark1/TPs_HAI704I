package common;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CabinetVeterinaire extends Remote{
	public void addAnimal(Animal animal) throws RemoteException; 
	public Animal searchAnimal(String nom) throws RemoteException;
	public int size() throws RemoteException;
}
