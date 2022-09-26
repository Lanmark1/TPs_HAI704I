package tp1rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tp1rmi.commons.Animal;
import tp1rmi.commons.FollowUpFile;



public class AnimalImpl extends UnicastRemoteObject implements Animal {
	
	
	public AnimalImpl() throws RemoteException{
		nom="";
		nomMaitre="";
		espece="";
		race="";
		file=new FollowUpFileImpl();
	}
	
	public AnimalImpl(String nom, String race, String espece, String nomMaitre, String fileContent) throws RemoteException{
		this.nom=nom;
		this.nomMaitre=nomMaitre;
		this.espece=espece;
		this.race=race;
		file=new FollowUpFileImpl(fileContent);
	}
	
	// attributs
	protected String nom;
	protected String nomMaitre;
	protected String espece;
	protected String race;
	protected FollowUpFileImpl file;
	
	
	// méthodes
	
	public String getFullName() throws RemoteException {
		return "name: "+nom+", species: "+espece+", race: "+race+", owned by: "+nomMaitre;
	}
	
	
	public void printFullName() throws RemoteException {
		System.out.println(getFullName());
	}

	public Object getFile() throws RemoteException {
		return file;
	}
	
	public void printFile() throws RemoteException {
		System.out.println(file.getFileReport());
	}

//	public void setFile(FollowUpFileImpl file) {
//		this.file = file;
//	}

}
