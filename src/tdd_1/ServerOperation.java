package tdd_1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

import tdd_1.RMIInterface;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

	private static final long serialVersionUID = 4865876081371032203L;
	private static final String mServerName = "TestServer";

	protected ServerOperation() throws RemoteException {
		super();
	}

	@Override
	public String helloTo(String name) throws RemoteException {
		if (name.equals("quit")) {
			this.shutdown();
			return "Confirmed, " + mServerName + " is shutting down.";
		}
		System.err.println(name + " is trying to make contact!");
		return "Server says hi to " + name;
	}
	
	public static void main(String[] args) {
		try {
			Naming.rebind("//localhost/" + mServerName, new ServerOperation());
			System.err.println("The server \"" + mServerName + "\" is ready!");
		} catch (Exception e) {
			System.err.println("server exception: " + e.toString());
			e.printStackTrace();
		}
	}
	
	public void shutdown() throws RemoteException {
		try{
	        Naming.unbind(mServerName);
	        UnicastRemoteObject.unexportObject(this, true);

	        System.out.println(mServerName + " is shutting down.");
	    }
	    catch(Exception e){}
	}

}
