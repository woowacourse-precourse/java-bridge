package bridge.presentation;

import bridge.application.BridgeGame;
import bridge.application.ViewService;
public class GameController {
    private static final GameController instance=new GameController();
    private final BridgeGame bridgeGame;
    private final ViewService viewService;
    private GameController(){
        viewService=ViewService.getInstance();
        bridgeGame=BridgeGame.getInstance();
    }
    public static GameController getInstance(){
        return instance;
    }
    public void run(){
        viewService.printGameRunMessage();
    }
    public void inputBridgeSize(){
        viewService.printInputBridgeSizeMessage();
        bridgeGame.saveBridgeSize(viewService.inputBridgeSize());
        bridgeGame.setResult();
    }
    public void generateBridge(){
        bridgeGame.generatorBridge();
    }
    public void inputSelectMove(){
        viewService.printSelectMoveMessage();
        bridgeGame.saveSelectMove(viewService.inputSelectMove());
    }
    public int move(){
        int result=bridgeGame.move();
        viewService.printMoveResult();
        return result;
    }
    public Boolean inputRetry(){
        viewService.printInputRetryMessage();
        return bridgeGame.checkRetry(viewService.inputGameCommand());
    }
    public void exit(){
        viewService.printExit();
    }
}
