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

    InputView inputView;
    OutputView outputView;
    BridgeGame bridgeGame;
    BridgeMaker bridgeMaker;
    BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
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
        }
    }
}
