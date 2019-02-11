package tamagotchi;

import java.util.Scanner;

public class Tamagotchi {

	static Scanner scan = new Scanner(System.in);
	// Valeure comprise de -5 a 5 //

	private int faim;
	private int poid;
	private int propre;
	private int bonheur;
	private int muscle;
	private int fatigue;
	private String sex;
	private String nom;



	/////GET & SET//////

	public int getFaim() {
		return faim;
	}
	public void setFaim(int faim) {
		this.faim = faim;
	}
	public int getPoid() {
		return poid;
	}
	public void setPoid(int poid) {
		this.poid = poid;
	}
	public int getPropre() {
		return propre;
	}
	public void setPropre(int propre) {
		this.propre = propre;
	}
	public int getBonheur() {
		return bonheur;
	}
	public void setBonheur(int bonheur) {
		this.bonheur = bonheur;
	}
	public int getMuscle() {
		return muscle;
	}
	public void setMuscle(int muscle) {
		this.muscle = muscle;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getFatigue() {
		return fatigue;
	}
	public void setFatigue(int fatigue) {
		this.fatigue = fatigue;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}

	//////END//////
	
	//ECLOSION//
	public String eclosion() {

		String user = "";		
		nom = scan.nextLine();		
		setNom(nom);
		user = "Votre tamagotchi sort de ça coquille !!!" + "il s'appelle " + getNom();

		faim = 0;
		poid = 0;
		propre = 0;
		bonheur = 0;
		muscle = 0;
		return user;
	}
	//END//
	
	//CHOIX DU SEX//
	public void sex() {
		String choix;
		System.out.println("voulez vous choisir le sexe de votre tamagotchi ?");
		choix = scan.nextLine().toLowerCase();

		if (choix.equals("oui")) {

			System.out.println("Merci d'entrée votre choix (Male ou femelle ?");
			choix = scan.nextLine().toLowerCase();
			if(choix.equals("male")|| choix.equals("femelle"))

				setSex(choix);
			System.out.println("Votre tamagotchi est "+ getSex());
		}

		else  {
			System.out.println(choixAuto());
		}
	}
	public String choixAuto() {
		int random = (int)(Math.random()*2+1);
		String sex ="";
		switch(random) {
		case 1: setSex("male");
		break;
		case 2: setSex("femelle");
		break;

		}return sex;
	}
	//////END//////

	///LES ACTIVITE///
	public void manger() {
		faim ++;
		bonheur ++;
		propre --;
		poid ++;
	}
	public void dormir() {
		bonheur ++;
		faim --;
		poid ++;
		propre ++;

	}
	public void activiteSportive() {
		fatigue --;
		propre --;
		poid --;
		faim --;
	}
	public void douche() {
		propre ++;
		bonheur ++;
		fatigue --;

	}
	public void jeux() {
		bonheur += 2;
		fatigue -= 2;
		propre --;
		faim ++;
	}
	//////END//////

	///LES STATUS///
	public void statusFaim() {
		String status = "";
		switch (faim) {
		case -5:
			status = nom + "Votre tamagotchi est mort";
			break;
		case -3: case -4: 
			status = nom + "Votre tamagotchi agonise";
			break;
		case 0: case 1: 
			status = nom + "Votre Tamagotchi est rassasié !"
			break;
		case 2: case 3:
			
			break;
		}
	}
	public void statusPoid() {

	}	
	public void statusPropre() {

	}
	public void statusBonheur() {

	}
	public void statusMuscle() {

	}
	public void statusFatigue() {

	}
	//////END//////
	
	
	
	
	/**
	 * Essaie vue avec agnes
	 */

	@Override
	public String toString() {
		return "Tamagotchi [faim=" + faim + ", poid=" + poid + ", propre=" + propre + ", bonheur=" + bonheur
				+ ", muscle=" + muscle + ", fatigue=" + fatigue + ", sex=" + sex + ", nom=" + nom + "]";
	}


}
