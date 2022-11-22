package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.util.BridgeViewConstructor;
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
        outputView.printMap(constructBridge());
    }

    public void resetGame(){
        player.clearBridge();
        player.increaseTrialCount();
    }

    public void concludeGame(){
        outputView.printResult(constructBridge(), player.getTrialCount());
    }

    private String constructBridge(){
        BridgeViewConstructor bridgeViewConstructor = new BridgeViewConstructor();
        return bridgeViewConstructor
                .constructBridge(player.getBridges(), bridge.getBridges());
    }

    public boolean isPaused(){
        return !bridge.isPlayerRightBridge(player);
    }

    public boolean isSuccess(){
        return player.isGameFinished(bridge);
    }

    public String readFinalCommand(){
        return inputView.readGameCommand();
    }
}
