package tamagotchi;

public class MainTamagotchi {

	public static void main(String[] args) {
		/*
		 * Un tamagotchi:
		 * naissance - mort 
		 * features, pouvoir le nourrir, laver, sport et jeux.
		 * Mort dans certaine condition 
		 * arriver a 30 ans le tama meurt
		 */
		Tamagotchi tama = new Tamagotchi() ;
		int essai=0;
				
		System.out.println("Choisis le sex de ton tamagotchi !!");
		
		tama.sex();
		
		System.out.println("Votre tamagotchi est un.e " + tama.getSex());
		
		System.out.println("Merci de choisir le nom de votre tamagotchi !");
		
		System.out.println(tama.eclosion());
		System.out.println(tama.isVie());
		//Tant que tamagotchi est en vie//
		while (tama.isVie() != false) {
			System.out.println(tama.checkStatus());
			tama.choix();
			essai ++;
			tama.setAge(essai);
			
		}
		
		System.out.println("La partie est terminer !");
		
		//choix de l'activité//
		
	}

}
