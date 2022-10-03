package tp1rmi.server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import tp1rmi.commons.Animal;
import tp1rmi.commons.CabinetVeterinaire;


public class CabinetVeterinaireImpl extends UnicastRemoteObject implements CabinetVeterinaire {
	
	private List<Animal> cabinet;
	
	
	public CabinetVeterinaireImpl() throws RemoteException {
		cabinet = new ArrayList<>();
	}
	

	public void addAnimal(String nom, String race, String espece, String nomMaitre, String fileContent) throws RemoteException  {
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
