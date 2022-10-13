package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CabinetVeterinaire extends Remote{
	
	public void addAnimal(String nom, String race, String nomEspece, int esperanceVieEspece, String nomMaitre, String fileContent) throws RemoteException; 
	public void addAnimal(String nom, String race, Species espece, String nomMaitre, String fileContent) throws RemoteException; 
	public void addAnimal(String nom, String race, Species espece, String nomMaitre, FollowUpFile fileContent) throws RemoteException; 
	public Animal searchAnimal(String nom) throws RemoteException;
}
