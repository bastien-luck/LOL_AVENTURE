package jeu;

public class TimerThread extends Thread
{
	
	public static int millisec = 0 ;
	
	public void run()
	{
		while ( true )
		{
			try 
			{
				Thread.sleep(1) ;
			} catch (InterruptedException e) {e.printStackTrace();}
			millisec ++ ;
		}
		
	}
	
	
}
