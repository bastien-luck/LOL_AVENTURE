package jeu ;

import java.awt.event.KeyEvent ;
import java.awt.event.KeyListener ;

public class keyListener implements KeyListener // méthode pratique pour les jeux avec avancement continu ( attention pour les menus ! )
{ // permet aussi les multiples inputs
	public boolean uAccentGrave = false ; // ù et ²
	public boolean retourArr = false ;
	public boolean entrer = false ;
	public boolean maj = false ;
	public boolean ctrl = false ;
	public boolean alt = false ;
	public boolean verrMaj = false ;
	public boolean echap = false ;
	public boolean espace = false ;
	public boolean pgPrec = false ;
	public boolean pgSuiv = false ;
	public boolean keyFin = false ;
	public boolean orig = false ;
	public boolean gauche = false ;
	public boolean haut = false ;
	public boolean droite = false ;
	public boolean bas = false ;
	public boolean virgule = false ;
	public boolean num0 = false ;
	public boolean num1 = false ;
	public boolean num2 = false ;
	public boolean num3 = false ;
	public boolean num4 = false ;
	public boolean num5 = false ;
	public boolean num6 = false ;
	public boolean num7 = false ;
	public boolean num8 = false ;
	public boolean num9 = false ;
	public boolean pointVirgule = false ;
	public boolean egal = false ;
	public boolean a = false ;
	public boolean b = false ;
	public boolean c = false ;
	public boolean d = false ;
	public boolean e = false ;
	public boolean f = false ;
	public boolean g = false ;
	public boolean h = false ;
	public boolean i = false ;
	public boolean j = false ;
	public boolean k = false ;
	public boolean l = false ;
	public boolean m = false ;
	public boolean n = false ;
	public boolean o = false ;
	public boolean p = false ;
	public boolean q = false ;
	public boolean r = false ;
	public boolean s = false ;
	public boolean t = false ;
	public boolean u = false ;
	public boolean v = false ;
	public boolean w = false ;
	public boolean x = false ;
	public boolean y = false ;
	public boolean z = false ;
	public boolean paveNum0 = false ;
	public boolean paveNum1 = false ;
	public boolean paveNum2 = false ;
	public boolean paveNum3 = false ;
	public boolean paveNum4 = false ;
	public boolean paveNum5 = false ;
	public boolean paveNum6 = false ;
	public boolean paveNum7 = false ;
	public boolean paveNum8 = false ;
	public boolean paveNum9 = false ;
	public boolean paveNumFois = false ;
	public boolean paveNumPlus = false ;
	public boolean paveNumMoins = false ;
	public boolean paveNumPoint = false ;
	public boolean paveNumDiviser = false ;
	public boolean F1 = false ;
	public boolean F2 = false ;
	public boolean F3 = false ;
	public boolean F4 = false ;
	public boolean F5 = false ;
	public boolean F6 = false ;
	public boolean F7 = false ;
	public boolean F8 = false ;
	public boolean F9 = false ;
	public boolean F10 = false ;
	public boolean suppr = false ;
	public boolean accentCirconflexe = false ;
	public boolean verrNum = false ;
	public boolean fois = false ;
	public boolean inser = false ;
	public boolean deuxPoints = false ;
	public boolean $ = false ;
	public boolean pointExclation = false ;
	public boolean symbolDegre = false ;
	
