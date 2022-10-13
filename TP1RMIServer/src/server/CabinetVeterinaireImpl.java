package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import commons.Animal;
import commons.CabinetVeterinaire;
import commons.Espece;
import commons.SuiviAnimal;

public class CabinetVeterinaireImpl extends UnicastRemoteObject implements CabinetVeterinaire {
	
	private static final long serialVersionUID = 1L;
	
	private ArrayList<Animal> cabinet = new ArrayList<>();
	private int size = 0;
	
	
	public CabinetVeterinaireImpl() throws RemoteException {
   // TODO document why this constructor is empty
 }
	
	@Override
	public void addAnimal(Animal animal) throws RemoteException {
		if(!this.animalExists(animal.getnom())) {
		cabinet.add(animal);
	}
	}
	
	@Override
	public Object getCabinet() throws RemoteException{
		return this;
	}
	@Override
	public void addAnimal(String name, String ownerName, String species, String race, String state) throws RemoteException  {
		
		Animal animal = new AnimalImpl(name, ownerName, species, race, state);
		if(!this.animalExists(name)) {
		size++;
		cabinet.add(animal);
		}
	}
	
	@Override
	public void addAnimal(String name, String ownerName, Espece species, String race, String state) throws RemoteException  {
		
		Animal animal = new AnimalImpl(name, ownerName, species, race, state);
		if(!this.animalExists(name)) {
			size++;
			cabinet.add(animal);
		}
	}

	@Override
	public boolean animalExists(String nom) throws RemoteException  {
			for (Animal animal : cabinet) {
				if(animal.getnom().equals(nom)) {
					return true;
				}
			}
		return false;
	}


	@Override
	public int size() throws RemoteException {
		return size;
	}


	

	@Override
	public Animal searchAnimal(String nom) throws RemoteException {
		for (Animal animal : cabinet) {
			if(animal.getnom().equals(nom)) {
				return animal;
			}
		}
	return null;
	}

	@Override
	public ArrayList<Animal> getVeterinaire() throws RemoteException{
		return cabinet;
	}
	
	@Override
	public void removeAnimal(String name, String ownerName) throws RemoteException {
		ArrayList<Animal> newcabinet = new ArrayList<>();
		for (Animal animal : cabinet) {
			if(!(animal.getnom().equals(name) && animal.getMaitre().equals(ownerName)) ) {
				newcabinet.add(animal);
			}	
		}
		size--;
		cabinet = newcabinet;
		
	}
	
}
