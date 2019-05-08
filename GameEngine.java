
import java.util.Stack;
import java .util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import javax.swing.JFileChooser;
import java.util.TimerTask;
import java.util.Timer;
public class GameEngine
{
    private Parser aParser;
    private Room aCurrentRoom;
    private UserInterface gui;
    private Room[] aTab;
    private Stack <Room> aPile2Room;
    private Player aPlayer;
    private int aTimer;
    private Timer aTim;
    
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        aParser = new Parser();
        aPile2Room = new Stack<Room>();
        createRooms();
        /*this.aTim =500;*/
    }
    
    
    /**
     * methode setGui servant a initialiser gui
     */
    public void setGUI(UserInterface userInterface)
    {
        gui = userInterface;
        printWelcome();
    }

    /**
     * Print out the opening message for the player.
     */
    private void printWelcome ()
    {
       this.gui.println("hello SCP_014 to the complex 77BX !");
       this.gui.println("this complex has for ojective to contain 4 very dangerous SCP");
       this.gui.println("Type 'help' if you need more information");
       this.gui.println( " " );
       this.gui.println("you are in the entrance of the complex");
       this.gui.println("Exits: South");
       printLocationInfo();
       this.gui.showImage(this.aPlayer.getCurrentRoom().getImageName());
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {  
      // déclaration des lieux
      Room vStart=new Room("the lift", "Images/ascenceur.png");
      Room vCouloir1=new Room("the east corridor","Images/couloir1.png");
      Room vCouloir2=new Room("the west corridor","Images/couloir2.png");
      TransporterRoom vSas=new TransporterRoom("the sas","Images/sas.jpg");
      Room vCarrefour=new Room ("control room of scp","Images/salledecontr.jpg");
      Room vSalleSCP_682=new Room("the SCP_682 room","Images/salle SCP_682.jpg");
      Room vSalleSCP_082=new Room("the SCP_082 room","Images/salle SCP_082.jpg");
      Room vSalleSCP_049=new Room("the SCP_049 room","Images/salle SCP_049.jpg");
      Room vSalleSCP_076=new Room("the SCP_076 room","Images/salle SCP_076.jpg");
      Room vSalleCourant=new Room("the electricity room","Images/courant.jpg");
      Room vLaboratoire=new Room("Laboratory","Images/labo1.png");
      Room vReserve=new Room("the supply room","Images/reserve.jpg");
      
      // Position des sorties
      vCouloir1.setExit("left",vSalleSCP_049);
      vCouloir1.setExit("forward",vLaboratoire);
      vCouloir1.setExit("behind",vCarrefour);
      vCarrefour.setExit("down",vCouloir2);
      vCarrefour.setExit("forward",vReserve);
      vCarrefour.setExit("right",vCouloir1);
      vReserve.setExit("behind",vCarrefour);
      vReserve.setExit("left",vSalleCourant);
      vSalleCourant.setExit("behind",vReserve);
      vCouloir2.setExit("left",vSalleSCP_682);
      vCouloir2.setExit("right",vSalleSCP_076);
      vCouloir2.setExit("forward",vSas);
      vCouloir2.setExit("up",vCarrefour);
      vSalleSCP_682.setExit("behind",vCouloir2);
      vSalleSCP_082.setExit("behind",vSas);
      vSalleSCP_076.setExit("behind",vCouloir2);
      vSalleSCP_049.setExit("behind",vCouloir1);
      vSas.setExit("behind",vCouloir2);
      vSas.setExit("forward",vSalleSCP_082);
      vLaboratoire.setExit("behind",vCouloir1);
      vStart.setExit("forward",vCarrefour);
      vCarrefour.setExit("behind",vStart);
      
         // déclaration objets
      Item vCourage = new Item("Courage ",8.00,"Courage");
      Item vLampeTorche = new Item("flashlight ",0.4,"flashlight");
      Item vFlare = new Item("flare ",0.3,"flare to enlight areas");
      Item vRadar= new Item("radar ",1,"to detect the wandering monsters");
      Item vCarteZ= new Item("Card Z ",0.1,"to pass trough the first door of the sas");
      Item vCarteB= new Item("Card B ",0.1,"to pass through the second door of the sas");
      Item vFusible1= new Item ("fuse 1 ",0.2,"the first fuse to save the complex");
      Item vFusible2= new Item ("fuse 2 ",0.2,"the second fuse to save the complex");
      Item vFusible3= new Item ("fuse 3 ",0.2,"the third fuse to save the complex");
      Item vFusible4= new Item ("fuse 4 ",0.2,"the fourth fuse to save the complex");
      Item vC4=new Item("C4 ",3,"the bomb to take care of something dangerous");
      Item vWaterBot=new Item("water bottle ",1,"a normal water bottle");
      Item vCésium=new Item("Cesium ",1,"a element that can be combine maybe...");
      Item vModulePirat=new Item("hack module ",4,"to open a certain door");
      Item vEthanol=new Item("ethanol ",2,"a bottle full of ethanol can charge something maybe...");
      Item vTournevis=new Item("Screwdriver ",0.5,"can be use to create some items");
      Item vChalumeau=new Item("blow torch ",3,"a blow torch to defend yourself");
      Item vSchémaFusible=new Item("Fuse pattern ",0.1,"a single pattern to create an specific item");
      Item vSchémaC4=new Item("C4 pattern ",0.1,"a single pattern to create an explosive");
      Item vSchémaModPirt=new Item("hack module pattern ",0.1,"a single pattern to create a useful Item");
      Item vSchémaCouvert=new Item("dissimulation scarf pattern ",0.1,"a pattern to create something usefull");
      Item vCouverture=new Item("dissimulation scarf ",2,"a scarf that make you invisible in front of the scp");
      Item vCables=new Item("power cables ",2,"cables that are usefull to create items");
      Item vCircuitImprimé=new Item("printed circuits ",2,"circuits that are usefull to create items");
      
         // Position des objets 
      vStart.addItem("bravery ",vCourage);
      vCarrefour.addItem("flashlight ",vLampeTorche);
      vLaboratoire.addItem("alcool ",vEthanol);
      vLaboratoire.addItem("carte z ",vCarteZ);
      vLaboratoire.addItem("Schema fuse ",vSchémaFusible);
      vLaboratoire.addItem("cesium ",vCésium);
      vLaboratoire.addItem("Schema scarf ",vSchémaCouvert);
      vSalleSCP_049.addItem("carte b ",vCarteB);
      vSas.addItem("Radar ",vRadar);
      vReserve.addItem("Flare ",vFlare);
      vReserve.addItem("tournevis ",vTournevis);
      vReserve.addItem("Cables ",vCables);
      vReserve.addItem("Water Bottle ",vWaterBot);
      vSalleCourant.addItem("the third fuse ",vFusible3);
      vSalleSCP_076.addItem("blow torch ",vChalumeau);
      
      this.aTab = new Room[12];
      this.aTab[0] = vCouloir2;
      this.aTab[1] = vCouloir1;
      this.aTab[2] = vStart;
      this.aTab[3] = vSas;
      this.aTab[4] = vCarrefour;
      this.aTab[5] = vSalleSCP_682;
      this.aTab[6] = vSalleSCP_082;
      this.aTab[7] = vSalleSCP_049;
      this.aTab[8] = vSalleSCP_076;
      this.aTab[9] = vSalleCourant;
      this.aTab[10] = vLaboratoire;
      this.aTab[11] = vReserve;
      
      //joueur
      this.aPlayer= new Player ("dude",vStart);
      // Lieu courant
      this.aCurrentRoom = vStart; 
      this.aParser=new Parser();
    }
    
    
    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     * @param commandLine ligne de commande 
     * 
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = aParser.getCommand(commandLine);

        if(command.isUnknown()) {
            gui.println("I don't know what you mean...");
            
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help"))
            printHelp();
        else if (commandWord.equals("go"))
            goRoom(command);
        else if (commandWord.equals("quit")) {
            if(command.hasSecondWord())
                gui.println("Quit what?");
            else
                endGame();
        }
        else if (commandWord.equals("look"))
        {
            this.look();
        }
        else if (commandWord.equals("back"))
        {
            this.back();
        }
        else if (commandWord.equals("test"))
        {
            if(command.hasSecondWord())
            {
                lecture(command.getSecondWord() +".txt");
            }
            else
            {
                gui.println("What do you want to test ?");
            }
        }
        else if (commandWord.equals("drop"))
        {
            /*if(command.hasSecondWord())
            {
                this.drop(command);
                gui.println("you drop "+command);
            }
            else
            {
                gui.println("what do you want to drop ?");
            }*/
            gui.println("this action do not work sorry");
        }
        
        else if (commandWord.equals("take"))
        {
            /*if(command.hasSecondWord())
            {
                this.aPlayer.take(command);
            }
            else
            {
                this.gui.println("what do you want to take ?");
            }*/
            gui.println("this action do not work sorry");
        }
           
        else if (commandWord.equals("back"))
        {
            this.back();
        }
        /*else if (commandWord.equals("answer"))
        {
            if(command.hasSecondWord())
            {
                this.answer(command.getSecondWord());
                
            }
            else
            {
                gui.println("...");
            }
        }*/
    }

    public Room[] getTab()
    {
        return this.aTab;
    }
    
    // implementations of user commands:

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private void printHelp()
    {
        this.gui.println("You see a long corridor leading to an intersection");
        this.gui.println("You touch the wall, it's made of reinforced concrete");
        this.gui.println("");
        this.gui.println("Your command words are:");
        this.gui.println("go quit help");
        aParser.showCommands();
    }
    
    /*public void answer(final String pAns)
    {
        if (pAns.equals("denis_bureau"))
        {
            this.gui.println("win I give you this as a prize");
            this.aPlayer.addItem(vFuse1);
        }
        else
        {
            this.gui.println("loose");
            this.looseGame();
        }
    }*/

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     * @param command commande
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gui.println("Go where?");
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = aCurrentRoom.getExit(direction);

        if (nextRoom == null)
            gui.println("There is no door!");
        else {
            this.aPile2Room.push(aCurrentRoom);
            aCurrentRoom = nextRoom;
            gui.println(aCurrentRoom.getLongDescription());
            
            if(this.aPlayer.getCurrentRoom().getDescription().equals("the SCP_049 room"))
                {
                    this.gui.println("well well... you came into my room"+"\n"+"if you want to go back you have to solve my enigma"+"\n"+
                    "who is the best programmer in the esiee?"+"\n"+"benjamin_raynal"+"\n"+"denis_bureau"+"\n"+"vadim_sitbon");
                    
                }
            if(aCurrentRoom.getImageName() != null)
                gui.showImage(aCurrentRoom.getImageName());
           
        }
    }

    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
    
    private void winGame()
    {
        gui.println("you win gg dude!");
        this.endGame();
    }
    
    private void looseGame()
    {
        gui.println("you loose dude T_T seriously ?");
        this.endGame();
    }
    
    /**
     * méthode donnant des indication sur la location du joueur et l'environement et le joueur en lui meme
     */
    public void printLocationInfo()
    {
        this.gui.println("you are in " +aCurrentRoom.getLongDescription());

    }
    
    /**
     * méthode donnant des indication sur l'environement et le joueur en lui meme 
     * (méthode assez similaire a la précedente mais utilisable pour la commmande look)
     */
    
    private void look()
    {
        this.gui.println(this.aCurrentRoom.getLongDescription());
    }
    
    /**
     * méthode inutile tant que l'on ne peut ramassezz
     */
    private void eat()
    {
        this.gui.println("You have eaten now and you are not hungry any more");
    }
    
    /**
    *@param pNameFile name of the file
    */
    public void lecture (final String pNameFile)
    {
        JFileChooser Files = new JFileChooser(".");
        if (Files.showOpenDialog(null) != JFileChooser.APPROVE_OPTION)
        {
            return;
        }
        try
        {
            Scanner vScan = new Scanner(Files.getSelectedFile());
            while(vScan.hasNextLine())
            {
                String vLine = vScan.nextLine();
                interpretCommand(vLine);
            }
        }
        catch(final FileNotFoundException pFile)
        {
            gui.println("File not found");
        }
    }    
    
    private void back()
    {
        if(!aPile2Room.empty()){
            aCurrentRoom=aPile2Room.pop();
            this.gui.println(this.aCurrentRoom.getLongDescription());
            if(this.aCurrentRoom.getImageName()!=null)
            {
                this.gui.showImage(this.aCurrentRoom.getImageName());
            }
        }
        else gui.println("you are in the first room you moron");
    }

    /**
    *@param pFichier fichier
    */
    public void test(final Command pFichier)
    {
        try
        {
            Scanner vSac = new Scanner (new File (pFichier.getSecondWord()+".txt"));
            while(vSac.hasNextLine())
            {
                String vCommand = vSac.nextLine();
                this.interpretCommand(vCommand);
            }
        }
            catch(final FileNotFoundException pE)
            {
                this.gui.println(pE.getMessage());
        }
            
    }
        
    
    
    /**
     * Permet au joueur de se débarasser d'un item qui ne lui est plus utile.
     * @param pCommande commande entrée par le joueur.
     * 
     */
    private void drop(Command pCommande)
    {
        if(!pCommande.hasSecondWord()){
            gui.println("Drop what dude ?");
            return;

        }//if()
        
        String vItemName = pCommande.getSecondWord();
        Room vCurrentRoom = this.aPlayer.getCurrentRoom();
        Item vToDrop = this.aPlayer.getInventoryPlayer().getItemInventory(vItemName);
      
        if(vToDrop==null){
            gui.println("There is not this item in your inventory .");
            return;
        }//if()
        
        this.aPlayer.getInventoryPlayer().removeItemInventory(vItemName);
        vCurrentRoom.addItem(vToDrop.getName(),vToDrop);
        gui.println("You just dropped the item : " +vItemName);
        
    }
}
