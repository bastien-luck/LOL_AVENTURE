package jeu ;

public class Main 
{
	public static String disclaimer1 = "LOL AVENTURE isn’t endorsed by Riot Games and doesn’t reflect the views or opinions" ;
	public static String disclaimer2 = "of Riot Games or anyone officially involved in producing or managing League of Legends." ;
	public static String disclaimer3 = "League of Legends and Riot Games are trademarks or registered trademarks of Riot Games, Inc." ;
	public static String disclaimer4 = "League of Legends © Riot Games, Inc." ;
	public static String gratuit = "Ce jeu est entièrement gratuit ! Si vous avez du payé pour l'obtenir, veuillez avertir Riot Games pour qu'ils bloquent le site frauduleux." ;
	
	
	public static void main(String[] args) {
		
		
		
		TimerThread timer = new TimerThread() ;
		GraphicsThread graph = new GraphicsThread() ;
		graph.start() ;
		timer.start() ;
		while ( true ) // permet de faire une modification des options sans redémarré le programme
		{
			Frame frame = new Frame( "LOL AVENTURE" ) ;
			frame.dispose();
		}

	}
	

}

