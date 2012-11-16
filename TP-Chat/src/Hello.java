public interface Hello extends java.rmi.Remote {
	
	public void sayHello() throws java.rmi.RemoteException;
	
	public void connect(String id) throws java.rmi.RemoteException;
	public void send(String msg) throws java.rmi.RemoteException;
	public void bye() throws java.rmi.RemoteException;
	public void who() throws java.rmi.RemoteException;
	
}
