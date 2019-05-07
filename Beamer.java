
/**
 * 
 * 
 * @author Vadim Sitbon
 * @version 06.05.2019
 */
public class Beamer extends Item
{
    private Room aBeamerCha;

    /**
     * Constructor for objects of class Beamer
     */
    public Beamer(final String pNam, final String pDescription, final double pWeight,final Room pBeamerCha)
    {
        super(pNam,pWeight,pDescription);
        
        this.aBeamerCha=pBeamerCha;
    }
    
    /**
     * Renvoie la Room sauvegardée par le joueur.
     * @return la Room sauvegardée dans le beamer.
     */
    public Room getBeamerCharged(){
        return this.aBeamerCha;
    }
    
    /**
     * Permet de charger le beamer avec la Room voulue.
     * @param pRoom Room que l'on souhaite sauvegarder dans le beamer.
     */
    public void setBeamerCharged(final Room pRoom){
        this.aBeamerCha=pRoom;
    }
}