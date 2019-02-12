package tamagotchi;

import java.util.Scanner;

public class Tamagotchi {

	static Scanner scan = new Scanner(System.in);

	//Valeur comprise de -5 a 5//
	//Sauf l'age ( 0 à 15)//
	//Mort est (O ou 1)//
	private int faim;
	private int poid;
	private int propre;
	private int bonheur;
	private int muscle;
	private int fatigue;
	private String sex;
	private String nom;
	private int age;
	private boolean vie = true;
	public String status;
	
	
	////END/////

	public String choix() {
		char user;
		String activity;
		System.out.println("Quel activité voulez vous que "+ nom +" fasse \n Manger ? \n Dormir ? \n sport ? \n laver ? \n Jouer ?");
		 user = scan.nextLine().toLowerCase().charAt(0);
		 switch(user) {
		 case 'm':activity = this.manger();
		 break;
		 case'd':activity =this.dormir();
		 break;
		 case 's': case 'a':activity = this.activiteSportive();
		 break;
		 case 'l':activity = this.douche();
		 break;
		 case 'j':activity = this.jeux();
		 break;
		 default: activity = error();
		 break;
			 
		 }return activity;
	}
	public String error() {
	 status ="error";
			 return status;
 }

	//ECLOSION//
	public String eclosion() {

		String user = "";		
		nom = scan.nextLine();		
		setNom(nom);
		user = "Votre tamagotchi sort de ça coquille !!!" + "il s'appelle " + getNom();

		//Init du status a 0//
		//Tout les status vont de -5 a 5 sauf l'age//
		faim = 0; 
		poid = 0;
		propre = 0;
		bonheur = 0;
		muscle = 0;
		fatigue = 0;
		age = 0;

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
	public String manger() {
		status = "Hmmm votre tamagotchi a bien manger";
		faim ++ ;
		bonheur ++;
		propre --;
		poid ++;
		return status;
	}
	public String dormir() {

		if(fatigue == -5) {
			status = "Votre tamagotchi s'éffondre totalement de fatigue";
		}else {
			status = "Votre tamagotchi s'endort paisiblement !";
		}
		bonheur ++;
		faim --;
		poid ++;
		propre ++;

		return status;
	}
	public String activiteSportive() {
		status = "Votre tamagochi ce défonce a la salle :dab: :dab:";
		fatigue --;
		propre --;
		poid --;
		faim --;
		return status;
	}
	public String douche() {
		status = "Votre tamagochi prend une bonne douche Oops il a fait tomber son savon !";
		propre ++;
		bonheur ++;
		fatigue --;
		return status;
	}
	public String jeux() {
		status = "Super votre tamagochi s'amuse comme un petit fou";
		bonheur += 2;
		fatigue -= 2;
		propre --;
		faim ++;
		return status;
	}
	//////END//////

	///LES STATUS///
	public String statusFaim() {
		String status = "";
		switch (faim) {
		case -5:
			status = nom + " Votre tamagotchi est mort";
			setVie(false);
			break;
		case -3: case -4: 
			status = nom + " Votre tamagotchi agonise";
			break;
		case 0: case 1: 
			status = nom + " Votre Tamagotchi est rassasié !";
			break;
		case 2: case 3:
			status = nom + " Votre tamagotchi a un gros bide il est plein !!!";
			break;
		case 4:
			status = nom + " Attention votre tamagotchi risque de vomir si vous le nourissez trop";
			break;
		case 5: 
			status = nom + " Beeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeer !!! voila il a vomis";
			setFaim(0);
			break;
		}
		return status;
	}
	public String statusPoid() {
		String status = "";
		switch (poid) {
		case -5:
			status = nom + " Votre tamagotchi est mort";
			setVie(false);
			break;
		case -3: case -4:  
			status = nom + " Votre tamagotchi est trop maigre et risque de mourir";
			break;
		case 0: case 1: 
			status = nom + "Votre Tamagotchi se sent bien sur la balance";
			break;
		case 2: case 3:
			status = nom + " Votre tamagotchi à grossi !!!";
			break;
		case 4:
			status = nom + " Attention votre tamagotchi risque de mourir d'obésité ";
			break;
		case 5: 
			status = nom + " Voila il est mort en roulant jusqu'à la mer et a coulé à cause de son poids";
			poid = 5;
			break;
		}
		return status;
	}	
	public String statusPropre() {
		String status = "";
		switch (propre) {
		case -5:
			status = nom + " Votre tamagotchi est mort à cause des escréments qui sont partout autour de lui";
			setVie(false);
			break;
		case -3: case -4: 
			status = nom + " Votre tamagotchi commence à faire caca autour de lui";
			break;
		case 0: case 1: 
			status = nom + " Votre Tamagotchi à envie d'aller à la douche car il pue !";
			break;
		case 2: case 3:
			status = nom + " Votre tamagotchi hésite entre une douche ou un bain !!!";
			break;
		case 4:
			status = nom + " est propre";
			break;
		case 5: 
			status = nom + " Brille de propreté ";
			propre = 5;
			break;
		}
		return status;
	}
	public String statusBonheur() {
		String status = "";
		switch (bonheur) {
		case -5:
			status = nom + " Votre tamagotchi est mort d'ennuie sous une musique de Nirvana";
			setVie(false);
			break;
		case -3: case -4: 
			status = nom + " Votre tamagotchi commence à déprimer, il a acheté une boite de lexomil";
			break;
		case 0: case 1: 
			status = nom + "Votre Tamagotchi va bien!";
			break;
		case 2: case 3:
			status = nom + "Votre tamagotchi s'enjaille sur World of Warcraft !!!";
			break;
		case 4:
			status = nom + " Votre tamagotchi s'enjaille une série";
			break;
		case 5: 
			status = nom + " fap fap fap";
			bonheur = 5;
			break;
		}
		return status;
	}
	public String statusMuscle() {	
		String status = "";
		switch (muscle) {
		case -5:
			status = nom + " Votre tamagotchi est une lavette";
			break;
		case -3: case -4: 
			status = nom + " Votre tamagotchi est faiblard";
			break;
		case 0: case 1: 
			status = nom + " Votre Tamagotchi est pas très musclé !";
			break;
		case 2: case 3:
			status = nom + " Votre tamagotchi commencer a etre tailler en V";
			break;
		case 4:
			status = nom + " Attention votre tamagotchi risque de ne plus passer les porte";
			break;
		case 5: 
			status = nom + " change de nom Scharwzeneger";
			setNom("Scharwzeneger");
			muscle = 5;
			break;
		}
		return status;
	}
	public String statusFatigue() {
		String status = "";
		switch (fatigue) {
		case -5:
			status = nom + " Votre tamagotchi est mort de fatigue il s'endort";
			dormir();
			break;
		case -3: case -4: 
			status = nom + " Votre tamagotchi meurt de fatigue il somnole";
			break;
		case 0: case 1: 
			status = nom + " Votre Tamagotchi est eveiller";
			break;
		case 2: case 3:
			status = nom + " Votre tamagotchi est bien reveiller";
			break;
		case 4:
			status = nom + " Votre tamagotchi a bus trop de redbull";
			break;
		case 5: 
			status = nom + " Votre tamagocthi a sniffer trop de speed attention a la crise cardiaque";
			fatigue = 5;
			break;
		}
		return status;
	}
	public String statusAge() {
		String status = "" + age;
		switch (age) {
		case 0:
			status = nom + " Votre tamagotchi est tout juste sortie de l'oeuf il a " + age +"ans";
			break;
		case 1: case 2: case 3: case 4: 
			status = nom + " Votre tamagotchi est un enfant il grandit vite il a " + age + " ans";
			break;
		case 5: case 6: case 7: 
			status = nom + " Votre Tamagotchi atteint l'adolescence (frapper avant d'entrée) il a " + age + " ans";
			break;
		case 8: case 9: case 10: case 11: case 12:
			status = nom + " Votre tamagotchi est adulte !! il a " + age + " ans";
			break;
		case 13:  case 14:
			status = nom + " Votre tamagotchi viellis a grand pas la mort le guette il a " + age + " ans";
			break;
		case 15: 
			status = " Votre tamagocthi est mort de viellesse rest in peace *tupac song*" + nom;
			vie = false;
			break;
			default:
				
				
		}
		return status;
	}
	//////END//////

	public String checkStatus() {
		String status = statusFaim() + "\n" + statusPoid()  + "\n" + statusPropre()  + "\n" + statusBonheur() + "\n" + statusMuscle() + "\n" + statusFatigue() + "\n" + statusAge();
		return status;	
	}

	//Testing things//
	@Override
	public String toString() {
		return "Tamagotchi [faim=" + faim + ", poid=" + poid + ", propre=" + propre + ", bonheur=" + bonheur
				+ ", muscle=" + muscle + ", fatigue=" + fatigue + ", sex=" + sex + ", nom=" + nom + "]";
	}
	///END///
	
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
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public boolean isVie() {
		return vie;
	}
	public void setVie(boolean vie) {
		this.vie = vie;
	}

	//////END//////




}
