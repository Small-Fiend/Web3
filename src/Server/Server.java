package Server;

import Core.Branch;

import java.rmi.Remote;
import java.rmi.RemoteException;


public interface Server extends Remote {
    public Branch transformFunction(Branch array) throws RemoteException;
}
