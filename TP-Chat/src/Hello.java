public interface Hello extends java.rmi.Remote {
	
	public void sayHello() throws java.rmi.RemoteException;
	
	public void connect(HelloClient client) throws java.rmi.RemoteException;
	public void send(String msg) throws java.rmi.RemoteException;
	public void bye(HelloClient client) throws java.rmi.RemoteException;
	public void who() throws java.rmi.RemoteException;
}
