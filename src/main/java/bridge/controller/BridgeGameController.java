package bridge.controller;

import bridge.model.Bridge;
import bridge.model.Player;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.util.BridgeViewConstructor;
import bridge.view.InputView;
import bridge.view.OutputView;

import static bridge.enums.GameStatus.QUIT;

public class BridgeGameController {

    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final Bridge bridge;
    private final Player player = new Player();

    public BridgeGameController(){
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        bridge = new Bridge(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

    private void moveAStep(){
        player.addNewBridgeInput(inputView.readMoving());
        outputView.printMap(constructBridge());
    }

    private void resetGame(){
        player.clearBridge();
        player.increaseTrialCount();
    }

    private void concludeGame(){
        outputView.printResult(constructBridge(), player.getTrialCount());
    }

    private String constructBridge(){
        BridgeViewConstructor bridgeViewConstructor = new BridgeViewConstructor();
        return bridgeViewConstructor
                .constructBridge(player.getBridges(), bridge.getBridges());
    }

    public void runGame(){
        while(true){
            moveUntilStop();
            if(isSuccess()) break;
            if(isQuit())break;
            resetGame();
        }
        concludeGame();
    }

    private boolean isQuit(){
        return readFinalCommand().equals(QUIT.getCommand());
    }

    private void moveUntilStop(){
        while(!(isSuccess() || isPaused())){
            moveAStep();
        }
    }

    private boolean isPaused(){
        return !bridge.isPlayerRightBridge(player);
    }

    private boolean isSuccess(){
        return player.isGameFinished(bridge);
    }

    private String readFinalCommand(){
        return inputView.readGameCommand();
    }
}
