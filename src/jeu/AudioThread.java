package jeu ;

import java.io.File ;
import java.io.IOException ;
 
import javax.sound.sampled.* ;

public class AudioThread extends Thread implements Runnable 
{
    static String path = "" ;
    static boolean isSet = false ;
    static boolean stopSon = false ;
    static float pan ;
    static float vol ;
    public boolean IsFinish = false ;
 
    public AudioThread( String pPath , float pan1 , float vol1 , boolean muted )
    {
        path = pPath ;
        isSet = true ;
        stopSon = muted ;
        pan = pan1 ;
        vol = vol1 ;
    }
       
    public void run() 
    {
    	int buffer = TimerThread.millisec ;
        if( isSet )
        {
            SourceDataLine line ;
            File file ;
            AudioInputStream audioInputStream ;
            AudioFormat audioFormat ;
            file = new File( path ) ;
            try 
            {
            	audioInputStream = AudioSystem.getAudioInputStream( file ) ;
            } catch (UnsupportedAudioFileException | IOException e){e.printStackTrace();return;}
            audioFormat = audioInputStream.getFormat() ;
            DataLine.Info info = new DataLine.Info( SourceDataLine.class , audioFormat ) ;
            try 
            {
               	line = (SourceDataLine) AudioSystem.getLine( info ) ;
            } catch (LineUnavailableException e){e.printStackTrace();return;}
            try 
            {
               	line = ( SourceDataLine ) AudioSystem.getLine( info ) ;
                line.open( audioFormat ) ;
            } catch (LineUnavailableException e1){e1.printStackTrace();return;}
            line.start();
            if ( line.isControlSupported( FloatControl.Type.MASTER_GAIN ) )
            {
            	FloatControl volume = (FloatControl)line.getControl( FloatControl.Type.MASTER_GAIN ) ;
            
	            if ( line.isControlSupported( FloatControl.Type.PAN ) )
	            {
	            	FloatControl stereo = (FloatControl)line.getControl( FloatControl.Type.PAN ) ;
		            stereo.setValue( pan ) ;// entre -1 et 1
		            if ( stopSon != true && MenuOption.sliderMusique[3] != 0 )
		            {
		            	volume.setValue( vol ) ;// entre -80 et 6
		            	try 
			            {
			                byte bytes[] = new byte[10];
			                int bytesRead = 0;
			                while( ( bytesRead = audioInputStream.read(bytes , 0 , bytes.length ) ) != -1 )
			                {
			                	if ( volume.getValue() != MenuOption.sliderMusique[4] )
					            {
					            	volume.setValue( MenuOption.sliderMusique[4] ) ;
					            }
			                    line.write(bytes, 0, bytesRead);
			                }
			            } catch (IOException e){e.printStackTrace();return;}
		            }
		            line.drain() ;
		            line.stop() ;
		            line.close() ;
		            IsFinish = true ;
	            }
            }
        }
        if ( ( TimerThread.millisec - buffer ) < Frame.framerate )
		{
			try 
			{
				Thread.sleep( Frame.framerate - ( TimerThread.millisec - buffer ) ) ;
			} catch (InterruptedException e) {e.printStackTrace();}
		}
    }
}