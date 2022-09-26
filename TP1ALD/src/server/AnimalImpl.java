package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import common.Animal;
import common.SuiviAnimal;

public class AnimalImpl extends UnicastRemoteObject implements Animal{
		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nom;
	public String nomMaitre;
	public String espece;
	public String race ;
	public SuiviAnimal suivi = new SuiviAnimalImpl("");

	
	public AnimalImpl()  throws RemoteException {
	}
	
	public AnimalImpl(String nomA, String nomMaitreA, String especeA, String raceA, SuiviAnimal sa)  throws RemoteException {
			nom = nomA;
			nomMaitre= nomMaitreA;
			espece = especeA;
			race = raceA;
			suivi = sa;
	}
		
		

		@Override
		public String getnom() throws RemoteException {
			return nom;
		}
		
		@Override
		public String getSuiviAn() throws RemoteException {
			return suivi.getSuivi();
		}
		
		

		@Override
		public void affichernomComplet() throws RemoteException {
			
		}

}