import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Room
{    
 private String aDescription;
 private HashMap<String,Room> aExits;
 private String imageName;
 private ItemList aItems;
 
 /**
  * créée une salle (Room).
  */
 public Room(final String pDescription,final String pImage)
 {
 this.aDescription=pDescription; 
 aExits = new HashMap<String, Room>();
 imageName = pImage;
 aItems = new ItemList();
 }
 
 /**
  * renvoie la description.
  */
 public String getDescription()
 {
 return this.aDescription;    
 } 
 
 /**
  * créé les Item.
  */
 public void setExit (final String pDirection,final Room pNeighbor)
 {
     aExits.put(pDirection,pNeighbor);
 }
 
 /**
  * créé les Item.
  */
 public Room getExit(final String pDirection) 
    {
        return aExits.get(pDirection);
    }
    
 /**
  * Renvoie la pièce dans la qulle nous sommes si l'on se déplace 
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
  * créé les Item.
  */
 public String getLongDescription()
 {
      return"You are in " + this.aDescription + ".\n" +this.getExitString()+".\n"+"In the room there is :"+ this.aItems.toString();
 }
 
 /**
  * renvoie le nom des images.
  */
 public String getImageName()
    {
        return imageName;
    }
    
 /**
  * créé les Item.
  */
 public void setItem (final String pName,final Item pItem)
 {
      this.aItems.addItem(pItem.getDescription(), pItem);
 }
 
 /**
  * Renvoie la liste des objets (items).
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
