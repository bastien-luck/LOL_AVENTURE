package jeu;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerInt implements KeyListener // permet de faire des modifications dans les raccourcis
{
	/*
	0 = ù et ²                   48 = &                     71 = g                89 = y                            113 = F2
	8 = retourArr                49 = é                     72 = h                90 = z                            114 = F3
	10 = entrer                  50 = "                     73 = i                96 = paveNum0                     115 = F4
	16 = maj                     51 = '                     74 = j                97 = paveNum1                     116 = F5
	17 = ctrl                    52 = (                     75 = k                98 = paveNum2                     117 = F6
	18 = alt                     53 = -                     76 = l                99 = paveNum3                     118 = F7
	20 = verrMaj                 54 = è                     77 = m                100 = paveNum4                    119 = F8
	27 = echap                   55 = _                     78 = n                101 = paveNum5                    120 = F9
	32 = espace                  56 = ç                     79 = o                102 = paveNum6                    121 = F10
	33 = pagePrec                57 = à                     80 = p                103 = paveNum7                    127 = suppr
	34 = pageSuiv                59 = ;                     81 = q                104 = paveNum8                    130 = ^
	35 = keyFin                  61 = =                     82 = r                105 = paveNum9                    144 = verrNum
	36 = orig                    65 = a                     83 = s                106 = paveNum*                    151 = *
	37 = gauche                  66 = b                     84 = t                107 = paveNum+                    155 = inser
	38 = haut                    67 = c                     85 = u                109 = paveNum-                    513 = :
	39 = droite                  68 = d                     86 = v                110 = paveNum.                    515 = $
	40 = bas                     69 = e                     87 = w                111 = paveNum/                    517 = !
	44 = virgule                 70 = f                     88 = x                112 = F1                          522 = )
	*/
	// action joueur :
	public int inputModif = -1 ; // il est rare d'appuyer sur une touche pendant que l'on clique sur un changement de raccourcis donc cette méthode marche
	public String inputModifNom = "" ;
	public int confirmer = 10 ;
	public int menuSystem = 27 ;
	public int gauche = 37 ;
	public int haut = 38 ;
	public int droite = 39 ;
	public int bas = 40 ;
	public int attaque = 65 ;
	
	
	@Override
	public void keyPressed(KeyEvent arg0) // améliorable surement mais je n'ai pas encore les compétances pour
	{
		if ( arg0.getKeyCode() == confirmer ) // else if impossible tant que les input doubles ne sont pas inversés
		{
			Frame.confirmerAction = true ;
		}
		if ( arg0.getKeyCode() == menuSystem )
		{
			Frame.menuSysteme = true ;
		}
		if ( arg0.getKeyCode() == gauche )
		{
			Frame.mouvementGauche = true ;
		}
		if ( arg0.getKeyCode() == haut )
		{
			Frame.mouvementHaut = true ;
		}
		if ( arg0.getKeyCode() == droite )
		{
			Frame.mouvementDroite = true ;
		}
		if ( arg0.getKeyCode() == bas )
		{
			Frame.mouvementBas = true ;
		}
		if ( arg0.getKeyCode() == attaque )
		{
			Frame.attaque = true ;
		}
		
		if ( Frame.inputModifEnCours == true )
		{
			inputModif = arg0.getKeyCode() ;
		}
		if ( Frame.inputModifNomEnCours == true )
		{
			if ( inputModif == 0 || ( 44 <= inputModif && inputModif <= 61) || inputModif == 151 || ( 513 <= inputModif && inputModif <= 522 ) )
			{
				inputModifNom = Character.toString(arg0.getKeyChar()) ;
			}
			else if ( 96 <= inputModif && inputModif <= 111 )
			{
				inputModifNom = "NumPad" + Character.toString(arg0.getKeyChar()) ;
			}
			else
			{
				inputModifNom = KeyEvent.getKeyText( arg0.getKeyCode() ) ;
			}
		}
	}

	@Override
	public void keyReleased(KeyEvent arg0) 
	{
		if ( arg0.getKeyCode() == gauche )
		{
			Frame.mouvementGauche = false ;
		}
		if ( arg0.getKeyCode() == haut )
		{
			Frame.mouvementHaut = false ;
		}
		if ( arg0.getKeyCode() == droite )
		{
			Frame.mouvementDroite = false ;
		}
		if ( arg0.getKeyCode() == bas )
		{
			Frame.mouvementBas = false ;
		}
		if ( arg0.getKeyCode() == menuSystem )
		{
			Frame.menuSysteme = false ;
		}
		if ( arg0.getKeyCode() == confirmer )
		{
			Frame.confirmerAction = false ;
		}
		if ( arg0.getKeyCode() == attaque )
		{
			Frame.attaque = false ;
		}
		if ( Frame.inputModifEnCours == false && inputModif != -1 )
		{
			inputModif = -1 ;
		}
		if ( Frame.inputModifNomEnCours == false && inputModifNom != "" )
		{
			inputModifNom = "" ;
		}
	}

	@Override
	public void keyTyped(KeyEvent arg0) 
	{
		
	}
	
	

}
