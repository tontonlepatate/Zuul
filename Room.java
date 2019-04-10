import java.util.HashMap;
import java.util.Set;
import java.util.Iterator;

public class Room
{    
 private String aDescription;
 private HashMap<String,Room> aExits;
 private String imageName;
 private HashMap<String,Item > aItem;

 public Room(final String pDescription,final String pImage)
 {
 this.aDescription=pDescription; 
 aExits = new HashMap<String, Room>();
 imageName = pImage;
 aItem = new HashMap<String,Item >();
 
 }
 public String getDescription()
 {
 return this.aDescription;    
 } 
 public void setExit (final String pDirection,final Room pNeighbor)
 {
     aExits.put(pDirection,pNeighbor);
 }

 public Room getExit(final String pDirection) 
    {
        return aExits.get(pDirection);
    }
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
 public String getLongDescription()
 {
     return" Vous etes " + this.aDescription + ".\n" +this.getExitString();
 }
 public String getImageName()
	{
		return imageName;
	}
 public void setItem (final String pName,final Item pItem)
 {
     this.aItem.put(pName,pItem);
 }
}
