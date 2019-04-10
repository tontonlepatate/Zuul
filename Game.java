 

public class Game
{
    private UserInterface gui; ;
    private GameEngine engine ;
    
    //constructeur naturel
    public Game()
    {
        engine = new GameEngine();
		gui = new UserInterface(engine);
		engine.setGUI(gui);
    }
    //méthode goRoom
}