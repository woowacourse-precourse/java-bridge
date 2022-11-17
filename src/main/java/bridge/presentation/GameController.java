package bridge.presentation;

import bridge.application.ViewService;

public class GameController {
    private static final GameController instance=new GameController();
    ViewService viewService;
    private GameController(){
        viewService=ViewService.getInstance();
    }
    public static GameController getInstance(){
        return instance;
    }
    public void run(){
        viewService.printGameRunMessage();
    }
}
