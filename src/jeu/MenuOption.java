package jeu;


public class MenuOption 
{
	static boolean jouerBruitage = false ;
	public static int[] typeMenu = { 0 , -1 } ; // highlight fixe , highlight non fixe // 0 : raccourcis / 1 : vidéo / 2 : son
	public static boolean changement = false ;
	public static int hauteurTitrePartie = 0 ;
	
	public static int sliderHauteurTexte = 0 ;
	public static int[] sliderMusique = { 0 , 0 , 0 , 100 , 6 , 0 } ; // posX , posY , posXCurseur , valeurCurseur , valeurVolume , modifEnCours
	public static String sliderMusiqueNom = "Volume de la musique" ;
	public static int[] sliderBruitage = { 0 , 0 , 0 , 100 , 6 , 0 } ; // posX , posY , posXCurseur , valeurCurseur , valeurVolume , modifEnCours
	public static String sliderBruitageNom = "Volume des bruitages" ;
	
	public static boolean fullscreen = false ;
	public static int[] choixMultiplesFullscreen = { 0 , 0 , 0 , 0 , 0 , 0 } ; // posX , posY , case choisie , case non choisie , menu ouvert , fermeture dynamique
	public static String[] choixMultiplesFullscreenNomChoix = { "Fenêtré" , "Fenêtré sans bord" , "Fullscreen" } ;
	public static int[] resolutionChoisie = { 1280 , 720 } ;
	public static int[] choixMultiplesResolutions = { 0 , 0 , 3 , 0 , 0 , 0 } ; // posX , posY , case choisie , case non choisie , menu ouvert , fermeture dynamique
	public static String[] choixMultiplesResolutionsNomChoix = { "1366x768" , "1360x768" , "1280x768" , "1280x720" , "1024x768" } ;
	
	public static boolean mute = false ;
	public static int[] caseCocherMute = { 0 , 0 , 0 , 0 } ; // posX , posY , longueur texte , cocher
	public static String caseCocherNomChoix = "Désactiver tous les sons" ;
	
