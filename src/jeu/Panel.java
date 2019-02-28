package jeu ;

import java.awt.* ;
import java.awt.geom.AffineTransform;

import javax.swing.ImageIcon;
import javax.swing.JPanel ;

public class Panel extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static int mousePos[] = new int[2] ;
	public double posIconSelectionY = 4.875 ;
	public static AffineTransform old = new AffineTransform() ;
	static int tailleImg = 100 ;
	static int grid = 20 ;
	int turn = 0 ;
	double test = 0 ;
	
	
	public void paintComponent( Graphics g ) // réglages effectués par rapport à une resolution 1200*700
	{
		mousePos[0] = MouseInfo.getPointerInfo().getLocation().x - getLocationOnScreen().x ;
		mousePos[1] = MouseInfo.getPointerInfo().getLocation().y - getLocationOnScreen().y ;
		Frame.tailleEcran[0] = getSize().width ;
		Frame.tailleEcran[1] = getSize().height ;
		g.setColor( new Color( 0 , 0 , 0 ) ) ;
		g.fillRect( 0 , 0 , Frame.tailleEcran[0] , Frame.tailleEcran[1] ) ;
		g.setFont( new Font( "arial" , Font.PLAIN , Frame.tailleTexte ) ) ;
		Graphics2D g2d = (Graphics2D)g ; // image gif ou png
		old = g2d.getTransform() ; // évite de faire les translate/rotate retour
		
		if ( Frame.restartEnCours == false )
		{
			if ( Frame.chargementEnCour == true ) 
			{
				g2d.translate( Frame.tailleEcran[0] - 20 , Frame.tailleEcran[1] - 20 ) ;
				g2d.rotate( turn ) ;
				g2d.drawImage( new ImageIcon( "Chargement en cours.gif" ).getImage() , -10 , -10 , 20 , 20 , null ) ;
				g2d.setTransform( old ) ; // permet de remettre les parametre par defaut de g2d ( translation et rotation )
			}
			switch ( Frame.zoneAffichage )
			{
				case 0 : // disclaimer
					g.setColor( new Color( 255 , 255 , 255 ) ) ;
					g.setFont( new Font( "arial" , Font.PLAIN , (int)(10*((double)(Frame.tailleEcran[0])/MenuOption.resolutionChoisie[0] + (double)(Frame.tailleEcran[1])/MenuOption.resolutionChoisie[1])) ) ) ; // police / gras & co / taille police
					g.drawString( Main.disclaimer1 , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( Main.disclaimer1 ))*0.5) , (int)(Frame.tailleEcran[1]*0.3) ) ; 
					g.drawString( Main.disclaimer2 , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( Main.disclaimer2 ))*0.5) , (int)(Frame.tailleEcran[1]*0.4) ) ; 
					g.drawString( Main.disclaimer3 , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( Main.disclaimer3 ))*0.5) , (int)(Frame.tailleEcran[1]*0.5) ) ; 
					g.drawString( Main.disclaimer4 , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( Main.disclaimer4 ))*0.5) , (int)(Frame.tailleEcran[1]*0.6) ) ; 
					g.drawString( Main.gratuit , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( Main.gratuit ))*0.5) , (int)(Frame.tailleEcran[1]*0.7) ) ; 
					g.drawString( "Appuyez sur entrer" , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( "Appuyez sur entrer" ))*0.95) , (int)(Frame.tailleEcran[1]*0.95) ) ; 
					g2d.translate( Frame.tailleEcran[0] - 20 , Frame.tailleEcran[1] - 20 ) ;
					g2d.rotate( test ) ;
					g2d.drawImage( new ImageIcon( "Chargement en cours.png" ).getImage() , -19 , -19 , 38 , 38 , null ) ;
					g2d.setTransform( old ) ; // permet de remettre les parametres par defaut de g2d ( translation et rotation )
					test += 0.01 ;
					break ;
				case 1 : // menu début
					g2d.drawImage( new ImageIcon( "Ecran début.png" ).getImage() , 0 , 0 , Frame.tailleEcran[0] , Frame.tailleEcran[1] , null ) ; // img / posX / posY / largeur / hauteur / null
					g.setColor( new Color( 200 , 0 , 0 ) );
					g.setFont( new Font( "arial" , Font.BOLD , (int)(Frame.tailleEcran[0]*66/MenuOption.resolutionChoisie[0] + Frame.tailleEcran[1]*66/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
					g.drawString( "LOL AVENTURE" , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( "LOL AVENTURE" ))*0.5) , (getFontMetrics( g.getFont() )).getAscent() ) ;
					g.setFont( new Font( "arial" , Font.BOLD , (int)(Frame.tailleEcran[0]*30/MenuOption.resolutionChoisie[0] + Frame.tailleEcran[1]*30/MenuOption.resolutionChoisie[1]) ) ) ;
					g.setColor( new Color( 0 , 0 , 100 , 140 ) ) ;
					g.fillRect( (int)(Frame.tailleEcran[0]*0.5 - (getFontMetrics( g.getFont() )).stringWidth( "Quitter" )) , Frame.tailleEcran[1] - (int)((getFontMetrics( g.getFont() )).getAscent()*5.75) , (int)((getFontMetrics( g.getFont() )).stringWidth( "Quitter" )*2) , (int)((getFontMetrics( g.getFont() )).getAscent()*4.75) ) ;
					g.setColor( new Color( 200 , 0 , 0 ) ) ;
					g.drawString( "Jouer" , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( "Jouer" ))*0.5) , Frame.tailleEcran[1] - (int)((getFontMetrics( g.getFont() )).getAscent()*4.5) ) ;
					g.drawString( "Option" , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( "Option" ))*0.5) , Frame.tailleEcran[1] - (int)((getFontMetrics( g.getFont() )).getAscent()*3) ) ;
					g.drawString( "Quitter" , (int)((Frame.tailleEcran[0] - (getFontMetrics( g.getFont() )).stringWidth( "Quitter" ))*0.5) , Frame.tailleEcran[1] - (int)((getFontMetrics( g.getFont() )).getAscent()*1.5) ) ;
					g2d.translate( (int)(Frame.tailleEcran[0]*0.5 - (getFontMetrics( g.getFont() )).stringWidth( "Quitter" )*0.5) - (int)(Frame.tailleEcran[0]*24/MenuOption.resolutionChoisie[0]) - (int)(Frame.tailleEcran[1]*24/MenuOption.resolutionChoisie[1]) , (int)(Frame.tailleEcran[1] - (getFontMetrics( g.getFont() )).getAscent()*posIconSelectionY) ) ;
					g2d.rotate( Math.PI*0.75 ) ;
					g2d.drawImage( new ImageIcon( "Ecran début icone selection.gif" ).getImage() , -(int)(Frame.tailleEcran[0]*15/MenuOption.resolutionChoisie[0]) -(int)(Frame.tailleEcran[1]*15/MenuOption.resolutionChoisie[1]) , -(int)(Frame.tailleEcran[0]*15/MenuOption.resolutionChoisie[0]) -(int)(Frame.tailleEcran[1]*15/MenuOption.resolutionChoisie[1]) , (int)(Frame.tailleEcran[0]*30/MenuOption.resolutionChoisie[0])+(int)(Frame.tailleEcran[1]*30/MenuOption.resolutionChoisie[1]) , (int)(Frame.tailleEcran[0]*30/MenuOption.resolutionChoisie[0])+(int)(Frame.tailleEcran[1]*30/MenuOption.resolutionChoisie[1]) , null ) ;
					g2d.setTransform( old ) ;
					break ;
				case 2 : // menu sel perso
					g2d.drawImage( new ImageIcon( "Selection perso Backgroung.png" ).getImage() , 0 , 0 , Frame.tailleEcran[0] , Frame.tailleEcran[1] , null ) ; // img / posX / posY / largeur / hauteur / null
					g2d.drawImage( new ImageIcon( "Selection perso liste perso.png" ).getImage() , 0 , (int)(Frame.tailleEcran[1]*Frame.posYselPerso) , Frame.tailleEcran[0] , Frame.tailleEcran[1]*5 , null ) ; // img / posX / posY / largeur / hauteur / null
					g2d.drawImage( new ImageIcon( "Selection perso barre de défilement.gif" ).getImage() , (int)(Frame.tailleEcran[0]*0.99) , (int)(Frame.tailleEcran[1]*Frame.posYselPersoBarreDefil) , (int)(Frame.tailleEcran[0]*0.01) , (int)(Frame.tailleEcran[1]*0.2) , null ) ; // img / posX / posY / largeur / hauteur / null
					g.setColor( new Color( 0 , 0 , 0 , 100 ) ) ;
					for ( int i = 0 ; i < 4 ; i++ ) // pas vraiment (du tout, c'est horrible même xd) optimisé en terme de calcul mais j'ai pas d'autre idée :)
					{
						if ( i == 3 && Frame.posYselPerso == -4 && Frame.colliderBox( (int)(0.0419*Frame.tailleEcran[0])+1 , (int)(0.7971*Frame.tailleEcran[1]) , (int)(Frame.tailleEcran[0]*0.0848) , (int)(Frame.tailleEcran[1]*0.128) , mousePos[0] , mousePos[1] ) == false )
						{
							g.fillRect( (int)(0.0419*Frame.tailleEcran[0])+1 , (int)(0.7971*Frame.tailleEcran[1]) , (int)(Frame.tailleEcran[0]*0.0848) , (int)(Frame.tailleEcran[1]*0.1286) ) ;
							//g.fillRect( (int)(40.0/955.0*Frame.tailleEcran[0])+1 , (int)((150.0/3150.0+3*787.0/3150.0)*Frame.tailleEcran[1]) , (int)(Frame.tailleEcran[0]*0.0848) , (int)(Frame.tailleEcran[1]*0.128) ) ;
						}
						else if ( i != 3 || Frame.posYselPerso !=-4 )
						{
							for ( int j = 0 ; j < 7 ; j++ )
							{
								if ( Frame.colliderBox( (int)((0.0419+j*0.139)*Frame.tailleEcran[0])+1 , (int)((0.0476+i*0.24984)*Frame.tailleEcran[1]) , (int)(Frame.tailleEcran[0]*0.0848) , (int)(Frame.tailleEcran[1]*0.1286) , mousePos[0] , mousePos[1] ) == false )
								{
									
									g.fillRect( (int)((0.0419+j*0.139)*Frame.tailleEcran[0])+1 , (int)((0.0476+i*0.24984)*Frame.tailleEcran[1]) , (int)(Frame.tailleEcran[0]*0.0848) , (int)(Frame.tailleEcran[1]*0.1286) ) ; // taille 1 perso/taille image , largeur image gimp : 955 , hauteur image gimp : 3150
									//g.fillRect( (int)((40.0/955.0+j*133.0/955.0)*Frame.tailleEcran[0]) , (int)((150.0/3150.0+i*787.0/3150.0)*Frame.tailleEcran[1]) , (int)(Frame.tailleEcran[0]*0.0848) , (int)(Frame.tailleEcran[1]*0.1286) ) ;
								}
							}
						}
					}
					break ;
			}
			
			
			if ( Frame.menuOptionAfficher == true )
			{
				g2d.drawImage( new ImageIcon( "Menu option fenêtre.png" ).getImage() , (int)(Frame.tailleEcran[0]*(0.5-418.45/MenuOption.resolutionChoisie[0])) , (int)(Frame.tailleEcran[1]*(0.5-330.125/MenuOption.resolutionChoisie[1])) , (int)(Frame.tailleEcran[0]*(837.9/MenuOption.resolutionChoisie[0])) , (int)(Frame.tailleEcran[1]*(660.25/MenuOption.resolutionChoisie[1])) , null ) ;
				//g2d.drawImage( new ImageIcon( "Menu option fenêtre.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5-882*0.95*Frame.tailleEcran[0]/(MenuOption.resolutionChoisie[0]*2)) , (int)(Frame.tailleEcran[1]*0.5-695*0.95*Frame.tailleEcran[1]/(MenuOption.resolutionChoisie[1]*2)) , (int)(882*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(695*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
				if ( MenuOption.changement == true )
				{
					g2d.drawImage( new ImageIcon( "Menu option ok highlight.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5+101.65*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5+278.825*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(142.5*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(36.1*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
					//g2d.drawImage( new ImageIcon( "Menu option ok highlight.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5-(882/2-548)*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-641)*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(150*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]), (int)(38*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
				}
				else
				{
					g2d.drawImage( new ImageIcon( "Menu option ok non highlight.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5+101.65*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5+278.825*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(142.5*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(36.1*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
				}
				
				if ( MenuOption.typeMenu[1] != -1 )
				{
					g2d.drawImage( new ImageIcon( "Menu option menus principaux non highlight.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5-409.45*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-38*MenuOption.typeMenu[1])*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(162.45*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(38.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
					//g2d.drawImage( new ImageIcon( "Menu option menus principaux non highlight.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5-882*0.95*Frame.tailleEcran[0]/(MenuOption.resolutionChoisie[0]*2) , (int)(Frame.tailleEcran[1]*0.5-695*0.95*Frame.tailleEcran[1]/(MenuOption.resolutionChoisie[1]*2)+(95-17+40*MenuOption.typeMenu[1])*Frame.tailleEcran[1]*0.95/MenuOption.resolutionChoisie[1]) , (int)(171*Frame.tailleEcran[0]*0.95/MenuOption.resolutionChoisie[0]) , (int)(41*Frame.tailleEcran[1]*0.95/MenuOption.resolutionChoisie[1]) , null ) ;
				}
				g2d.drawImage( new ImageIcon( "Menu option menus principaux highlight.png" ).getImage() , (int)(Frame.tailleEcran[0]*0.5-409.45*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-38*MenuOption.typeMenu[0])*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(162.45*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(38.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
				
				switch ( MenuOption.typeMenu[0] ) // 0 : raccourcis , 1 : vidéo , 2 : son
				{
					case 0 :
						MenuOption.hauteurTitrePartie = MenuOptionTitreParties( MenuOption.raccourcisAttaque[0] , (int)(Frame.tailleEcran[1]*0.5-187.625*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , "Actions" , g , g2d ) ;
						MenuOption.raccourcisAttaqueNom[0] = menuOptionRaccourcis( MenuOption.raccourcisAttaque[0] , MenuOption.raccourcisAttaque[1] , MenuOption.raccourcisAttaque[2] , MenuOption.raccourcisAttaque[3] , MenuOption.raccourcisAttaqueNom[0] , MenuOption.raccourcisAttaqueNom[1] , g , g2d ) ;
						MenuOptionTitreParties( MenuOption.raccourcisAttaque[0] , (int)(MenuOption.hauteurTitrePartie + MenuOption.raccourcisAttaque[1] + (95+5)*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , "Déplacement" , g , g2d ) ;
						MenuOption.raccourcisGaucheNom[0] = menuOptionRaccourcis( MenuOption.raccourcisGauche[0] , MenuOption.raccourcisGauche[1] , MenuOption.raccourcisGauche[2] , MenuOption.raccourcisGauche[3] , MenuOption.raccourcisGaucheNom[0] , MenuOption.raccourcisGaucheNom[1] , g , g2d ) ;
						MenuOption.raccourcisHautNom[0] = menuOptionRaccourcis( MenuOption.raccourcisHaut[0] , MenuOption.raccourcisHaut[1] , MenuOption.raccourcisHaut[2] , MenuOption.raccourcisHaut[3] , MenuOption.raccourcisHautNom[0] , MenuOption.raccourcisHautNom[1] , g , g2d ) ;
						MenuOption.raccourcisDroiteNom[0] = menuOptionRaccourcis( MenuOption.raccourcisDroite[0] , MenuOption.raccourcisDroite[1] , MenuOption.raccourcisDroite[2] , MenuOption.raccourcisDroite[3] , MenuOption.raccourcisDroiteNom[0] , MenuOption.raccourcisDroiteNom[1] , g , g2d ) ;
						MenuOption.raccourcisBasNom[0] = menuOptionRaccourcis( MenuOption.raccourcisBas[0] , MenuOption.raccourcisBas[1] , MenuOption.raccourcisBas[2] , MenuOption.raccourcisBas[3] , MenuOption.raccourcisBasNom[0] , MenuOption.raccourcisBasNom[1] , g , g2d ) ;
						
						if ( Frame.inputModifEnCours == true ) // obligé de le faire ici pour éviter que les images se superpose pas comme prévu
						{
							g.setColor( new Color( 150 , 150 , 150 ) );
							g2d.drawImage( new ImageIcon( "Menu option raccourcis change input.png" ).getImage() , (int)((Frame.tailleEcran[0] - 538.65*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0])*0.5) , (int)((Frame.tailleEcran[1] - 246.05*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1])*0.5) , (int)(538.65*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(246.05*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
							//g2d.drawImage( new ImageIcon( "Menu option raccourcis change input.png" ).getImage() , (int)((Frame.tailleEcran[0] - 567*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0])*0.5) , (int)((Frame.tailleEcran[1] - 259*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1])*0.5) , (int)(567*0.95Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(259*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
							g.setFont( new Font( "arial" , Font.PLAIN , (int)(21*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+21*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
							g.drawString( Frame.inputModifNom , (int)((Frame.tailleEcran[0] - (g.getFontMetrics( g.getFont() )).stringWidth( Frame.inputModifNom ))*0.5) , (int)((Frame.tailleEcran[1] - (int)(246.05*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]))*0.5) + (int)(123.5*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
							//g.drawString( Frame.inputModifNom , (int)((Frame.tailleEcran[0] - (g.getFontMetrics( g.getFont() )).stringWidth( Frame.inputModifNom ))*0.5) , (int)((Frame.tailleEcran[1] - (int)(259*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1])*0.5)) + (int)((139-9)*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						}
						g.setColor( new Color( 69 , 141 , 126 ) );
						g.setFont( new Font( "arial" , Font.BOLD , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
						g.drawString( "VIDÉO" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-191.425*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						//g.drawString( "VIDÉO" , (int)(Frame.tailleEcran[0]*0.5-(882/2-28)*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-106-40*1)*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						g.drawString( "SON" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-153.425*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						//g.drawString( "VIDÉO" , (int)(Frame.tailleEcran[0]*0.5-(882/2-28)*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-106-40*2)*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						g.setColor( new Color( 176 , 240 , 217 ) );
						g.drawString( "RACCOURCIS" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-229.425*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						//g.drawString( "VIDÉO" , (int)(Frame.tailleEcran[0]*0.5-(882/2-28)*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(695/2-106)*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						break ;
					case 1 :
						menuOptionChoixMultiple( MenuOption.choixMultiplesFullscreen[0] , MenuOption.choixMultiplesFullscreen[1] , MenuOption.choixMultiplesFullscreen[2] , MenuOption.choixMultiplesFullscreen[3] , MenuOption.choixMultiplesFullscreen[4] , MenuOption.choixMultiplesFullscreenNomChoix.length , g2d , g , MenuOption.choixMultiplesFullscreenNomChoix ) ;
						menuOptionChoixMultiple( MenuOption.choixMultiplesResolutions[0] , MenuOption.choixMultiplesResolutions[1] , MenuOption.choixMultiplesResolutions[2] , MenuOption.choixMultiplesResolutions[3] , MenuOption.choixMultiplesResolutions[4] , MenuOption.choixMultiplesResolutionsNomChoix.length , g2d , g , MenuOption.choixMultiplesResolutionsNomChoix ) ;
						g.setColor( new Color( 69 , 141 , 126 ) );
						g.setFont( new Font( "arial" , Font.BOLD , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
						g.drawString( "RACCOURCIS" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-26.6)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						g.drawString( "SON" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-38*2-26.6)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						g.setColor( new Color( 176 , 240 , 217 ) );
						g.drawString( "VIDÉO" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-38*1-26.6)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						break ;
					case 2 :
						MenuOption.caseCocherMute[2] = menuOptionCaseCocher( MenuOption.caseCocherMute[0] , MenuOption.caseCocherMute[1] , MenuOption.caseCocherMute[3] , MenuOption.caseCocherNomChoix , g , g2d ) ;
						menuOptionSlider( MenuOption.sliderMusique[0] , MenuOption.sliderMusique[1] , MenuOption.sliderMusique[2] , g2d , g , MenuOption.sliderMusiqueNom , MenuOption.sliderMusique[3] ) ;
						menuOptionSlider( MenuOption.sliderBruitage[0] , MenuOption.sliderBruitage[1] , MenuOption.sliderBruitage[2] , g2d , g , MenuOption.sliderBruitageNom , MenuOption.sliderBruitage[3] ) ;
						g.setColor( new Color( 69 , 141 , 126 ) );
						g.setFont( new Font( "arial" , Font.BOLD , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
						g.drawString( "RACCOURCIS" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-26.6)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						g.drawString( "VIDÉO" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-38*1-26.6)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						g.setColor( new Color( 176 , 240 , 217 ) );
						g.drawString( "SON" , (int)(Frame.tailleEcran[0]*0.5-392.35*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(Frame.tailleEcran[1]*0.5-(256.025-38*2-26.6)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ;
						break ;
				}
			}
			
			Toolkit tk = Toolkit.getDefaultToolkit() ;
			Image img = tk.getImage( "Default mouse.gif" ) ;
			Cursor monCurseur = tk.createCustomCursor( img , new Point( 0 , 0 ) , "Default mouse.gif" ) ;
			setCursor( monCurseur ) ;
				
			if ( Frame.inbox == true )
			{
				
			}
			else
			{
				// créer l'intéraction
			}
		}
	}
	
	public static void menuOptionChoixMultiple( int posX , int posY , int caseChoisie , int caseNonChoisie , int ouvert , int nbChoix , Graphics2D g2D , Graphics G , String[] motAfficher )
	{
		g2D.drawImage( new ImageIcon( "Menu option case choisie choix multiple.png" ).getImage() , posX , posY , (int)(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(26.6*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		//g2D.drawImage( new ImageIcon( "Menu option case choisie choix multiple.png" ).getImage() , posX , posY , (int)(220*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(28*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		G.setColor( new Color( 150 , 150 , 150 ) );
		G.setFont( new Font( "arial" , Font.BOLD , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
		G.drawString( motAfficher[caseChoisie] , (int)(posX+(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] - (G.getFontMetrics( G.getFont() )).stringWidth( motAfficher[caseChoisie] ))*0.5) , posY+(int)((G.getFontMetrics( G.getFont() )).getAscent()*1.25) ) ;
		if ( ouvert == 1 )
		{
			g2D.drawImage( new ImageIcon( "Menu option case non choisie non fin choix multiple.png" ).getImage() , posX , posY+(int)(26.6*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)((25.65*(nbChoix-1)+10)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			//g2D.drawImage( new ImageIcon( "Menu option case non choisie non fin choix multiple.png" ).getImage() , posX , posY+(int)(28*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(220*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)((27*0.95*(nbChoix-1)+10/*+5 pour laisser un vide en haut et +5 pour éviter un bug graphique*/)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			g2D.drawImage( new ImageIcon( "Menu option case non choisie fin choix multiple.png" ).getImage() , posX , posY+(int)((26.6+25.65*(nbChoix-1)+3)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(27.55*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			//g2D.drawImage( new ImageIcon( "Menu option case non choisie fin choix multiple.png" ).getImage() , posX , posY+(int)(((28+27*)0.95*(nbChoix-1)+3/*+3 pour laisser un vide en haut*/)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(220*0.95*Frame.tailleEcran[0]/1200) , (int)(29*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			if ( caseNonChoisie != -1 )
			{
				g2D.drawImage( new ImageIcon( "Menu option case choisie choix multiple highlight non fixe.png" ).getImage() , posX , posY+(int)((26.6+25.65*caseNonChoisie+3)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(25.65*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
				//g2D.drawImage( new ImageIcon( "Menu option case choisie choix multiple highlight non fixe.png" ).getImage() , posX , posY+(int)(((28+27*caseNonChoissie)*0.95+3)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(220*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(27*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			}
			g2D.drawImage( new ImageIcon( "Menu option case choisie choix multiple highlight fixe.png" ).getImage() , posX , posY+(int)((26.6+25.65*caseChoisie+3)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(25.65*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			//g2D.drawImage( new ImageIcon( "Menu option case choisie choix multiple highlight fixe.png" ).getImage() , posX , posY+(int)(((28+27*caseChoisie)*0.95+3)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , (int)(220*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(27*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			G.setColor( new Color( 150 , 150 , 150 ) );
			G.setFont( new Font( "arial" , Font.PLAIN , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
			for ( int j = 0 ; j < nbChoix ; j++ )
			{
				G.drawString( motAfficher[j] , (int)(posX+(209*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] - (G.getFontMetrics( G.getFont() )).stringWidth( motAfficher[j] ))*0.5) , posY+(int)((26.6+25.65*j+3)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1])+(int)((G.getFontMetrics( G.getFont() )).getAscent()*1.25) ) ;
			}
		}
	}
	
	public static void menuOptionSlider( int posX , int posY , int posXCurseur , Graphics2D g2D , Graphics G , String sliderNom , int valeurCurseur )
	{
		g2D.drawImage( new ImageIcon( "Menu option slider.png" ).getImage() , posX , posY , (int)(478.8*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(18.05*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		//g2D.drawImage( new ImageIcon( "Menu option slider.png" ).getImage() , posX , posY , (int)(504*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(19*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		g2D.drawImage( new ImageIcon( "Menu option curseur du slider.png" ).getImage() , posXCurseur , posY , (int)(16.15*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(18.05*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		//g2D.drawImage( new ImageIcon( "Menu option curseur du slider.png" ).getImage() , posXCurseur , posY , (int)(17*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(19*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		G.setColor( new Color( 115 , 106 , 67 ) );
		G.setFont( new Font( "arial" , Font.BOLD , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
		G.drawString( sliderNom , posX , posY - (int)((G.getFontMetrics( G.getFont() )).getAscent()) ) ;
		G.setColor( new Color( 200 , 185 , 128 ) );
		G.drawString( Integer.toString(valeurCurseur) , (int)(posX + 478.8*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] - (G.getFontMetrics( G.getFont() )).stringWidth( Integer.toString(valeurCurseur) ) ) , posY - (int)((G.getFontMetrics( G.getFont() )).getAscent()) ) ;
		MenuOption.sliderHauteurTexte = (int)((G.getFontMetrics( G.getFont() )).getAscent()) ; // évite que le texte chevauche le slider du dessus avec une valeur fixe
	}
	
	public static int menuOptionCaseCocher( int posX , int posY , int cocher , String motAfficher , Graphics G , Graphics2D g2D )
	{
		if ( cocher == 1 )
		{
			g2D.drawImage( new ImageIcon( "Menu option case cocher.png" ).getImage() , posX , posY , (int)(16.15*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(16.15*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		}
		else
		{
			g2D.drawImage( new ImageIcon( "Menu option case non cocher.png" ).getImage() , posX , posY , (int)(16.15*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(16.15*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		}
		G.setColor( new Color( 150 , 150 , 150 ) );
		G.setFont( new Font( "arial" , Font.BOLD , (int)(9*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+9*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
		G.drawString( motAfficher , (int)(posX+23.75*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , posY+(int)((G.getFontMetrics( G.getFont() )).getAscent()*0.9) ) ;
		// G.drawString( motAfficher , (int)(posX+25*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , posY+(int)((G.getFontMetrics( G.getFont() )).getAscent()*0.9) ) ;
		return G.getFontMetrics( G.getFont() ).stringWidth( motAfficher ) ;
	}
	
	public static String menuOptionRaccourcis( int posX , int posY , int rapide , int modif , String input , String nomModif , Graphics G , Graphics2D g2D )
	{
		int ajustePolice = 0 ;
		if ( modif == 1 && Frame.kli.inputModifNom != "" )
		{ // fait ici car plusieurs type de variables sont a retournée
			input = Frame.kli.inputModifNom ;
			Frame.inputModifNomEnCours = false ;
		}
		if ( rapide == 1 )
		{
			g2D.drawImage( new ImageIcon( "Menu option raccourcis rapide.png" ).getImage() , posX, posY , (int)(62.7*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(90.25*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
			//g2D.drawImage( new ImageIcon( "Menu option raccourcis rapide.png" ).getImage() , posX, posY , 66*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] , 95*0.95*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1] , null ) ;
		}
		else
		{
			g2D.drawImage( new ImageIcon( "Menu option raccourcis non rapide.png" ).getImage() , posX , posY , (int)(62.7*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]) , (int)(90.25*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) , null ) ;
		}
		
		G.setColor( new Color( 150 , 150 , 150 ) );
		G.setFont( new Font( "arial" , Font.BOLD , (int)(21*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+21*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
		while ( (G.getFontMetrics( G.getFont() )).stringWidth( input ) > 57*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] ) // évite de sortir de l'encardrer
		{
			ajustePolice ++ ;
			G.setFont( new Font( "arial" , Font.BOLD , (int)(21*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+21*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1] - ajustePolice) ) ) ; // police / gras & co / taille police
		}
		G.drawString( input , (int)(posX+(62.7*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] - (G.getFontMetrics( G.getFont() )).stringWidth( input ))*0.5) , posY+(int)(38*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]+(G.getFontMetrics( G.getFont() )).getAscent()*0.5) ) ;
		//G.drawString( input , (int)(posX+(66*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] - (G.getFontMetrics( G.getFont() )).stringWidth( input ))*0.5) , posY+(int)((15+46/2)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]+(G.getFontMetrics( G.getFont() )).getAscent()*0.5) ) ;
		if ( modif == 1 ) 
		{
			Frame.inputModifNom = nomModif ;
		} // else non nécéssaire car aucun affichage n'est fait avec modif = 0
		return input ;
	}
	
	public static int MenuOptionTitreParties( int posX , int posY , String titre , Graphics G , Graphics2D g2D )
	{
		G.setColor( new Color( 150 , 150 , 150 ) );
		G.setFont( new Font( "arial" , Font.BOLD , (int)(10*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0]+20*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]) ) ) ; // police / gras & co / taille police
		G.drawString( titre , posX , posY+(G.getFontMetrics( G.getFont() )).getAscent() ) ;
		//G.drawString( titre , (int)(posX+(66*0.95*Frame.tailleEcran[0]/MenuOption.resolutionChoisie[0] - (G.getFontMetrics( G.getFont() )).stringWidth( titre ))*0.5) , posY+(int)((15+46/2)*Frame.tailleEcran[1]/MenuOption.resolutionChoisie[1]+(G.getFontMetrics( G.getFont() )).getAscent()*0.5) ) ;
		return (G.getFontMetrics( G.getFont() )).getAscent() ;
	}
			
}
