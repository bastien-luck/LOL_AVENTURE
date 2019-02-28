package jeu ;

import javax.swing.JFrame ;

public class Frame extends JFrame
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static Panel panel = new Panel() ;
	static PanelScrolling panelScrolling = new PanelScrolling() ;
	static MenuOption menuOption = new MenuOption() ;
	static mouseListener ml = new mouseListener() ;
	static mouseWheelListener mwl = new mouseWheelListener() ;
	static keyListener kl = new keyListener() ;
	static KeyListenerInt kli = new KeyListenerInt() ;
	static int framerate = /*12*/50 ; // 50 m'évite de mêttre mon proccésseur à 100%...
	static int buffer ;
	
	public static int tailleEcran[] = new int[2] ;
	public static int tailleTexte = 15 ;
	
	public static int testX = 0 ;
	public static int testY = 0 ;
	
	public static boolean onScreen = false ;
	public static boolean inbox = false ;
	public static boolean menuOptionAfficher = false ;
	public static boolean chargementEnCour = false ;
	public static int zoneAffichage = 0 ; // 0 : disclaimer, 1 : menu début, 2 : menu selection perso
	
	public static double posYselPersoBarreDefil ;
	public static double posYselPerso ;
	
	public static boolean restartEnCours = false ;
	
	public static boolean inputModifNomEnCours = false ; // servent à réinitialisé les modificateur du keylistener
	public static boolean inputModifEnCours = false ;
	public static String inputModifNom = "" ;
	public static boolean menuFermer = true ;
	public static boolean changeMenuPossible = true ;
	
	// actions possibles :
	public static boolean menuSysteme = false ;
	public static boolean confirmerAction = false ;
	public static boolean mouvementGauche = false ;
	public static boolean mouvementHaut = false ;
	public static boolean mouvementDroite = false ;
	public static boolean mouvementBas = false ;
	public static boolean attaque = false ;
	
	
	
	public Frame( String titre )
	{
		Sauvegarde.read( 0 ) ; // valeur du menu option choisie par le joueur
/**************************************************************** INITIALISATION DONNÉES ************************************************************************/
		
		switch ( MenuOption.choixMultiplesResolutions[2] ) 
		{
			case 0 :
				MenuOption.resolutionChoisie[0] = 1366 ;
				MenuOption.resolutionChoisie[1] = 768 ;
				break ;
			case 1 :
				MenuOption.resolutionChoisie[0] = 1360 ;
				MenuOption.resolutionChoisie[1] = 768 ;
				break ;
			case 2 :
				MenuOption.resolutionChoisie[0] = 1280 ;
				MenuOption.resolutionChoisie[1] = 768 ;
				break ;
			case 3 :
				MenuOption.resolutionChoisie[0] = 1280 ;
				MenuOption.resolutionChoisie[1] = 720 ;
				break ;
			case 4 :
				MenuOption.resolutionChoisie[0] = 1024 ;
				MenuOption.resolutionChoisie[1] = 768 ;
				break ;
		}
		tailleEcran[0] = MenuOption.resolutionChoisie[0] ;
		tailleEcran[1] = MenuOption.resolutionChoisie[1] ;
		
		if ( MenuOption.choixMultiplesFullscreen[2] == 1 || MenuOption.choixMultiplesFullscreen[2] == 2 )
		{ // une diférence existe entre fenêtré sans bord et fullscreen, je sais, mais laquelle ?
			MenuOption.fullscreen = true ;
		}
		else
		{
			MenuOption.fullscreen = false ;
		}
		if ( MenuOption.caseCocherMute[3] == 1 )
		{
			MenuOption.mute = true ;
		}
		else
		{
			MenuOption.mute = false ;
		}
/*************************************************************************** FIN ********************************************************************************/
		
		this.setSize( tailleEcran[0] , tailleEcran[1] ) ; // évite d'avoir un écran de taille 0*0
		this.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
		this.setLocationRelativeTo( null ) ;
		this.setTitle( titre ) ;
		this.getContentPane().add(panel);
		//this.getContentPane().add(panelScrolling); // tentative raté d'un sous panel servant à faire un effet de zone scrollable (comme le coin du chois de perso) à l'intérieur d'une zone de l'écran (l'intérêt était surtout pour le menu option) : il n'est pas possible d'avoir deux panel en même temps sur une même frame.
		this.addMouseListener( ml ) ;
		this.addMouseWheelListener( mwl ) ;
		this.addKeyListener( kl ) ;
		this.addKeyListener( kli ) ;
		if ( MenuOption.fullscreen == true )
		{
			this.setUndecorated( true ) ;
			this.setExtendedState( MAXIMIZED_BOTH ) ; // permet le mode fullscreen
		}
		this.setVisible( true ) ;
		
		restartEnCours = false ;
		
		while ( restartEnCours == false ) // permet de reload le jeu pour mêttre à jour les paramètre de la Frame
		{
			switch ( zoneAffichage )
			{
				case 0 :
					while ( confirmerAction == false )
					{
						buffer = TimerThread.millisec ;/*
						restartEnCours = menuOption.OptionTrame( new AudioThread( "Musique ecran début.wav" , 0 , MenuOption.sliderMusique[4] , MenuOption.mute ) , "Musique ecran début.wav" ) ;
						restartEnCours = false ;*/ // sert juste aux test du menuOption
						actionsParDefaut( buffer ) ;
					}
					confirmerAction = false ; // évite le passage directe à "nouvelle partie" (ne bloque pas la répétition clavier)
					zoneAffichage = 1 ;
					break ;
				case 1 :
					BeginTrame() ;
					break ;
				case 2 :
					GameTrame() ;
					break ;
				
			}
		}
	}
	
	
	@SuppressWarnings("deprecation")
	public static void BeginTrame()
	{
		double majPosIconSelectionY = 4.875 ; // valeur par défaut + 0.375
		boolean bruitageJouer = false ; // sécuriter pour les playlist longues ( fournit en exemple car inutile ici )
		AudioThreadBruitage1 bruitage1 = new AudioThreadBruitage1( "Bruitage confirmation menu.wav" , 0 , MenuOption.sliderBruitage[4] , MenuOption.mute ) ;
		AudioThreadBruitage2 bruitage2 = new AudioThreadBruitage2( "Bruitage change menu.wav" , 0 , MenuOption.sliderBruitage[4] , MenuOption.mute ) ;
		
		AudioThread son = new AudioThread( "Musique ecran début.wav" , 0 , MenuOption.sliderMusique[4] , MenuOption.mute ) ;
		
		son.start();
		
		
			
		while ( zoneAffichage == 1 && restartEnCours == false )
		{
			buffer = TimerThread.millisec ;
			
			
			
			if ( confirmerAction == true && majPosIconSelectionY == 4.875 )
			{
				zoneAffichage = 2 ;
				son.stop() ;
			}
			
			if ( confirmerAction == true && majPosIconSelectionY == 3.375 )
			{
				restartEnCours = menuOption.OptionTrame( son , "Musique ecran début.wav" ) ;
			}
			
			if ( confirmerAction == true && majPosIconSelectionY == 1.875 )
			{
				System.exit( 0 ) ;
			}
			
			if ( son.IsFinish == true )
			{
				son = new AudioThread( "Musique ecran début.wav" , 0 , MenuOption.sliderMusique[4] , MenuOption.mute ) ;
				son.start() ;
			}
			
			if ( mouvementBas == true )
			{
				bruitage2.start() ;
				bruitage2 = new AudioThreadBruitage2( "Bruitage change menu.wav" , 0 , MenuOption.sliderBruitage[4] , MenuOption.mute ) ;
				if ( majPosIconSelectionY == 4.875 )
				{
					majPosIconSelectionY = 3.375 ;
				}
				else if ( majPosIconSelectionY == 3.375 )
				{
					majPosIconSelectionY = 1.875 ;
				}
				else
				{
					majPosIconSelectionY = 4.875 ;
				}
				mouvementBas = false ; // évite que le curseur change a chaque frame ( méthode pratique pour les jeux input par input )
			}
			
			else if ( mouvementHaut == true )
			{
				bruitage2.start() ;
				bruitage2 = new AudioThreadBruitage2( "Bruitage change menu.wav" , 0 , MenuOption.sliderBruitage[4] , MenuOption.mute ) ;
				if ( majPosIconSelectionY == 4.875 )
				{
					majPosIconSelectionY = 1.875 ;
				}
				else if ( majPosIconSelectionY == 3.375 )
				{
					majPosIconSelectionY = 4.875 ;
				}
				else
				{
					majPosIconSelectionY = 3.375 ;
				}
				mouvementHaut = false ; // évite que le curseur change a chaque frame
			}
			
			panel.posIconSelectionY = majPosIconSelectionY ;
			
			if ( ( confirmerAction == true ) && bruitageJouer == false )
			{
				bruitage1.start() ;
				bruitageJouer = true ;
			}
			if ( bruitage1.IsFinish == true ) // permet de rejouer le son
			{
				bruitageJouer = false ;
				bruitage1 = new AudioThreadBruitage1( "Bruitage confirmation menu.wav" , 0 , MenuOption.sliderBruitage[4] , MenuOption.mute ) ;
			}
			
			panel.turn ++ ;
			actionsParDefaut( buffer ) ;
			
		}
	}
	
	@SuppressWarnings("deprecation")
	public static void GameTrame()
	{
		posYselPersoBarreDefil = 0 ;
		posYselPerso = 0 ;
		mwl.mwCompteur = 0 ; // évite l'éffet mémoire lors de l'arrivée sur ce menu
		
		AudioThread son = new AudioThread( "Musique sel perso.wav" , 0 , MenuOption.sliderMusique[4] , MenuOption.mute ) ;
		
		son.start();
		
		while ( zoneAffichage == 2 && restartEnCours == false )
		{
			buffer = TimerThread.millisec ;

			if ( son.IsFinish == true )
			{
				son = new AudioThread( "Musique sel perso.wav" , 0 , MenuOption.sliderMusique[4] , MenuOption.mute ) ;
				son.start() ;
			}
				
			if ( mwl.mouseRotation == 1 && posYselPerso > -4 )
			{
				if ( posYselPerso - 0.25*mwl.mwCompteur > -4 )
				{
					posYselPersoBarreDefil += 0.05*mwl.mwCompteur ;
					posYselPerso -= 0.25*mwl.mwCompteur ;
				}
				else
				{
					posYselPersoBarreDefil = 0.8 ;
					posYselPerso = -4 ;
				}
			}
			else if ( mwl.mouseRotation == -1 && posYselPerso < 0 )
			{
				if ( posYselPerso + 0.25*mwl.mwCompteur < 0 )
				{
					posYselPersoBarreDefil -= 0.05*mwl.mwCompteur ;
					posYselPerso += 0.25*mwl.mwCompteur ;
				}
				else
				{
					posYselPersoBarreDefil = 0 ;
					posYselPerso = 0 ;
				}
			}
			
			mwl.mwCompteur = 0 ; // réinitialisation du compteur lorsqu'il est utilisé
			
			
			
			if ( menuSysteme == true ) // cas où on cherche à revenir sur le menu global
			{
				zoneAffichage = 1 ;
				son.stop() ;
			}
			
			/*Sauvegarde.write( 1 ) ;
			Sauvegarde.read( 1 ) ;*/ // à placer plus tard
			
			actionsParDefaut( buffer ) ;
		}
		
	}
	
	public static boolean colliderBox( int posX , int posY , int largeur , int hauteur , int curseurX , int curseurY  )
	{
		if ( curseurX > posX && curseurX < posX+largeur && curseurY > posY && curseurY < posY+hauteur )
		{
			return true ;
		}
		else
		{
			return false ;
		}
	}
	
	public static void actionsParDefaut( int buf )
	{
		if ( Panel.mousePos[0] > 0 && Panel.mousePos[0] < tailleEcran[0] && Panel.mousePos[1] > 0 && Panel.mousePos[1] < tailleEcran[1] )
		{
			onScreen = true ; // non utilsé mais utilité possible
		}
		
		if ( colliderBox( 0 /*posX*/ , 0  /*posY*/ , 100 /*largeur*/ , 100 /*hauteur*/ , Panel.mousePos[0] , Panel.mousePos[1] ))
		{
			inbox = true ;
		}
		else
		{
			inbox = false ;
		}
		
		mwl.mouseRotation = 0 ;
		
		if ( ( TimerThread.millisec - buf ) < framerate )
		{
			try 
			{
				Thread.sleep( framerate - ( TimerThread.millisec - buf ) ) ;
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}
	
}
