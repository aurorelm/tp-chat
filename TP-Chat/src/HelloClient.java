import java.rmi.*;
public class HelloClient {
public static void main(String args[]) {
	try {
		// Récupération d'un stub sur l'objet serveur.
		//Hello obj = (Hello) Naming.lookup("//ma_machine/mon_serveur");
		Hello obj = (Hello) Naming.lookup("//127.0.0.1:8080/chat_serveur");		
		// Appel d'une méthode sur l'objet distant.
		obj.sayHello();
		} 
	
	catch (Exception exc) { 
		System .out . println ("Erreur dans HelloClient");
		return ; 
		}
	}
}