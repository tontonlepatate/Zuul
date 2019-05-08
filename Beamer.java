
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
     * Renvoie la Room enregistrée
     * @return la Room enregistrée
     */
    public Room getBeamerCharged(){
        return this.aBeamerCha;
    }
    
    /**
     * Permet de charger le beamer avec la Room voulue.
     * @param pRoom Room salle sue l'on veut enregistrer
     */
    public void setBeamerCharged(final Room pRoom){
        this.aBeamerCha=pRoom;
    }
}