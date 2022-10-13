package server;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import commons.Animal;
import commons.CabinetVeterinaire;
import commons.FollowUpFile;
import commons.Species;


public class CabinetVeterinaireImpl extends UnicastRemoteObject implements CabinetVeterinaire {
	
	private List<Animal> cabinet;
	
	
	public CabinetVeterinaireImpl() throws RemoteException {
		cabinet = new ArrayList<>();
	}
	

	public void addAnimal(String nom, String race, String nomEspece, int esperanceVieEspece, String nomMaitre, String fileContent) throws RemoteException  {
		AnimalImpl animal = new AnimalImpl(nom, race, nomEspece, esperanceVieEspece, nomMaitre, fileContent);
		cabinet.add(animal);
	}
	
	@Override
	public void addAnimal(String nom, String race, Species espece, String nomMaitre, String fileContent)
			throws RemoteException {
		Species esp = espece;
		AnimalImpl animal = new AnimalImpl(nom, race, esp, nomMaitre, fileContent);
		cabinet.add(animal);
		
	}
	
	public void addAnimal(String nom, String race, Species espece, String nomMaitre, FollowUpFile fileContent) throws RemoteException  {
		AnimalImpl animal = new AnimalImpl(nom, race, espece, nomMaitre, fileContent);
		cabinet.add(animal);
	}

	public Animal searchAnimal(String nom) throws RemoteException  {
			int i = 0;
			while( i < cabinet.size() && !nom.equals(cabinet.get(i).getName())) {
				i++;
			}
			if (i == cabinet.size()) return null;
			else return cabinet.get(i);
	}



}
