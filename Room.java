import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Room
{    
    private String aDescription;
    private HashMap<String,Room> aExits;
    private String imageName;
    private ItemList aItems;
    public HashMap<String,Item> aItm;

    /**
     * créée une salle (Room).
     */
    public Room(final String pDescription,final String pImage)
    {
        this.aDescription=pDescription; 
        aExits = new HashMap<String, Room>();
        imageName = pImage;
        aItems = new ItemList();
        aItm = new HashMap<String, Item>();
    }

    /**
     * créé les Item.
     */
    public void setExit (final String pDirection,final Room pNeighbor)
    {
        aExits.put(pDirection,pNeighbor);
    }

    /**
     * @return Room renvoie les sorties d'une salle
     * @param pDirection correspond au direction des sorties
     * créé les Item.
     */
    public Room getExit(final String pDirection) 
    {
        return aExits.get(pDirection);
    }

    /**
     * @return String renvoie la pièce dans la qeulle nous sommes si l'on se déplace 
     * dans la direction "pDirection" .S'il n'y a  pas de pièce
     * dans la diretion suivie renvoie null.
     */
    public String getExitString()
    {
        String returnString = "Sorties:";
        Set<String> keys = aExits.keySet();
        for(String exit : keys)
        {
            returnString +=" "+exit;
        }
        return returnString;
    }
    
    /**
     * @return String retourne la string d'un iTem
     */
    public String getItemString()
    {
        String vS = ""; 
        for(String items : aItm.keySet())
        {
            vS +=" "+items;
        }
        return vS;
    }

    /**
     * créé les Item.
     */
    public String getLongDescription()
    {
        return"You are in " + this.aDescription + ".\n" +this.getExitString()+".\n"+"In the room there is :"+ this.getItemString()+this.aItems.getInventoryPlayerString();
    }

    /**
     * renvoie le nom des images.
     */
    public String getImageName()
    {
        return imageName;
    }
    
    /**
     * @param pNom correspond au nom de l'item
     * @param pItem correspond a l'item en question
     */
    public void addItem(final String pNom,final Item pItem)
    {
        this.aItm.put(pNom,pItem);
    }
    
    /**
    * renvoie la description.
    */
    public String getDescription()
    {
    return this.aDescription;    
    }
    
    /**
     * @return ItemList retourne une ItemList
     */
    public ItemList getItemList()
    {
        return this.aItems;
    }

    /**
     * Renvoie un objet (Item) avec son paramètre.
     */
    public Item getItem(final String pName)
    {
        return this.aItems.getItem(pName);
    }

}
