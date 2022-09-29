package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

import common.Animal;
import common.CabinetVeterinaire;

public class CabinetVeterinaireImpl extends UnicastRemoteObject implements CabinetVeterinaire {
	
	private static final long serialVersionUID = 1L;
	
	private List<Animal> cabinet = new ArrayList<>();
	private int size = 0;
	
	
	public CabinetVeterinaireImpl() throws RemoteException {
	};
	

	@Override
	public void addAnimal(Animal animal) throws RemoteException  {
	
		this.cabinet.add(animal);
		this.size++;
	}

	@Override
	public Animal searchAnimal(String nom) throws RemoteException  {
			return null;
	}


	@Override
	public int size() throws RemoteException {
		return size;
	}
}
