package tdd_1;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface RMIInterface extends Remote {

	public abstract String helloTo(String name) throws RemoteException;

}
