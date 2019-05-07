/**
 * Classe pour créer des door 
 * donc faire les Trap
 * 
 */
public class Door
{
    private boolean aLock;
    private boolean aReturn;
    private String aDoorName;
    /**
     * 
     * 
     */
    public Door(final String pDoorName,final boolean pLocked, final boolean pCanGoBack)
    {
        this.aDoorName= pDoorName;
        this.aLock= pLocked;
        this.aReturn= pCanGoBack;
    }//Door()
    
    /** 
     * Accesseur pour l'attribut Locked
     * @return si la Door est fermée à clé ou non
     */
    public boolean getLocked()
    {
        return this.aLock;
    }//getLocked()
    
    /**
     * Accesseur pour l'attribut CanGoBack
     * @return si on peut retourner en arrière ou non en passant la Door
     */
    public boolean getCanGoBack()
    {
        return this.aReturn;
    }//getCanGo()
    
    
}
