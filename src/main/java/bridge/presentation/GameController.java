package bridge.presentation;

import bridge.application.GameService;
import bridge.application.ViewService;
import bridge.presentation.dto.BridgeSize;
import bridge.presentation.dto.SelectMove;
import camp.nextstep.edu.missionutils.Console;

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
        gameService.saveBridgeSize(new BridgeSize(Console.readLine()));
    }

    public void inputSelectMove(){
        viewService.printSelectMoveMessage();
        gameService.saveSelectMove(new SelectMove(Console.readLine()));
    }
}
