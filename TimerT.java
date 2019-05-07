import java.util.Timer;
import java.util.TimerTask;
/**
 * Décrivez votre classe Timer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class TimerT extends TimerTask
{
    
    private int aTim;
    private GameEngine aG;
    private Timer aTimer;
    
    /**
     * Constructeur d'objets de classe Timer
     */
    public TimerT()
    {
        this.aTim=500;
    }

    @Override public void run()
    {
        
    }
    /*
    
    public int sampleMethod(final GameEngine pNum, final Timer pTime)
    {
        this.aG =pNum;
        this.aTimer =pTime;
    } 
    
    @Override public void run()
    {
        this.aTim-=1;
        this.aG.updateTime(this.aTim);
        if(this.aTim == 0)
        {
            this.aTimer.cancel();
            this.aG.gameOver();
        }
        
    }*/
}
