package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Bridge bridge;
    private final Player player = new Player();

    public BridgeGameController(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    public void moveAStep(){
        player.addNewBridgeInput(inputView.readMoving());
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
