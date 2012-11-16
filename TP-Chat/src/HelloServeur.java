import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class HelloServeur extends UnicastRemoteObject implements Hello {
	String message;
	
	// Impl�mentation du constructeur
	public HelloServeur(String msg) throws java.rmi.RemoteException {
		message = msg;
	}

	// Impl�mentation de la m�thode distante
	public void sayHello() throws java.rmi.RemoteException {
		System.out.println(message);
	}

	
	
	
	public void connect(String id) throws java.rmi.RemoteException{
	}
	
	public void send(String msg) throws java.rmi.RemoteException{
	}
	
	public void bye() throws java.rmi.RemoteException{
		
	}
	public void who() throws java.rmi.RemoteException{
		
	}
	
	
	
	
	public static void main(String args[]) {
		int port; 
		String URL;
		
		try { 
			// transformation d �une cha�ne de caract�res en entier
			Integer I = new Integer(8080);
			port = I.intValue();
		} 
		catch (Exception ex) {
			System.out.println(" Please enter: Server <port>"); 
			return;
		}
		
		try {
			// Cr�ation du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);

			// Cr�ation d �une instance de l�objet serveur
			Hello obj = new HelloServeur("Coucou !");
			
			// Calcul de l�URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/chat_serveur";
			Naming.rebind(URL, obj);
		} 
		
		catch (Exception exc) { 
			System .out . println ("Erreur dans da creation et l initialisation de l URL");
			return ; 
		}
	}
}