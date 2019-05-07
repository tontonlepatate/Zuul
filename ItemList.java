import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

/**
 * Write a description of class ItemList here.
 *
 * @author (Sitbon Vadim)
 * 
 */
public class ItemList

{
    private HashMap<String, Item> aItems;
    
    /**
     * Create an item list
     */
    public ItemList()
    {
        aItems = new HashMap<String, Item>();
    }
    
    /**
     * Ajoute un Item
     * @param pDes invtr
     * @param pItem Item
     */
    public void addItem(final String pItemNam,final Item pItem)
    {
        this.aItems.put(pItemNam, pItem);
    }
    
    /**
     * Vérifie si l'item en paramètre est dans la liste par rapport à son nom
     * @param pNomItem nom Item
     * @return boolean
     */
    public boolean containsItem(final String pNomItem)
    {
        return this.aItems.containsKey(pNomItem);
    }
    
    /**
     * Renvoie l'item de la liste en fonction de son nom
     * @param pNomItem nom de l'item
     * @return Item un item
     */
    public Item getItem(final String pNomItem)
    {
        Item vItem = null;
        if(this.containsItem(pNomItem))
        {
            vItem = this.aItems.get(pNomItem);
        }
            
        return vItem;
    }
    
    /**
     * Permet de récupérer l'item souhaiter selon le nom entré
     * @return l'item demandé par le joueur.
     */
    public Item getItemInventory(final String pItemName)
    {
        return this.getItem(pItemName);
    }
    
    /**
     * Permet de supprimer un item de l'inventaire dont il est question
     */
    public void removeItemInventory(final String pItemName)
    {
        this.aItems.remove(pItemName);
    }
    
    /**
     *@return HashMap list item
     */
    public HashMap getItemList()
    {
        return this.aItems;
    }
    
    
    /**
     * Retourne un Set du nom des items contenues dans la liste
     * 
    public Set<String> keySet()
    {
        return this.aItems.keySet();
    }*/
    
    public String getItemString()
    {
        String returnString = "";
        Set<String> keys = aItems.keySet();
        for(String item : keys)
        {
            returnString += item;
        }
        return returnString;
    }
    
    /**
     * Fonction permettant de savoir si l'on a l'item
     * @param item l'item en question
     * @return Item si l'item est ds l'invent
     */
    public Item findItem(String item)
    {
        for (int i=0; i < this.aItems.size(); i++)
        {
            Item It = (Item) this.aItems.get(i);
            if (item.equals(It.getDescription()))
            {
                return It;
            }
        }
        return null;
    }
    
    public String getInventoryPlayerString() {
        String vInventoryString = "Inventory:";
        if(!this.aItems.isEmpty()){
            Set<String> vItemNames = this.aItems.keySet(); 
            for(String vItemName : vItemNames){
                vInventoryString += "\n  " + this.aItems.get(vItemName).getItemDescription();
            }

            vInventoryString += "\nCarrying " + getTotalInventoryWeight();

            return vInventoryString;
        }      
        else
            return vInventoryString += "\n Is Empty";  

    }
    
    /**
     * Permet de récupérer le poids actuel total de l'inventaire du joueur.
     * @return le poids total de l'inventaire
     */
    public double getTotalInventoryWeight() {
        double vInventoryWeight = 0.0;
        if(!this.aItems.isEmpty()){
            Set<String> vItemNames = this.aItems.keySet(); 
            for(String vItemName : vItemNames){
                vInventoryWeight += this.aItems.get(vItemName).getWeight();
            }
         }
         return vInventoryWeight;
    }
} // ItemList