	public void keyPressed( KeyEvent arg0 ) 
	{
		switch ( arg0.getKeyCode() )
		{
			case 0 :
				uAccentGrave = true ;
				break ;
			case 8 :
				retourArr = true ;
				break ;
			case 10 :
				entrer = true ;
				break ;
			case 16 :
				maj = true ;
				break ;
			case 17 :
				ctrl = true ;
				break ;
			case 18 :
				alt = true ;
				break ;
			case 20 :
				verrMaj = true ;
				break ;
			case 27 :
				echap = true ;
				break ;
			case 32 :
				espace = true ;
				break ;
			case 33 :
				pgPrec = true ;
				break ;
			case 34 :
				pgSuiv = true ;
				break ;
			case 35 :
				keyFin = true ;
				break ;
			case 36 :
				orig = true ;
				break ;
			case 37 :
				gauche = true ;
				break ;
			case 38 :
				haut = true ;
				break ;
			case 39 :
				droite = true ;
				break ;
			case 40 :
				bas = true ;
				break ;
			case 44 :
				virgule = true ;
				break ;
			case 48 :
				num0 = true ;
				break ;
			case 49 :
				num1 = true ;
				break ;
			case 50 :
				num2 = true ;
				break ;
			case 51 :
				num3 = true ;
				break ;
			case 52 :
				num4 = true ;
				break ;
			case 53 :
				num5 = true ;
				break ;
			case 54 :
				num6 = true ;
				break ;
			case 55 :
				num7 = true ;
				break ;
			case 56 :
				num8 = true ;
				break ;
			case 57 :
				num9 = true ;
				break ;
			case 59 :
				pointVirgule = true ;
				break ;
			case 61 :
				egal = true ;
				break ;
			case 65 :
				a = true ;
				break ;
			case 66 :
				b = true ;
				break ;
			case 67 :
				c = true ;
				break ;
			case 68 :
				d = true ;
				break ;
			case 69 :
				e = true ;
				break ;
			case 70 :
				f = true ;
				break ;
			case 71 :
				g = true ;
				break ;
			case 72 :
				h = true ;
				break ;
			case 73 :
				i = true ;
				break ;
			case 74 :
				j = true ;
				break ;
			case 75 :
				k = true ;
				break ;
			case 76 :
				l = true ;
				break ;
			case 77 :
				m = true ;
				break ;
			case 78 :
				n = true ;
				break ;
			case 79 :
				o = true ;
				break ;
			case 80 :
				p = true ;
				break ;
			case 81 :
				q = true ;
				break ;
			case 82 :
				r = true ;
				break ;
			case 83 :
				s = true ;
				break ;
			case 84 :
				t = true ;
				break ;
			case 85 :
				u = true ;
				break ;
			case 86 :
				v = true ;
				break ;
			case 87 :
				w = true ;
				break ;
			case 88 :
				x = true ;
				break ;
			case 89 :
				y = true ;
				break ;
			case 90 :
				z = true ;
				break ;
			case 96 :
				paveNum0 = true ;
				break ;
			case 97 :
				paveNum1 = true ;
				break ;
			case 98 :
				paveNum2 = true ;
				break ;
			case 99 :
				paveNum3 = true ;
				break ;
			case 100 :
				paveNum4 = true ;
				break ;
			case 101 :
				paveNum5 = true ;
				break ;
			case 102 :
				paveNum6 = true ;
				break ;
			case 103 :
				paveNum7 = true ;
				break ;
			case 104 :
				paveNum8 = true ;
				break ;
			case 105 :
				paveNum9 = true ;
				break ;
			case 106 :
				paveNumFois = true ;
				break ;
			case 107 :
				paveNumPlus = true ;
				break ;
			case 109 :
				paveNumMoins = true ;
				break ;
			case 110 :
				paveNumPoint = true ;
				break ;
			case 111 :
				paveNumDiviser = true ;
				break ;
			case 112 :
				F1 = true ;
				break ;
			case 113 :
				F2 = true ;
				break ;
			case 114 :
				F3 = true ;
				break ;
			case 115 :
				F4 = true ;
				break ;
			case 116 :
				F5 = true ;
				break ;
			case 117 :
				F6 = true ;
				break ;
			case 118 :
				F7 = true ;
				break ;
			case 119 :
				F8 = true ;
				break ;
			case 120 :
				F9 = true ;
				break ;
			case 121 :
				F10 = true ;
				break ;	
			case 127 :
				suppr = true ;
				break ;
			case 130 :
				accentCirconflexe = true ;
				break ;
			case 144 :
				verrNum = true ;
				break ;
			case 151 :
				fois = true ;
				break ;
			case 155 :
				inser = false ;
				break ;
			case 513 :
				deuxPoints = true ;
				break ;
			case 515 :
				$ = true ;
				break ;
			case 517 :
				pointExclation = true ;
				break ;
			case 522 :
				symbolDegre = true ;
				break ;
		}
	}

	
	public void keyReleased(KeyEvent arg0) 
	{
		switch ( arg0.getKeyCode() )
		{
			case 0 :
				uAccentGrave = false ;
				break ;
			case 8 :
				retourArr = false ;
				break ;
			case 10 :
				entrer = false ;
				break ;
			case 16 :
				maj = false ;
				break ;
			case 17 :
				ctrl = false ;
				break ;
			case 18 :
				alt = false ;
				break ;
			case 20 :
				verrMaj = false ;
				break ;
			case 27 :
				echap = false ;
				break ;
			case 32 :
				espace = false ;
				break ;
			case 33 :
				pgPrec = false ;
				break ;
			case 34 :
				pgSuiv = false ;
				break ;
			case 35 :
				keyFin = false ;
				break ;
			case 36 :
				orig = false ;
				break ;
			case 37 :
				gauche = false ;
				break ;
			case 38 :
				haut = false ;
				break ;
			case 39 :
				droite = false ;
				break ;
			case 40 :
				bas = false ;
				break ;
			case 44 :
				virgule = false ;
				break ;
			case 48 :
				num0 = false ;
				break ;
			case 49 :
				num1 = false ;
				break ;
			case 50 :
				num2 = false ;
				break ;
			case 51 :
				num3 = false ;
				break ;
			case 52 :
				num4 = false ;
				break ;
			case 53 :
				num5 = false ;
				break ;
			case 54 :
				num6 = false ;
				break ;
			case 55 :
				num7 = false ;
				break ;
			case 56 :
				num8 = false ;
				break ;
			case 57 :
				num9 = false ;
				break ;
			case 59 :
				pointVirgule = false ;
				break ;
			case 61 :
				egal = false ;
				break ;
			case 65 :
				a = false ;
				break ;
			case 66 :
				b = false ;
				break ;
			case 67 :
				c = false ;
				break ;
			case 68 :
				d = false ;
				break ;
			case 69 :
				e = false ;
				break ;
			case 70 :
				f = false ;
				break ;
			case 71 :
				g = false ;
				break ;
			case 72 :
				h = false ;
				break ;
			case 73 :
				i = false ;
				break ;
			case 74 :
				j = false ;
				break ;
			case 75 :
				k = false ;
				break ;
			case 76 :
				l = false ;
				break ;
			case 77 :
				m = false ;
				break ;
			case 78 :
				n = false ;
				break ;
			case 79 :
				o = false ;
				break ;
			case 80 :
				p = false ;
				break ;
			case 81 :
				q = false ;
				break ;
			case 82 :
				r = false ;
				break ;
			case 83 :
				s = false ;
				break ;
			case 84 :
				t = false ;
				break ;
			case 85 :
				u = false ;
				break ;
			case 86 :
				v = false ;
				break ;
			case 87 :
				w = false ;
				break ;
			case 88 :
				x = false ;
				break ;
			case 89 :
				y = false ;
				break ;
			case 90 :
				z = false ;
				break ;
			case 96 :
				paveNum0 = false ;
				break ;
			case 97 :
				paveNum1 = false ;
				break ;
			case 98 :
				paveNum2 = false ;
				break ;
			case 99 :
				paveNum3 = false ;
				break ;
			case 100 :
				paveNum4 = false ;
				break ;
			case 101 :
				paveNum5 = false ;
				break ;
			case 102 :
				paveNum6 = false ;
				break ;
			case 103 :
				paveNum7 = false ;
				break ;
			case 104 :
				paveNum8 = false ;
				break ;
			case 105 :
				paveNum9 = false ;
				break ;
			case 106 :
				paveNumFois = false ;
				break ;
			case 107 :
				paveNumPlus = false ;
				break ;
			case 109 :
				paveNumMoins = false ;
				break ;
			case 110 :
				paveNumPoint = false ;
				break ;
			case 111 :
				paveNumDiviser = false ;
				break ;
			case 112 :
				F1 = false ;
				break ;
			case 113 :
				F2 = false ;
				break ;
			case 114 :
				F3 = false ;
				break ;
			case 115 :
				F4 = false ;
				break ;
			case 116 :
				F5 = false ;
				break ;
			case 117 :
				F6 = false ;
				break ;
			case 118 :
				F7 = false ;
				break ;
			case 119 :
				F8 = false ;
				break ;
			case 120 :
				F9 = false ;
				break ;
			case 121 :
				F10 = false ;
				break ;
			case 127 :
				suppr = false ;
				break ;
			case 130 :
				accentCirconflexe = false ;
				break ;
			case 144 :
				verrNum = false ;
				break ;
			case 151 :
				fois = false ;
				break ;
			case 155 :
				inser = false ;
				break ;
			case 513 :
				deuxPoints = false ;
				break ;
			case 515 :
				$ = false ;
				break ;
			case 517 :
				pointExclation = false ;
				break ;
			case 522 :
				symbolDegre = false ;
				break ;
		}
	}

	
	public void keyTyped(KeyEvent arg0)
	{
				
	}	
}
