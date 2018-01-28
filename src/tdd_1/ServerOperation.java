package tdd_1;

import java.rmi.Naming;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerOperation extends UnicastRemoteObject implements RMIInterface {

	private static final long serialVersionUID = 4865876081371032203L;

	protected ServerOperation() throws RemoteException {
		super();
	}

	@Override
	public String helloTo(String name) throws RemoteException {
		System.err.println(name + " is trying to make contact!");
		return "Server says hi to " + name;
	}
	
	public static void main(String[] args) {
		try {
			Naming.rebind("//localhost/TestServer", new ServerOperation());
			System.err.println("Server ready");
		} catch (Exception e) {
			System.err.println("server exception: " + e.toString());
			e.printStackTrace();
		}
	}

}
