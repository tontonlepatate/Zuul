
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
    
    public double getWeight()
    {
        return this.aWeight;
    }  

    public String getDescription()
    {
        return this.aDescription;
    }
    
    @Override public String toString()
    {
        return this.aDescription + " pèse " + this.aWeight +"Kg" ;
    }
} // Item
