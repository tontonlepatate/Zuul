 import java.util.HashMap;
 
/**
 *
 * @param direction ignored
 * @return A random room
 * 
 */
public class TransporterRoom extends Room
{
    
    private RoomRandomizer aRoomRandomizer;
    
    /**
     * @param pDescription Description String of the Room
     * 
     */
    public TransporterRoom(final String pDescription, final String pImage){
        super(pDescription, pImage);
    }//TransporterRoom()
    
    /**
     * @return a random room using RoomRandomizer's method.
     */
    
    @Override public Room getExit(final String pDirection){
        this.aRoomRandomizer = new RoomRandomizer();
        return this.aRoomRandomizer.findRandomRoom();
    }//getExit()

}
