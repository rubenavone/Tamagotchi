package tamagotchi;

public class MainTamagotchi {

	public static void main(String[] args) {
		/*
		 * Un tamagotchi:
		 * naissance - mort 
		 * features, pouvoir le nourrir, laver, sport et jeux.
		 * 
		 */
		Tamagotchi tama = new Tamagotchi() ;
		
		System.out.println("Choisis le sex de ton tamagotchi !!");
		tama.sex();
		System.out.println("Merci de choisir le nom de votre tamagotchi !");
		System.out.println(tama.eclosion());
		System.out.println(tama);
		
		
	}

}
