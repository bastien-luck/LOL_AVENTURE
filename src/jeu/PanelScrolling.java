package jeu;

import java.awt.* ;
import java.awt.geom.AffineTransform ;
import javax.swing.JPanel ;

import jeu.Frame;

public class PanelScrolling extends JPanel
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public static AffineTransform oldScrolling = new AffineTransform() ;
	
	public void paintComponent( Graphics g ) // r�glages effectu�s par rapport � une r�solution 1200*700
	{
		Frame.panelScrolling.setOpaque( false ) ;
		g.setColor( new Color( 100 , 100 , 100 ) ) ;
		g.fillRect( 0 , 0 , Frame.tailleEcran[0] , Frame.tailleEcran[1] ) ;
		g.setFont( new Font( "arial" , Font.PLAIN , Frame.tailleTexte ) ) ;
		Graphics2D g2d = (Graphics2D)g ; // image gif ou png
		oldScrolling = g2d.getTransform() ; // �vite de faire les translate/rotate retour
	}
}
