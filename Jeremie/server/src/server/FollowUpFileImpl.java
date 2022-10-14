package server;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import commons.FollowUpFile;

public class FollowUpFileImpl extends UnicastRemoteObject implements FollowUpFile{
	String fileReport;
	public FollowUpFileImpl() throws RemoteException{
		fileReport="";
	}
	
	public FollowUpFileImpl(String fileReport) throws RemoteException{
		this.fileReport=fileReport;
	}

	public String getFileReport() throws RemoteException {
		return fileReport;
	}
	
	public void modifyFileReport(String file) throws RemoteException {
		this.fileReport = file;
	}
}
