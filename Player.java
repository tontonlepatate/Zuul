import java.util.Stack;
import java.util.HashMap;
public class Player
 { 
    private String aName;
    private Room aCurrentRoom;
    private Stack<Room> aPreviousRooms;
    private ItemList aIList;
    public static double A_Number=8.00;
    private double aCurrentNumber;
    private HashMap<String,Item> aH;
    /**
     * Default constructor for objects of class Player
     */
    public Player(final String pName)
    {
        this.aName = pName;
        this.aCurrentRoom=null;
        this.aPreviousRooms = new Stack<Room>();
        this.aH = new HashMap<String,Item>();
    } // Player()
    
    public String getName()
    {
        return this.aName;
    }
    
    public Room getCurrentRoom()
    {
        return this.aCurrentRoom;
    }
    
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
    
    public HashMap<String,Item> getItems()
    {
        return this.aH;
    }
    
    public Item getItem (final String pgm)
    {
        return this.aH.get(pgm);
    }
    
    public String take(final String pName)
    {
        if (!this.aCurrentRoom.getItemList().containsItem(pName))
        {
           return "there isn't this in this Room bastard";
        }
        if(this.aIList.containsItem(pName))
        {
            return"you already have it";
        }
        Item vItem = this.aCurrentRoom.getItemList().getItem(pName);
        if(this.aCurrentNumber + vItem.getWeight() > Player.A_Number)
        {
            return"you have too many object fucker!";
        }
        this.aIList.addItem(pName, this.getCurrentRoom().getItemList().getItem(pName));
        this.aCurrentRoom.getItemList().removeItem(vItem);
        this.aCurrentNumber += vItem.getWeight();
        return "you have take "+vItem.getDescription();
    }
    
    public String drop(final String pName){
        if (!this.aCurrentRoom.getItemList().containsItem(pName))
        {
           return"there is already "+" in this room";
        }
        if(this.aIList.containsItem(pName))
        {
            return"you don't have it";
        }
        Item vItem = this.aCurrentRoom.getItemList().getItem(pName);
        
        this.aIList.addItem(pName, this.getCurrentRoom().getItemList().getItem(pName));
        this.aCurrentRoom.getItemList().addItem(pName, this.getCurrentRoom().getItemList().getItem(pName));
        this.aCurrentNumber -= vItem.getWeight();
        return "you have drop "+vItem.getDescription();
       }
    
    public ItemList getItemList()
    {
       return this.aIList;
    }
} // Player
