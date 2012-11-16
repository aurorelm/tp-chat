import java.rmi.*;
public class HelloClient {
	protected int id;
	protected String nom;
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id=id;
	}	
	
	public String getNom(){
		return this.nom;
	}
	
	public void setNom(String nom){
		this.nom=nom;
	}
	
	
public static void main(String args[]) {
	try {
		// Récupération d'un stub sur l'objet serveur.
		//Hello obj = (Hello) Naming.lookup("//ma_machine/mon_serveur");
		Hello obj = (Hello) Naming.lookup("//127.0.0.1:8080/chat_serveur");		
		// Appel d'une méthode sur l'objet distant.
		obj.sayHello();
		} 
	
	catch (Exception exc) { 
		System .out . println ("La connexion a echouee");
		return ; 
		}
	}
}