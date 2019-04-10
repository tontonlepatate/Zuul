
/**
 * Write a description of class Item here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String aDescription;
    private double aWeight;
    /**
     * Default constructor for objects of class Item
     */
    public Item(final String pDescription,final double pWeight)
    {
        // initialise instance variables
        this.aDescription = pDescription;
        this.aWeight=pWeight;
    } // Item()

    public String getDescription()
    {
        return this.aDescription;
    }
    
    public String getWeight()
    {
        return this.aDescription + " pèse " + this.aWeight +"Kg" ;
    }
} // Item
