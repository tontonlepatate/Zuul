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
    private double aPoids;
    
    /**
     * Create an item list
     */
    public ItemList()
    {
        aItems = new HashMap<String, Item>();
        this.aPoids = 0 ;
    }
    
    /**
     * @param pD correspond au poid a ajouter de l'inventaire por un item donné
     */
    public void addPoids ( final double pD){
        this.aPoids += pD;
    }
    
    /**
     * @param pD correspond au poid a enlever de l'inventaire por un item donné
     */
    public void rmPoids (final double pD){
        this.aPoids -= pD;
    }
    
    /**
     * @return double pour le poids de l'item
     */
    public double getPoids (){
        return this.aPoids;
    }
    
    /**
     * Ajoute un Item dans une hashmap
     * @param pDes invtr
     * @param pItem Item
     * @param pItemName
     */
    public void addItem(final String pItemNam,final Item pItem)
    {
        this.aItems.put(pItemNam, pItem);
    }
    
    /**
     * sort un Item d'une hashmap
     * @param pDes invtr
     * @param pItem Item
     */
    public void removeItem(final String pItemNam,final Item pItem)
    {
        this.aItems.remove(pItemNam, pItem);
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
     * @param pItemName correspond au nom de l'item
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
    
    /**
     * @return String renvoie la contenance de l'inventaire
     */
    public String getInventoryPlayerString() {
        if (aItems.isEmpty())
        {
            return "\n"+"your inventory is empty";
        }
        String vs = "Your inventory : ";
        Set<String> keys = aItems.keySet();
        for (String vS : keys) vs += " "+vS;
        return vs;
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
}      // ItemList