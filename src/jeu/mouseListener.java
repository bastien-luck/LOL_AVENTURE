package jeu ;

import java.awt.event.MouseEvent ;
import java.awt.event.MouseListener ;

public class mouseListener implements MouseListener
{
	public boolean leftClick ;
	public boolean middleClick ;
	public boolean rightClick ;
	public void mouseClicked(MouseEvent arg0) 
	{
				
	}

	public void mouseEntered(MouseEvent arg0) 
	{
				
	}

	public void mouseExited(MouseEvent arg0) 
	{
				
	}

	public void mousePressed(MouseEvent arg0) 
	{
		if ( arg0.getButton() == 1 )
		{
			leftClick = true ;
		}
		if ( arg0.getButton() == 2 )
		{
			middleClick = true ;
		}
		if (arg0.getButton() == 3 )
		{
			rightClick = true ;
		}
	}

	public void mouseReleased(MouseEvent arg0) 
	{
		if ( arg0.getButton() == 1 )
		{
			leftClick = false ;
		}
		if ( arg0.getButton() == 2 )
		{
			middleClick = false ;
		}
		if (arg0.getButton() == 3 )
		{
			rightClick = false ;
		}
	}
}
