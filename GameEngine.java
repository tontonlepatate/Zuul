public class GameEngine
{
    private Parser aParser;
    private Room aCurrentRoom;
    private UserInterface gui;
    private Room aLastRoom;
    /**
     * Constructor for objects of class GameEngine
     */
    public GameEngine()
    {
        aParser = new Parser();
        createRooms();
    }

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
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms()
    {  
      // déclaration des lieux
      Room vStart=new Room("ascenceur", "Images/ascenceur.png");
      Room vCouloir1=new Room("couloir dangereux1","Images/couloir1.png");
      Room vCouloir2=new Room("couloir dangereux2","Images/couloir2.png");
      Room vSas=new Room("Salle de controle de SCP","Images/salle de controle.jpg");
      Room vCarrefour=new Room ("salle de controle","Images/salledecontr.jpg");
      Room vSalleSCP_682=new Room("salle dangereuse1","Images/salle SCP_682.jpg");
      Room vSalleSCP_082=new Room("salle dangereuse2","Images/salle SCP_082.jpg");
      Room vSalleSCP_049=new Room("salle dangereuse3","Images/salle SCP_049.jpg");
      Room vSalleSCP_076=new Room("salle dangereuse4","Images/salle SCP_076.jpg");
      Room vSalleCourant=new Room("salle de l'électricité","Images/courant.jpg");
      Room vLaboratoire=new Room("Laboratoire","Images/labo1.png");
      Room vRéserve=new Room("réserve du complexe","Images/reserve.jpg");
      
      // Position des sorties
      vCouloir1.setExit("North",vSalleSCP_049);
      vCouloir1.setExit("East",vLaboratoire);
      vCouloir1.setExit("West",vCarrefour);
      vCarrefour.setExit("down",vCouloir2);
      vCarrefour.setExit("South",vRéserve);
      vCarrefour.setExit("East",vCouloir1);
      vRéserve.setExit("North",vCarrefour);
      vRéserve.setExit("East",vSalleCourant);
      vSalleCourant.setExit("West",vRéserve);
      vCouloir2.setExit("North",vSalleSCP_682);
      vCouloir2.setExit("South",vSalleSCP_076);
      vCouloir2.setExit("East",vSas);
      vCouloir2.setExit("up",vCarrefour);
      vSalleSCP_682.setExit("South",vCouloir2);
      vSalleSCP_082.setExit("North",vSas);
      vSalleSCP_076.setExit("North",vCouloir2);
      vSalleSCP_049.setExit("South",vCouloir1);
      vSas.setExit("West",vCouloir2);
      vSas.setExit("South",vSalleSCP_082);
      vLaboratoire.setExit("East",vLaboratoire);
      vStart.setExit("South",vCarrefour);
      vCarrefour.setExit("North",vCarrefour);
      
         // déclaration objets
      
      Item vLampeTorche = new Item("LampeTorche",0.4);
      Item vFlare = new Item("fusée éclairante",0.3);
      Item vRadar= new Item("radar",1);
      Item vCarteZ= new Item("Carte Z",0.1);
      Item vCarteB= new Item("Carte B",0.1);
      Item vFusible1= new Item ("fusible 1",0.2);
      Item vFusible2= new Item ("fusible 2",0.2);
      Item vFusible3= new Item ("fusible 3",0.2);
      Item vFusible4= new Item ("fusible 4",0.2);
      Item vC4=new Item("C4",3);
      Item vWaterBot=new Item("bouteille d'eau",1);
      Item vCésium=new Item("Césium",1);
      Item vModulePirat=new Item("craftable et servant à faire une énigme",4);
      Item vEthanol=new Item("Flacon d'éthanol",2);
      Item vTournevis=new Item("Tournevis",0.5);
      Item vChalumeau=new Item("Chalumeau",3);
      Item vSchémaFusible=new Item("SchémaFusible",0.1);
      Item vSchémaC4=new Item("SchémaC4",0.1);
      Item vSchémaModPirt=new Item("Schéma Module de piratage",0.1);
      Item vSchémaCouvert=new Item("schéma couverture de dissimulation",0.1);
      Item vCouverture=new Item("couverture de dissimulation",2);
      Item vCables=new Item("Cables",2);
      Item vCircuitImprimé=new Item("Circuit Imprimé",2);
      
         // Position des objets
      vCarrefour.setItem("Lampet",vLampeTorche);
      vLaboratoire.setItem("Flacon",vEthanol);
      vLaboratoire.setItem("CarteZ",vCarteZ);
      vLaboratoire.setItem("SchémaF",vSchémaFusible);
      vLaboratoire.setItem("Césium",vCésium);
      vLaboratoire.setItem("schémaD",vSchémaCouvert);
      vSalleSCP_049.setItem("CarteB",vCarteB);
      vSas.setItem("radar",vRadar);
      vRéserve.setItem("fusée",vFlare);
      vRéserve.setItem("Tournevis",vTournevis);
      vRéserve.setItem("Cables",vCables);
      vRéserve.setItem("bouteille",vWaterBot);
      vSalleCourant.setItem("fusible3",vFusible3);
      vSalleSCP_076.setItem("Chalumeau",vChalumeau);
      
      
      // Lieu courant
      this.aCurrentRoom = vStart; 
      this.aParser=new Parser();
    }

    /**
     * Given a command, process (that is: execute) the command.
     * If this command ends the game, true is returned, otherwise false is
     * returned.
     */
    public void interpretCommand(String commandLine) 
    {
        gui.println(commandLine);
        Command command = aParser.getCommand(commandLine);

        if(command.isUnknown()) {
            gui.println("I don't know what you mean...");
            return;
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

    /** 
     * Try to go to one direction. If there is an exit, enter the new
     * room, otherwise print an error message.
     */
    private void goRoom(Command command) 
    {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            gui.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();

        // Try to leave current room.
        Room nextRoom = aCurrentRoom.getExit(direction);

        if (nextRoom == null)
            gui.println("There is no door!");
        else {
            aCurrentRoom = nextRoom;
            gui.println(aCurrentRoom.getLongDescription());
            if(aCurrentRoom.getImageName() != null)
                gui.showImage(aCurrentRoom.getImageName());
        }
    }

    private void endGame()
    {
        gui.println("Thank you for playing.  Good bye.");
        gui.enable(false);
    }
    
    public void printLocationInfo()
    {
        this.gui.println("vous etes dans " +aCurrentRoom.getDescription());

    }
    
    private void look()
    {
        this.gui.println(this.aCurrentRoom.getLongDescription());
    }
    
    private void eat()
    {
        this.gui.println("You have eaten now and you are not hungry any more");
    }
    
    private void back()
    {
        Room vback = new Room (aCurrentRoom);
        if(aLastRoom==null)
        {
            this.gui.println("you are in the first room you idiot!");
        }
        else if (aLastRoom==aCurrentRoom) 
        {
            this.aCurrentRoom.goRoom();
        }
    }


}