	public static int[] raccourcisAttaque = { 0 , 0 , 0 , 0 , 65 } ; // posX , posY , rapide , modifEnCours , keycode
	public static String[] raccourcisAttaqueNom = { "A" , "attaque normale" } ;
	public static int[] raccourcisGauche = { 0 , 0 , 0 , 0 , 37 } ; // posX , posY , rapide , modifEnCours , keycode
	public static String[] raccourcisGaucheNom = { "gauche" , "déplacement gauche" } ;
	public static int[] raccourcisHaut = { 0 , 0 , 0 , 0 , 38 } ; // posX , posY , rapide , modifEnCours , keycode
	public static String[] raccourcisHautNom = { "haut" , "déplacement haut" } ;
	public static int[] raccourcisDroite = { 0 , 0 , 0 , 0 , 39 } ; // posX , posY , rapide , modifEnCours , keycode
	public static String[] raccourcisDroiteNom = { "droite" , "déplacement droite" } ;
	public static int[] raccourcisBas = { 0 , 0 , 0 , 0 , 40 } ; // posX , posY , rapide , modifEnCours , keycode
	public static String[] raccourcisBasNom = { "bas" , "déplacement bas" } ;
	
	
	@SuppressWarnings("deprecation")
	public boolean OptionTrame( AudioThread musiqueEnCours , String nomMusique )
	{
		
		changement = false ;
		int buffer ;
		Frame.menuOptionAfficher = true ;
		typeMenu[0] = 0 ; // réinitialise le menu ouvert lors d'ouverture multiple
		typeMenu[1] = -1 ;
		AudioThreadBruitage1 bruitage1 = new AudioThreadBruitage1( "Bruitage confirmation menu.wav" , 0 , sliderBruitage[4] , mute ) ;
		AudioThreadBruitage2 bruitage2 = new AudioThreadBruitage2( "Bruitage swap menu.wav" , 0 , sliderBruitage[4] , mute ) ;
		
		
		while ( Frame.menuOptionAfficher )
		{
			buffer = TimerThread.millisec ;
			
			// permet de changer la taille de l'écran à la souris et de garder les bonnes proportions
			// important : mettre les maj dans le même ordre que l'affichage souhaité !
			
/******************************************************************** MENU RACCOURCIS ***************************************************************************/
			raccourcisAttaque[0] = (int)(Frame.tailleEcran[0]*0.5-214.7*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			//raccourcisAttaque[0] = (int)(Frame.tailleEcran[0]/2-(882/2-215)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			raccourcisAttaque[1] = (int)(hauteurTitrePartie*1.5 + Frame.tailleEcran[1]*0.5 - 187.625*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			//raccourcisAttaque[1] = (int)(hauteurTitrePartie*1.5 + Frame.tailleEcran[1]/2 - (695/2-150)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			raccourcisGauche[0] = raccourcisAttaque[0] ;
			raccourcisHaut[1] = (int)(hauteurTitrePartie*2.5 + raccourcisAttaque[1] + (95+5)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			//raccourcisGauche[1] = (int)(hauteurTitrePartie*2.5 + Frame.tailleEcran[1]/2-(695/2-150-(95+5))*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			raccourcisGauche[1] = raccourcisHaut[1] + (int)((95+5)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			//raccourcisGauche[1] = (int)(Frame.tailleEcran[1]/2-(695/2-150-(95+5))*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			raccourcisHaut[0] = raccourcisGauche[0] + (int)((66+5)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			//raccourcisHaut[0] = (int)(Frame.tailleEcran[0]/2-(882/2-215-(66+5))*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			raccourcisDroite[0] = raccourcisHaut[0] + (int)((66+5)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			//raccourcisDroite[0] = (int)(Frame.tailleEcran[0]/2-(882/2-215-(66+5)*2)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			raccourcisDroite[1] = raccourcisGauche[1] ;
			raccourcisBas[0] = raccourcisHaut[0] ;
			raccourcisBas[1] = raccourcisGauche[1] ;
			
/*********************************************************************** MENU VIDÉO *****************************************************************************/
			choixMultiplesFullscreen[0] = (int)(Frame.tailleEcran[0]*0.5-214.7*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			choixMultiplesFullscreen[1] = (int)(Frame.tailleEcran[1]*0.5-187.625*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			choixMultiplesResolutions[0] = choixMultiplesFullscreen[0]+(int)(313.5*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			//choixMultiplesresolutions[0] = choixMultiplesFullscreen+(int)(220*1.5*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			choixMultiplesResolutions[1] = choixMultiplesFullscreen[1] ;
			
/************************************************************************ MENU SON ******************************************************************************/
			sliderMusique[0] = (int)(Frame.tailleEcran[0]*0.5-214.7*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
			sliderMusique[1] = (int)(Frame.tailleEcran[1]*0.5-171.475*Frame.tailleEcran[1]/resolutionChoisie[1])+sliderHauteurTexte ;
			//sliderMusique[1] = (int)(Frame.tailleEcran[1]/2-(695/2-150-17)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1])+sliderHauteurTexte ;
			sliderBruitage[0] = sliderMusique[0] ;
			sliderBruitage[1] = sliderMusique[1]+(int)(16.15*Frame.tailleEcran[1]/resolutionChoisie[1])+sliderHauteurTexte*4 ;
			//sliderMusique[1] = sliderMusique[1]+(int)(17*0.95*Frame.tailleEcran[1]/resolutionChoisie[1])+sliderHauteurTexte*4 ;
			
			caseCocherMute[0] = sliderBruitage[0] ;
			caseCocherMute[1] = sliderBruitage[1]+(int)(17*3*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			//caseCocherMute[1] = (int)(Frame.tailleEcran[1]/2-(695/2-150-52*2)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) ;
			
/************************************************************************ FIN MAJ *******************************************************************************/
			
			if ( Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5-409.45*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-256.025*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(162.45*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(120*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) )
			{ // Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5-(882/2-10)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-78)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(171*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(3*40*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] )
				for ( int i = 0 ; i < 3 ; i++ )
				{
					if ( (int)(Frame.tailleEcran[1]*0.5-(256.025-38*i)*Frame.tailleEcran[1]/resolutionChoisie[1]) < Panel.mousePos[1] && Panel.mousePos[1] < (int)(Frame.tailleEcran[1]*0.5-(256.025-38*(i+1))*Frame.tailleEcran[1]/resolutionChoisie[1]) )
					{ // (int)(Frame.tailleEcran[1]*0.5-(695/2-78-40*i)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) < Panel.mousePos[1] && Panel.mousePos[1] < (int)(Frame.tailleEcran[1]*0.5-(695/2-78-40*(i+1))*0.95*Frame.tailleEcran[1]/resolutionChoisie[1])
						typeMenu[1] = i ;
						if ( Frame.ml.leftClick == true )
						{
							
							if ( typeMenu[0] != i && Frame.changeMenuPossible == true ) // la seconde condition permet de faire comme beaucoup de jeu bloqué le swap sur une fenêtre anexe de modif ou de laissé le programme faire une boucle entière
							{
								typeMenu[0] = i ;
								jouerBruitage = true ;
								Frame.ml.leftClick = false ;
							}
						}
					}
				}
			}
			else
			{
				typeMenu[1] = -1 ;
			}
			
			
			switch( typeMenu[0] ) // 0 : raccourcis , 1 : vidéo , 2 : son
			{
				case 0 :
					raccourcisAttaque = optionRaccourcis( raccourcisAttaque[0] , raccourcisAttaque[1] , raccourcisAttaque[2] , raccourcisAttaque[3] , raccourcisAttaque[4] , raccourcisAttaqueNom[0] ) ;
					raccourcisGauche = optionRaccourcis( raccourcisGauche[0] , raccourcisGauche[1] , raccourcisGauche[2] , raccourcisGauche[3] , raccourcisGauche[4] , raccourcisGaucheNom[0] ) ;
					raccourcisHaut = optionRaccourcis( raccourcisHaut[0] , raccourcisHaut[1] , raccourcisHaut[2] , raccourcisHaut[3] , raccourcisHaut[4] , raccourcisHautNom[0] ) ;
					raccourcisDroite = optionRaccourcis( raccourcisDroite[0] , raccourcisDroite[1] , raccourcisDroite[2] , raccourcisDroite[3] , raccourcisDroite[4] , raccourcisDroiteNom[0] ) ;
					raccourcisBas = optionRaccourcis( raccourcisBas[0] , raccourcisBas[1] , raccourcisBas[2] , raccourcisBas[3] , raccourcisBas[4] , raccourcisBasNom[0] ) ;
					break ;
				case 1 :
					choixMultiplesFullscreen = optionChoixMultiple( choixMultiplesFullscreen[0] , choixMultiplesFullscreen[1] , choixMultiplesFullscreen[2] , choixMultiplesFullscreen[3] , choixMultiplesFullscreen[4] , choixMultiplesFullscreen[5] , choixMultiplesFullscreenNomChoix , choixMultiplesFullscreenNomChoix.length ) ;
					choixMultiplesResolutions = optionChoixMultiple( choixMultiplesResolutions[0] , choixMultiplesResolutions[1] , choixMultiplesResolutions[2] , choixMultiplesResolutions[3] , choixMultiplesResolutions[4] , choixMultiplesResolutions[5] , choixMultiplesResolutionsNomChoix , choixMultiplesResolutionsNomChoix.length ) ;
					break ;
				case 2 :
					sliderMusique = optionSlider( sliderMusique[0] , sliderMusique[1] , sliderMusique[2] , sliderMusique[3] , sliderMusique[4] , sliderMusique[5] ) ;
					sliderBruitage = optionSlider( sliderBruitage[0] , sliderBruitage[1] , sliderBruitage[2] , sliderBruitage[3] , sliderBruitage[4] , sliderBruitage[5] ) ;
					
					caseCocherMute[3] = optionCaseCocher( caseCocherMute[0] , caseCocherMute[1] , caseCocherMute[2] , caseCocherMute[3] ) ;
					break ;
			}
			
			// bouton Annuler
			if ( Frame.changeMenuPossible == true && changement == true && Frame.ml.leftClick == true && Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5+249.85*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5+278.825*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(142.5*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(36.1*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
			{ // Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5-(882/2-704)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-641)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(150*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(38*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] )
				changement = false ;
				Sauvegarde.read( 0 ) ;
				Frame.ml.leftClick = false ;
			}
			
			
			// bouton OK
			if ( Frame.changeMenuPossible == true && changement == true && Frame.ml.leftClick == true && Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5+101.65*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5+278.825*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(142.5*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(36.1*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
			{ // Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5-(882/2-548)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-641)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(150*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(38*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] )
				bruitage1.start() ;
				bruitage1 = new AudioThreadBruitage1( "Bruitage confirmation menu.wav" , 0 , sliderBruitage[4] , mute ) ;
				
				if ( choixMultiplesFullscreen[2] == 1 || choixMultiplesFullscreen[2] == 2 )
				{ // une diférence existe, je sais, mais comment fait-on le focus sur le jeu du vrai fullscreen ?
					fullscreen = true ;
				}
				else
				{
					fullscreen = false ;
				}
				if ( caseCocherMute[3] == 1 )
				{
					mute = true ;
				}
				else
				{
					mute = false ;
				}
				switch ( choixMultiplesResolutions[2] )
				{
					case 0 :
						resolutionChoisie[0] = 1366 ;
						resolutionChoisie[1] = 768 ;
						break ;
					case 1 :
						resolutionChoisie[0] = 1360 ;
						resolutionChoisie[1] = 768 ;
						break ;
					case 2 :
						resolutionChoisie[0] = 1280 ;
						resolutionChoisie[1] = 768 ;
						break ;
					case 3 :
						resolutionChoisie[0] = 1280 ;
						resolutionChoisie[1] = 720 ;
						break ;
					case 4 :
						resolutionChoisie[0] = 1024 ;
						resolutionChoisie[1] = 768 ;
						break ;
				}
				Sauvegarde.write( 0 ) ;
				changement = false ;
			}
			
			if ( jouerBruitage == true )
			{
				bruitage2.start() ;
				bruitage2 = new AudioThreadBruitage2( "Bruitage change menu.wav" , 0 , sliderBruitage[4] , mute ) ;
				jouerBruitage = false ;
			}
			
			if ( musiqueEnCours.IsFinish == true )
			{
				musiqueEnCours = new AudioThread( nomMusique , 0 , sliderMusique[4] , mute ) ;
				musiqueEnCours.start() ;
			}
			
			// réinitialisation du menu option
			if ( Frame.ml.leftClick == true && Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5+274.55*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-248.425*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(110.2*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(27.55*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
			{ // Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5-(882/2-730)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-86)*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(116*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(29*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] )
				Sauvegarde.read( -1 ) ;
				Sauvegarde.write( 0 ) ;
				Frame.menuOptionAfficher = false ;
				musiqueEnCours.stop() ;
				Frame.ml.leftClick = false ; // bug imprévu due au fait que frame n'existe plus lorsque l'on lache le clique gauche
			}
			
			// quitter le menu option
			if ( Frame.kl.echap == true || ( Frame.ml.leftClick == true && Frame.colliderBox( (int)(Frame.tailleEcran[0]*0.5+372.4*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-330.125*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(46.55*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(46.55*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true ) ) 
			{// colliderBox( (int)(Frame.tailleEcran[0]*(0.5+(882-49*2)*0.95*Frame.tailleEcran[0]/(resolutionChoisie[0]*2))) , (int)(Frame.tailleEcran[1]*0.5-695*0.95*Frame.tailleEcran[1]/(resolutionChoisie[1]*2)) , (int)(Frame.tailleEcran[0]*49*0.95/resolutionChoisie[0]) ,(int)(Frame.tailleEcran[1]*49*0.95/resolutionChoisie[1]) , mouseX , mouseY )
				Frame.menuOptionAfficher = false ;
				musiqueEnCours.stop() ;
				Frame.ml.leftClick = false ; // bug imprévu due au fait que frame n'existe plus lorsque l'on lache le clique gauche
			}
			Frame.actionsParDefaut( buffer ) ;
		}
		return true ;
	}
	
	public static int[] optionChoixMultiple( int posX , int posY , int caseChoisie , int caseNonChoisie , int choixMultipleOuvert , int fermeture , String[] choixMultipleNomChoix , int nbChoix )
	{//System.out.println(fermeture);
		int[] retourtab = new int[6] ;
		if ( fermeture == 1 ) // permet de fermer les autres menus sans prendre en compte l'ordre dans lequel ils sont codés
		{
			Frame.ml.leftClick = false ; // évite la fermeture/ouverture en chaîne du sous menu
			fermeture = 0 ;
		}
		if ( choixMultipleOuvert == 1 )
		{
			Frame.changeMenuPossible = false ; // dommage que le temps de boucle peut faire que le menu ne change pas toujours dès le 1° leftClick
		}
		if ( Frame.ml.leftClick == true && Frame.colliderBox( posX , posY , (int)(209*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(26.6*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
		{ // Frame.colliderBox( posX , posY , (int)(220*0.95*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(28*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] )
			
			if ( choixMultipleOuvert == 0 )
			{
				fermeture = 1 ;
				choixMultipleOuvert = 1 ;
				jouerBruitage = true ;
			}
			else
			{
				choixMultipleOuvert = 0 ;
				fermeture = 0 ;
				Frame.ml.leftClick = false ; // lorsque l'on ferme manuellement un menu, les autres menus sont déjà fermés donc il n'y a pas de problème
				jouerBruitage = true ;
				Frame.changeMenuPossible = true ;
			}
		}
		else if ( choixMultipleOuvert == 1 && (Frame.ml.leftClick == true || Frame.ml.rightClick == true) && Frame.colliderBox( posX , posY+(int)(Frame.tailleEcran[1]*26.6/resolutionChoisie[1]) , (int)(209*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(26.6*choixMultipleNomChoix.length*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == false )
		{ // rightclick aussi car certains font des cliques droit pour fermer les menus
			choixMultipleOuvert = 0 ;
			fermeture = 0 ;
			jouerBruitage = true ;
			Frame.changeMenuPossible = true ;
		}
		
		caseNonChoisie = -1 ; // évite tout bug graphique potentiel
		if ( choixMultipleOuvert == 1 && Frame.colliderBox( posX , posY+(int)(26.6*Frame.tailleEcran[1]/resolutionChoisie[1]) , (int)(209*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)((26.6+25.65*nbChoix)*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) )
		{
			for ( int i = 0 ; i < nbChoix ; i++ )
			{
				if ( Panel.mousePos[1] > posY+(int)((26.6+25.65*i)*Frame.tailleEcran[1]/resolutionChoisie[1]) && Panel.mousePos[1] < posY+(int)((26.6+25.65*(i+1))*Frame.tailleEcran[1]/resolutionChoisie[1]) )
				{
					caseNonChoisie = i ;
					if ( Frame.ml.leftClick == true )
					{
						if ( caseChoisie != i )
						{
							jouerBruitage = true ;
							changement = true ;
							caseChoisie = i ;
						}
						Frame.ml.leftClick = false ;
					}
				}
			}
		}
		
		retourtab[0] = posX ;
		retourtab[1] = posY ;
		retourtab[2] = caseChoisie ;
		retourtab[3] = caseNonChoisie ;
		retourtab[4] = choixMultipleOuvert ;
		retourtab[5] = fermeture ;
		return retourtab ;
	}
	
	public static int[] optionSlider( int posX , int posY , int posXCurseur , int valeurCurseur , int volumeSon , int modifEnCours )
	{
		int[] retourtab = new int[6] ;
		retourtab[4] = volumeSon ; // permet de faire les vérification pour changement sans problème
		
		if ( modifEnCours == 0 && Frame.ml.leftClick == true && Frame.colliderBox( posX , posY , (int)(478.8*Frame.tailleEcran[0]/resolutionChoisie[0])  , (int)(18.05*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
		{ // Frame.colliderBox( posX , posY , (int)(504*0.95*Frame.tailleEcran[0]/resolutionChoisie[0])  , (int)(19*0.95*Frame.tailleEcran[1]/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] )
			modifEnCours = 1 ;
			Frame.changeMenuPossible = false ;
		}
		
		if ( Frame.ml.leftClick == true && modifEnCours == 1 && Frame.colliderBox( posX , 0 , (int)(478.8*Frame.tailleEcran[0]/resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
		{
			retourtab[5] = 1 ;
			if ( Panel.mousePos[0] < posX + (int)(8.075*Frame.tailleEcran[0]/resolutionChoisie[0]) )
			{ // (int)((17/2)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0])
				valeurCurseur = 0 ;
			}
			else if ( Panel.mousePos[0] > posX + (int)(462.65*Frame.tailleEcran[0]/resolutionChoisie[0]) )
			{ // (int)((504-17)*0.95*Frame.tailleEcran[0]/resolutionChoisie[0])
				valeurCurseur = 100 ;
			}
			else
			{
				valeurCurseur = (Panel.mousePos[0] - posX)*100/((int)((462.65)*Frame.tailleEcran[0]/resolutionChoisie[0])) ;
			}
		}
		else
		{
			if ( modifEnCours == 1 ) // permet que les mouvements brusques soient prit en compte et évite de bloquer le leftclick des autres sliders
			{
				if ( Panel.mousePos[0] < posX )
				{
					valeurCurseur = 0 ;
				}
				else if ( Panel.mousePos[0] > posX + (int)(478.8*Frame.tailleEcran[0]/resolutionChoisie[0]) )
				{
					valeurCurseur = 100 ;
				}
				modifEnCours = 0 ;
				Frame.ml.leftClick = false ;
				retourtab[5] = 0 ;
				jouerBruitage = true ;
				Frame.changeMenuPossible = true ;
			}
		}
		posXCurseur = posX + (int)(valeurCurseur*4.6265*Frame.tailleEcran[0]/resolutionChoisie[0]) ;
		//posXCurseur = posX + (int)(valeurCurseur*(504-17)*0.95*Frame.tailleEcran[0]/(resolutionChoisie[0]*100)) ;
		volumeSon = valeurCurseur*56/100 - 50 ; // comment les jeux normaux font une vrai gestion du son ? car la je suis 100% dépendant du son de l'ordi (le 50/100 est plus ou moins vrai)
		
		if ( retourtab[4] != volumeSon )
		{
			changement = true ;
		}
		
		retourtab[0] = posX ;
		retourtab[1] = posY ;
		retourtab[2] = posXCurseur ;
		retourtab[3] = valeurCurseur ;
		retourtab[4] = volumeSon ;
		return retourtab ;
	}
	
	public static int optionCaseCocher( int posX , int posY , int tailleTexte , int cocher )
	{
		if ( Frame.changeMenuPossible == true && Frame.ml.leftClick == true && Frame.colliderBox( posX , posY , (int)(Frame.tailleEcran[0]*13/resolutionChoisie[0] + Frame.tailleEcran[0]*17/resolutionChoisie[0] + tailleTexte) , (int)(Frame.tailleEcran[1]*13/resolutionChoisie[1]) , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
		{
			if ( cocher == 1 )
			{
				cocher = 0 ;
			}
			else
			{
				cocher = 1 ;
			}
			changement = true ;
			Frame.ml.leftClick = false ; // évite que la case se coche/décoche en chaîne
			jouerBruitage = true ;
		}
		return cocher ;
	}
	
	public static int[] optionRaccourcis( int posX , int posY , int rapide , int modif , int input , String inputNom )
	{
		int[] retourtab = new int[5] ;
		retourtab[2] = rapide ; // permet de faire les vérification pour changement sans problème
		retourtab[4] = input ;
		
		if ( modif == 1 && ( Frame.kli.inputModif != -1 || (Frame.ml.leftClick == true && Frame.colliderBox( (int)((Frame.tailleEcran[0] - Frame.tailleEcran[0]*187/resolutionChoisie[0])*0.5) , (int)((Frame.tailleEcran[1] - Frame.tailleEcran[1]*259/resolutionChoisie[1])*0.5 + Frame.tailleEcran[1]*175/resolutionChoisie[1]) , Frame.tailleEcran[0]*187/resolutionChoisie[0] , Frame.tailleEcran[1]*33/resolutionChoisie[1] , Panel.mousePos[0] , Panel.mousePos[1] ) == true )) )
		{
			if ( Frame.inputModifNomEnCours == false ) // on vérifie que le panel est changer avant de stopper la modif
			{
				Frame.inputModifEnCours = false ;
				modif = 0 ;
				Frame.changeMenuPossible = true ;
			}
			
			if ( Frame.kli.inputModif != -1 )
			{
				input = Frame.kli.inputModif ;
				jouerBruitage = true ;
			}
			
			if ( Frame.ml.leftClick == true ) // cas où on ne change pas l'input
			{
				Frame.ml.leftClick = false ;
				Frame.inputModifNomEnCours = false ;
				Frame.inputModifEnCours = false ;
				modif = 0 ;
				jouerBruitage = true ;
				Frame.changeMenuPossible = true ;
			}
		}
		
		if ( Frame.ml.leftClick == true && Frame.colliderBox( posX , posY + Frame.tailleEcran[1]*65/resolutionChoisie[1] , Frame.tailleEcran[0]*66/resolutionChoisie[0] , Frame.tailleEcran[1]*30/resolutionChoisie[1] , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
		{
			if ( rapide == 0 )
			{
				rapide = 1 ;
			}
			else
			{
				rapide = 0 ;
			}
			Frame.ml.leftClick = false ;
			jouerBruitage = true ;
		}
		
		if ( Frame.inputModifEnCours == false && Frame.ml.leftClick == true && Frame.colliderBox( posX , posY + Frame.tailleEcran[1]*17/resolutionChoisie[1] , Frame.tailleEcran[0]*66/resolutionChoisie[0] , Frame.tailleEcran[1]*47/resolutionChoisie[1] , Panel.mousePos[0] , Panel.mousePos[1] ) == true )
		{ // Frame.inputModifEnCours == false pour éviter de modifier plusieurs input en même temps lors d'un leftclick malchancuex
			Frame.inputModifEnCours = true ;
			Frame.inputModifNomEnCours = true ;
			Frame.ml.leftClick = false ;
			modif = 1 ;
			jouerBruitage = true ;
			Frame.changeMenuPossible = false ;
		}
		
		if ( retourtab[2] != rapide || retourtab[4] != input )
		{
			changement = true ;
		}
		
		retourtab[0] = posX ;
		retourtab[1] = posY ;
		retourtab[2] = rapide ;
		retourtab[3] = modif ;
		retourtab[4] = input ;
		return retourtab ;
	}
	
}
