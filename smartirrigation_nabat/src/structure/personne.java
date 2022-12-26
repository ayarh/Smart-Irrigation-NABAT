package structure;

import base.base;

public class personne {
	private String nom,prenom;
	private static int ID=1;
	public personne() {
		super();
		this.nom = " ";
		this.prenom = " ";
		ID++;
	}
	
	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public personne(String nom, String prenom) {
		super();
		this.nom = nom;
		this.prenom = prenom;
		ID ++;;
	}
	public personne(personne A) {
		super();
		this.nom = A.nom;
		this.prenom = A.prenom;
		
	}
	@Override
	public String toString() {
		return "personne [nom=" + nom + ", prenom=" + prenom + "]";
	}
	public void Afficher()
	{
		System.out.println(toString());
	}
	
}

class client extends personne{
	private String login,password,email;
	private int ID;
	private personne p1;
	public client (String nom,String prenom,String login,String password,String email)
	{
		super(nom,prenom);
		//this.nom =nom;
		//this.prenom=prenom;
		this.email=email;
		this.password=password;
		this.login=login;
		
	}
	public void afficherClient()
	{
		super.Afficher();
		System.out.println(" l'email est "+email+" "+" password est "+password+" "+" le login est "+login);
		
	}
	public void affichercaracteristiques() {
		base b1 = new base();
		b1.UpdateJtableSensors(null);
	}
	
}
class administrateur extends personne{
	private String ad_password,ad_login;
	public administrateur(String nom,String prenom,String ad_login,String ad_password)
	{
		super(nom,prenom);
		this.ad_password=ad_password;
		this.ad_login=ad_login;
		
		
	}
	
	public void afficherAdministrateur()
	{
		super.Afficher();
		System.out.println(" password est "+ad_password+" "+" le login est "+ad_login);
		
	}
	
}



