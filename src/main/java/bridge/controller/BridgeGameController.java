package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Bridge bridge = new Bridge(List.of(""));
    private final Player player = new Player();

    public BridgeGameController(){

    }

    public void moveAStep(){

    }

    public void resetGame(){

    }

    public void concludeGame(){

    }

    public boolean isPaused(){
        return false;
    }

    public boolean isFinished(){
        return false;
    }

    private boolean isSuccess(){
        return false;
    }

    private boolean isQuit(){
        return false;
    }
}
