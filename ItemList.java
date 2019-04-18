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
     */
    public void addItem(final String pDesc, final Item pItem)
    {
        this.aItems.put(pDesc, pItem);
    }
    
    /**
     * Vérifie si l'item en paramètre est dans la liste par rapport à son nom
     */
    public boolean containsItem(final String pNameItem)
    {
        return this.aItems.containsKey(pNameItem);
    }
    
    /**
     * Renvoie l'item de la liste en fonction de son nom          
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
    
    public HashMap getItemList()
    {
        return this.aItems;
    }
    
    /**
     * Supprime l'item de la liste
     */
    public void removeItem(final Item pItem)
    {
        this.aItems.remove(pItem.getDescription());
    }
    
    /**
     * Retourne un Set du nom des items contenues dans la liste
     * 
    public Set<String> keySet()
    {
        return this.aItems.keySet();
    }*/
    
    /**
     * Retourne une chaine de caractere contenant la liste des items
     */
    public String toString()
    {
        Iterator vI = this.aItems.keySet().iterator();
        StringBuilder vSB = new StringBuilder("");
        if(!vI.hasNext())
        {
            vSB.append("aucun objet");
        } // if
        else
        {
            vSB.append(this.aItems.get((String)vI.next()).getDescription());
            while(vI.hasNext())
            {
                String vNom = (String)vI.next();
                if(vI.hasNext())
                {
                    vSB.append(", ");
                } // if
                else
                {
                    vSB.append(" et ");
                } // else
                vSB.append(this.aItems.get(vNom).getDescription());
            } // while
        } // else
        return vSB.toString();
    }
    /**
     * Fonction permettant de retrouver un item dans l'inventaire
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
} // ItemList