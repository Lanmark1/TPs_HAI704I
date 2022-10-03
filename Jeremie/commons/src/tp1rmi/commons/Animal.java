package tp1rmi.commons;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Animal extends Remote{

	String getName() throws RemoteException;
	String getFullName() throws RemoteException;
	Object getFile() throws RemoteException; // sera casté plus tard en FollowUpFile
	void printFullName() throws RemoteException;
	void printFile() throws RemoteException;
	
	Species getSpecies() throws RemoteException;
	String getSpeciesName() throws RemoteException;
	void printSpeciesName() throws RemoteException;
}