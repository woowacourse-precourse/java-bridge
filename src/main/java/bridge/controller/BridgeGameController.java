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
    private BridgeViewConstructor bridgeViewConstructor;
    private final Bridge bridge;
    private final Player player = new Player();
    private int trialCount;

    public BridgeGameController(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
        trialCount = 0;
    }

    public void moveAStep(){
        bridgeViewConstructor = new BridgeViewConstructor();
        player.addNewBridgeInput(inputView.readMoving());
        outputView.printMap(bridgeViewConstructor
                .constructBridge(player.getBridges(), bridge.getBridges()));
    }

    public void resetGame(){
        player.clearBridge();
        trialCount++;
    }

    public void concludeGame(){
        bridgeViewConstructor = new BridgeViewConstructor();
        outputView.printResult(bridgeViewConstructor
                .constructBridge(player.getBridges(), bridge.getBridges()),
                trialCount);
    }

    public boolean isPaused(){
        return !bridge.isPlayerRightBridge(player);
    }

    public boolean isFinished(){
        return false;
    }

    private boolean isSuccess(){
        return player.isGameFinished(bridge);
    }

    private boolean isQuit(){
        return false;
    }
}
