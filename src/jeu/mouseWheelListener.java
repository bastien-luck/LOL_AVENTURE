package jeu;

import java.awt.event.MouseWheelEvent;
import java.awt.event.MouseWheelListener;

public class mouseWheelListener implements MouseWheelListener 
{
	public int mouseRotation ;
	public int mwCompteur = 0 ;
	
	public void mouseWheelMoved(MouseWheelEvent arg0) 
	{
		
		mouseRotation = arg0.getWheelRotation() ;
		mwCompteur ++ ; // permet de scrollé un menu rapidement sans être limité par la framerate
		
	} // bas 1 / haut -1

}
