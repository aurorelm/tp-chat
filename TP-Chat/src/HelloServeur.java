import java.lang.reflect.Array;
import java.net.InetAddress;
import java.rmi.*;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class HelloServeur extends UnicastRemoteObject implements Hello {
	String message;
	ArrayList<HelloClient> clients;
	
	
	// Implémentation du constructeur
	public HelloServeur(String msg) throws java.rmi.RemoteException {
		message = msg;
	}

	// Implémentation de la méthode distante
	public void sayHello() throws java.rmi.RemoteException {
		System.out.println(message);
	}

	
	
	
	public void connect(HelloClient client) throws java.rmi.RemoteException{
		if(clients.contains(client)){
			System.out.println("Le client est deja connecte");
			RemoteException erreur = new RemoteException("Le client ne peut pas etre ajoute");
			throw erreur;
		}
		else{
			clients.add(client);
		}
	}
		
	
	public void send(String msg) throws java.rmi.RemoteException{
	}
	
	public void bye(HelloClient client) throws java.rmi.RemoteException{
		if(!clients.contains(client)){
			System.out.println("Le client n'est pas connecte");
			RemoteException erreur = new RemoteException("Le client ne peut pas etre supprime");
			throw erreur;
		}
		else{
			clients.remove(client);
		}
	}
	
	
	public void who() throws java.rmi.RemoteException{
		
	}
	
	
	
	
	public static void main(String args[]) {
		int port; 
		String URL;
		
		try { 
			// transformation d ’une chaîne de caractères en entier
			Integer I = new Integer(8080);
			port = I.intValue();
		} 
		catch (Exception ex) {
			System.out.println(" Please enter: Server <port>"); 
			return;
		}
		
		try {
			// Création du serveur de nom - rmiregistry
			Registry registry = LocateRegistry.createRegistry(port);

			// Création d ’une instance de l’objet serveur
			Hello obj = new HelloServeur("Coucou !");
			
			// Calcul de l’URL du serveur
			URL = "//"+InetAddress.getLocalHost().getHostName()+":"+port+"/chat_serveur";
			Naming.rebind(URL, obj);
		} 
		
		catch (Exception exc) { 
			System .out . println ("Erreur dans da creation et l initialisation de l URL");
			return ; 
		}
	}
}