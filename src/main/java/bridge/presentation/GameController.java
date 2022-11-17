package bridge.presentation;

import bridge.application.GameService;
import bridge.application.ViewService;
public class GameController {
    private static final GameController instance=new GameController();
    private final GameService gameService;
    private final ViewService viewService;
    private GameController(){
        viewService=ViewService.getInstance();
        gameService=GameService.getInstance();
    }
    public static GameController getInstance(){
        return instance;
    }
    public void run(){
        viewService.printGameRunMessage();
    }
    public void inputBridgeSize(){
        viewService.printInputBridgeSizeMessage();
        gameService.saveBridgeSize(viewService.inputBridgeSize());
    }
    public void generateBridge(){
        gameService.generatorBridge();
    }
    public void inputSelectMove(){
        viewService.printSelectMoveMessage();
        gameService.saveSelectMove(viewService.inputSelectMove());
    }
}
