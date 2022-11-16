package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.Util.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class GameController {

    private boolean keepGoing = true;
    private int i = 0;
    private int tryCount = 1;

    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while(keepGoing && i < bridgeSize){
            String nextMove = inputView.readMoving();
            String moveResult = bridgeGame.move(bridge.get(i), nextMove);
            outputView.extracted(nextMove, moveResult);
            outputView.printMap();
            i++;
            if(moveResult.matches("X")){
                checkKeepGoing();
            }
        }
        outputView.printResult(tryCount, keepGoing);
    }

    private void checkKeepGoing() {
        String resetCommand = inputView.readGameCommand();
        if(resetCommand.matches("R")) {
            i = 0;
            tryCount++;
            outputView.clearMap();
        }
        if(resetCommand.matches("Q"))
            keepGoing = false;
    }
}
