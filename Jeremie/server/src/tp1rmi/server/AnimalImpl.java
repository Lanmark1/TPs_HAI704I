package tp1rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tp1rmi.commons.Animal;
import tp1rmi.commons.FollowUpFile;
import tp1rmi.commons.Species;



public class AnimalImpl extends UnicastRemoteObject implements Animal {
	
	
	public AnimalImpl() throws RemoteException{
		nom="";
		nomMaitre="";
		espece= new Species();
		race="";
		file=new FollowUpFileImpl();
	}
	
	public AnimalImpl(String nom, String race, String nomEspece, int esperanceVieEspece, String nomMaitre, String fileContent) throws RemoteException{
		this.nom=nom;
		this.nomMaitre=nomMaitre;
		this.espece=new Species(nomEspece, esperanceVieEspece);
		this.race=race;
		this.file=new FollowUpFileImpl(fileContent);
	}
	
	public AnimalImpl(String nom, String race, Species espece, String nomMaitre, String fileContent) throws RemoteException{
		this.nom=nom;
		this.nomMaitre=nomMaitre;
		this.espece=espece;
		this.race=race;
		this.file= new FollowUpFileImpl(fileContent);
	}
	
	public AnimalImpl(String nom, String race, Species espece, String nomMaitre, FollowUpFile fileContent) throws RemoteException{
		this.nom=nom;
		this.nomMaitre=nomMaitre;
		this.espece=espece;
		this.race=race;
		this.file= (FollowUpFileImpl) fileContent;
	}
	
	// attributs
	protected String nom;
	protected String nomMaitre;
	protected Species espece;
	protected String race;
	protected FollowUpFileImpl file;
	
	
	// méthodes
	
	public String getName() throws RemoteException{
		return this.nom;
	}
	
	public String getFullName() throws RemoteException {
		return "name: "+nom+", species name: "+espece.getSpeciesName()+", average lifespan: "+Integer.toString(espece.getSpeciesAverageLifeSpan())+", race: "+race+", owned by: "+nomMaitre;
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
	
	public Species getSpecies() throws RemoteException{
		return espece;
	}
	
	public String getSpeciesName() throws RemoteException {
		return espece.getSpeciesName();
	}
	
	public void printSpeciesName() throws RemoteException {
		System.out.println(espece.getSpeciesName());
	}
}
