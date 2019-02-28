package jeu ;


public class GraphicsThread extends Thread
{
	public void run()
	{
		while ( true )
		{
			Frame.panel.repaint();
			if ( Frame.menuOptionAfficher == true )
			{
				Frame.panelScrolling.repaint();
			}
		}
	}
	
}
