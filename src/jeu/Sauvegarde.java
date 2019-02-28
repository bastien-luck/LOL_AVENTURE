package jeu;

import java.io.* ;

public class Sauvegarde {
	
	public static void read( int type )
	{
		String fichier = "" ;
		
		if ( type == 0 )
		{
			fichier = "SauvegardeOption.txt" ;
		}
		
		else if ( type == 1 )
		{
			fichier = "Sauvegarde.txt" ;
		}
		
		if ( type == -1 ) // parametre par defaut pas dans un fichier car vu qu'ils ne sont pas modifiable cela n'est pas utile
		{
			MenuOption.sliderMusique[3] = 100 ;
			MenuOption.sliderMusique[4] = 6 ;
			MenuOption.sliderBruitage[3] = 100 ;
			MenuOption.sliderBruitage[4] = 6 ;
			MenuOption.choixMultiplesFullscreen[2] = 0 ;
			MenuOption.choixMultiplesResolutions[2] = 3 ;
			MenuOption.caseCocherMute[3] = 0 ;
			MenuOption.raccourcisAttaque[2] = 0 ;
			MenuOption.raccourcisAttaque[4] = 65 ;
			Frame.kli.attaque = 65 ;
			MenuOption.raccourcisAttaqueNom[0] = "A" ;
			MenuOption.raccourcisGauche[2] = 0 ;
			MenuOption.raccourcisGauche[4] = 37 ;
			Frame.kli.gauche = 37 ;
			MenuOption.raccourcisGaucheNom[0] = "Gauche" ;
			MenuOption.raccourcisHaut[2] = 0 ;
			MenuOption.raccourcisHaut[4] = 38 ;
			Frame.kli.haut = 38 ;
			MenuOption.raccourcisHautNom[0] = "Haut" ;
			MenuOption.raccourcisDroite[2] = 0 ;
			MenuOption.raccourcisDroite[4] = 39 ;
			Frame.kli.droite = 39 ;
			MenuOption.raccourcisDroiteNom[0] = "Droite" ;
			MenuOption.raccourcisBas[2] = 0 ;
			MenuOption.raccourcisBas[4] = 40 ;
			Frame.kli.bas = 40 ;
			MenuOption.raccourcisBasNom[0] = "Bas" ;
		}
		else
		{
			try 
			{
				InputStream is = new FileInputStream( fichier ) ;
				InputStreamReader isr = new InputStreamReader( is ) ;
				BufferedReader br = new BufferedReader( isr ) ;
				try 
				{
					
					if ( type == 0 ) // paramettre de base + option
					{
						MenuOption.sliderMusique[3] = Integer.parseInt( br.readLine() ) ;
						MenuOption.sliderMusique[4] = Integer.parseInt( br.readLine() ) ;
						MenuOption.sliderBruitage[3] = Integer.parseInt( br.readLine() ) ;
						MenuOption.sliderBruitage[4] = Integer.parseInt( br.readLine() ) ;
						MenuOption.choixMultiplesFullscreen[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.choixMultiplesResolutions[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.caseCocherMute[3] = Integer.parseInt( br.readLine() ) ;
						MenuOption.raccourcisAttaque[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.raccourcisAttaque[4] = Integer.parseInt( br.readLine() ) ;
						Frame.kli.attaque = MenuOption.raccourcisAttaque[4] ; // permet de beaucoup moins s'embéter pour l'initialisation/reset
						MenuOption.raccourcisAttaqueNom[0] = br.readLine() ;
						MenuOption.raccourcisGauche[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.raccourcisGauche[4] = Integer.parseInt( br.readLine() ) ;
						Frame.kli.gauche = MenuOption.raccourcisGauche[4] ; // voir s'il faudra changer cette ligne lorsque plusieurs set d'input seront utilisé
						MenuOption.raccourcisGaucheNom[0] = br.readLine() ;
						MenuOption.raccourcisHaut[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.raccourcisHaut[4] = Integer.parseInt( br.readLine() ) ;
						Frame.kli.haut = MenuOption.raccourcisHaut[4] ;
						MenuOption.raccourcisHautNom[0] = br.readLine() ;
						MenuOption.raccourcisDroite[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.raccourcisDroite[4] = Integer.parseInt( br.readLine() ) ;
						Frame.kli.droite = MenuOption.raccourcisDroite[4] ;
						MenuOption.raccourcisDroiteNom[0] = br.readLine() ;
						MenuOption.raccourcisBas[2] = Integer.parseInt( br.readLine() ) ;
						MenuOption.raccourcisBas[4] = Integer.parseInt( br.readLine() ) ;
						Frame.kli.bas = MenuOption.raccourcisBas[4] ;
						MenuOption.raccourcisBasNom[0] = br.readLine() ;
					}
					
					else if ( type == 1 ) // sauvergarde 1° partie
					{
						Frame.panel.turn = Integer.parseInt( br.readLine() ) ;
					}
				} catch (NumberFormatException | IOException e) {e.printStackTrace();}
				
				
				br.close();
			} catch (IOException e) {e.printStackTrace();}
		}
		
	}
	
	public static void write( int type )
	{
		BufferedWriter bw ;
		try 
		{
			
			if ( type == 0 )
			{
				bw = new BufferedWriter( new FileWriter( "SauvegardeOption.txt" ) );
				ecritureInt( MenuOption.sliderMusique[3] , bw ) ;
				ecritureInt( MenuOption.sliderMusique[4] , bw ) ;
				ecritureInt( MenuOption.sliderBruitage[3] , bw ) ;
				ecritureInt( MenuOption.sliderBruitage[4] , bw ) ;
				ecritureInt( MenuOption.choixMultiplesFullscreen[2] , bw ) ;
				ecritureInt( MenuOption.choixMultiplesResolutions[2] , bw ) ;
				ecritureInt( MenuOption.caseCocherMute[3] , bw ) ;
				ecritureInt( MenuOption.raccourcisAttaque[2] , bw ) ;
				ecritureInt( MenuOption.raccourcisAttaque[4] , bw ) ;
				//ecritureInt( Frame.kli.attaque , bw ) ; // à voir si cette ligne est utile ?
				ecritureString( MenuOption.raccourcisAttaqueNom[0] , bw ) ;
				ecritureInt( MenuOption.raccourcisGauche[2] , bw ) ;
				ecritureInt( MenuOption.raccourcisGauche[4] , bw ) ;
				
				ecritureString( MenuOption.raccourcisGaucheNom[0] , bw ) ;
				ecritureInt( MenuOption.raccourcisHaut[2] , bw ) ;
				ecritureInt( MenuOption.raccourcisHaut[4] , bw ) ;
				
				ecritureString( MenuOption.raccourcisHautNom[0] , bw ) ;
				ecritureInt( MenuOption.raccourcisDroite[2] , bw ) ;
				ecritureInt( MenuOption.raccourcisDroite[4] , bw ) ;
				
				ecritureString( MenuOption.raccourcisDroiteNom[0] , bw ) ;
				ecritureInt( MenuOption.raccourcisBas[2] , bw ) ;
				ecritureInt( MenuOption.raccourcisBas[4] , bw ) ;
				
				ecritureString( MenuOption.raccourcisBasNom[0] , bw ) ;
			}
			else if ( type == 1 )
			{
				bw = new BufferedWriter( new FileWriter( "Sauvegarde.txt" ) );
				ecritureInt( Frame.panel.turn , bw ) ;
			}
			
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private static void ecritureInt( int add , BufferedWriter BW )
	{
		try 
		{
			BW.write( Integer.toString( add ) ) ;
			BW.flush() ;
			BW.newLine() ;
		} catch (IOException e) {e.printStackTrace();}
	}
	
	private static void ecritureString( String add , BufferedWriter BW )
	{
		try 
		{
			BW.write( add ) ;
			BW.flush() ;
			BW.newLine() ;
		} catch (IOException e) {e.printStackTrace();}
	}
	
}
