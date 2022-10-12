package commons;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote{
	
	
	String getnom() throws RemoteException;
	String getSuivi() throws RemoteException;
	String getNomEspece() throws RemoteException;
	String getMaitre() throws RemoteException;
	void affichernomComplet() throws RemoteException;
	Animal getAnimal() throws RemoteException;
	
	
	
	
}
