import java.util.Stack;
import java.util.HashMap;
import java.util.Set;

/**
 * 
 * Cette classe permet de gérer tout ce qui concerne le joueur
 * notamment les différents déplacements dans les Room.
 * @author Vadim Sitbon
 * @version 03.05.2019
 */
public class Player
 { 
    private String aName;
    private Room aCurrentRoom;
    private Stack<Room> aPreviousRooms;
    private ItemList aInvtPlayer;
    private double aCurrentNumber;
    /**
     * Default constructor for objects of class Player
     * @param pName nom
     */
    public Player(final String pName, final Room pCurrentRoom)
    {
        this.aName = pName;
        this.aCurrentRoom=pCurrentRoom;
        this.aPreviousRooms = new Stack<Room>();
        this.aCurrentNumber = 10.0;
        this.aInvtPlayer = new ItemList();
    } // Player()
    
    /**
     * Accesseur pour l'attribut aCurrentNumber
     * @return l'attribut ( sa valeur ) power
     */
    public double getPowa()
    {
       return this.aCurrentNumber;
    }
    
    /**
    * Permet de modifier la valeur de l'attribut CurrentNumber (charge max)
    */
    public void setPowa(final double pPowa){
       this.aCurrentNumber = pPowa;
    }
    
    /**
    *Permet de modifier la Room actuelle
    *@param pCurrentRoom  Room passée pour changer la Room actuelle
    */
    public void setCurrentRoom(final Room pCurrentRoom)
    {
       this.aCurrentRoom = pCurrentRoom;
    }
    
     /**
     * Gère de déplacement de Room du Player 
     * @param pNextRoom  pour acutaliser la valeur de la Room actuelle
     */
    public void changeRoom(final Room pNextRoom)
    {
       this.setPreviousRooms(this.aCurrentRoom);
       this.setCurrentRoom(pNextRoom);
    }
    
    public String getName()
    {
        return this.aName;
    }
    
    /**
    * Permet d'avoir la Room dans laquelle se trouve le joueur
    * @return La Room actuelle
    */
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
    /**
    *@param pNextRoom porochaine salles
    */
    public void setRoom(final Room pNextRoom)
    {
        this.aCurrentRoom = pNextRoom;
    }
    
    public Stack<Room> getPreviousRooms()
    {
        return this.aPreviousRooms;
    }
    
    public void avantBack()
    {
        this.aCurrentRoom = this.aPreviousRooms.pop();
    }
    
    /**
     * Permet d'ajouter sur la pile la dernière Room visitée.
     * @param pPreviousRoom  Room a ajouter sur la pile
     */
    public void setPreviousRooms(final Room pPreviousRooms)
    {
       this.aPreviousRooms.push(pPreviousRooms);
    }
    
     /**
     * Accesseur pour l'inventaire du joueur
     * @return l'inventaire su joueur
     */
    public ItemList getInventoryPlayer()
    {
       return this.aInvtPlayer;
    }
    
    /**
    * Permet de savoir si la Room d'avant exitse ou pas
    * ou si on est au début.
    * @return True si la la Room d'avant sur la pile est vide ou non
    */
    public boolean isPreviousRoomEmpty()
    {
       return this.aPreviousRooms.empty();
    }
    
    /**
     * Permet de vérifier si le poids de l'objet lui permet 
     * de rentrer dans l'inventaire du joueur ou pas
     * @return True si l'objet souhaité peut être ajouté dans l'inventaire
     */
    public boolean canTake(final Item pItem)
    {
       return ((this.aInvtPlayer.getTotalInventoryWeight()+ pItem.getWeight())>=this.aCurrentNumber);
    }
} // Player
