import java.util.Random;

/**
 * Cette classe permet de selectionner des salles de manière aléatoire
 * @author Vadim Sitbon
 * @version 08.05.2019
 * @param direction ignored
 * @return A random room
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
    
    /**
     * @return Room retourne une salle aléatoire
     */
    public Room findRandomRoom()
    {
        Random vRandomizer = new Random();
        int vNumber = vRandomizer.nextInt(4);
        return this.aTab[vNumber];
    }
}
