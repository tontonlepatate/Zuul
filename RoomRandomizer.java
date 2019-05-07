import java.util.Random;

/**
 * Décrivez votre classe RoomRandomizer ici.
 *
 * @author (votre nom)
 * @version (un numéro de version ou une date)
 */
public class RoomRandomizer
{
    
    private GameEngine aGameEngine;
    private Room[] aTab;
    
    public RoomRandomizer()
    {
        this.aGameEngine = new GameEngine();
        this.aTab = this.aGameEngine.getTab();
    }
    
    public Room findRandomRoom()
    {
        Random vRandomizer = new Random();
        int vNumber = vRandomizer.nextInt(4);
        return this.aTab[vNumber];
    }
}
