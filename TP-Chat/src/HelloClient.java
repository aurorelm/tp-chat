import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.rmi.*;
import java.util.StringTokenizer;
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


	String ligne;

	try{
	    StringTokenizer st; 
	    String requete=null;
	    String arg=null;
	 
		BufferedReader clavier = new BufferedReader( new InputStreamReader (System.in));
		ligne = clavier.readLine();
				
		while(ligne.length() > 0) {
			st = new StringTokenizer(ligne);
			requete = st.nextToken();
			if(st.hasMoreTokens())
				arg = st.nextToken();	
		}
	}
	
	
	
	
	catch (Exception exc) { 
		System .out . println ("KO !");
		return ; 
	}	
	}
}