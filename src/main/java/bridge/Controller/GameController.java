package bridge.Controller;

import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.Model.MapShape;
import bridge.Util.BridgeRandomNumberGenerator;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;

public class GameController {

    private static final String FAIL_CASE = "X";
    private static final String RESET_COMMAND = "R";
    private static final String QUIT_COMMAND = "Q";

    private boolean keepGoing = true;
    private int i = 0;
    private int tryCount = 1;

    private final InputView inputView;
    private final OutputView outputView;
    private final BridgeGame bridgeGame;
    private final BridgeMaker bridgeMaker;
    private final MapShape mapShape;

    public GameController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.bridgeGame = new BridgeGame();
        this.mapShape = new MapShape();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    public void run() {
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        while(keepGoing && i < bridgeSize){
            String nextMove = inputView.readMoving();
            String moveResult = bridgeGame.move(bridge.get(i), nextMove);
            outputView.printMap(nextMove, moveResult);
            i++;
            if(moveResult.matches(FAIL_CASE)) bridgeGame.retry();
        }
        outputView.printResult(tryCount, keepGoing);
    }

    public void checkKeepGoing(String resetCommand) {
        if(resetCommand.matches(RESET_COMMAND)) {
            i = 0;
            tryCount++;
            mapShape.clearMap();
        }
        if(resetCommand.matches(QUIT_COMMAND))
            keepGoing = false;
    }
}
