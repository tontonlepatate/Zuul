
/**
 * Write a description of class Item here.
 *
 * @author (Sitbon Vadim)
 * @version (18/04/2019)
 */
public class Item
{
    // instance variables - replace the example below with your own
    private String aDescription;
    private double aWeight;
    private String aNam;
    /**
     * Default constructor for objects of class Item
     * @param pDescription description
     * @param pWeight poids item
     */
    public Item(final String pNam,final double pWeight,final String pDescription)
    {
        // initialise instance variables
        this.aDescription = pDescription;
        this.aWeight=pWeight;
        this.aNam = pNam;
    } // Item()
    
    /**
     * Accesseur pour l'attribut Name
     * @return le nom de l'item
     */
    public String getName()
    {
        return this.aNam;
    }
    
    /**
     * Permet de récupérer la description entière d'un item
     * @return la description complète de l'item
     */
    public String getItemDescription(){
        return this.aNam +" : " + this.aDescription+ " ( " +this.aWeight+" kg(s) ).";
        
    }
    
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
        return this.aDescription + " weigth is " + this.aWeight +"Kg" ;
    }
} // Item
