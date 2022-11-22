package bridge;

import java.util.List;
import types.BridgeType;
import types.MoveResult;
import types.RetryCommand;
import views.InputView;
import views.OutputView;


public class GameMachine {
    private InputView ui = new InputView();
    private OutputView view = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private List<BridgeType> bridge;
    private BridgeGame bridgeGame;
    private int counter;

    public GameMachine() {
        bridge = makeBridge();
        bridgeGame = new BridgeGame(bridge);
        counter = 1;
    }

    public void run() {
        start();
        RetryCommand retry = RetryCommand.RETRY;
        while (retry == RetryCommand.RETRY) {
            bridgeGame.retry();
            MoveResult gameResult = play();
            retry = gameAfter(gameResult);
        }
        end();
    }

    private void start() {
        view.printBridgeSizeRequest();
        view.printStart();
    }

    private RetryCommand gameAfter(MoveResult gameResult) {
        if (gameResult == MoveResult.FAIL) {
            view.printRestartRequest();
            counter++;
            return RetryCommand.of(ui.readGameCommand());
        }
        return RetryCommand.QUIT;
    }

    private void end() {
        view.printResult();
        view.printGameCount(counter);
    }


    private MoveResult play() {
        for (int location = 0; location < bridge.size(); location++) {
            MoveResult moveResult = move();
            if (moveResult == MoveResult.FAIL) {
                view.printMap(bridge, location, MoveResult.FAIL);
                return MoveResult.FAIL;
            }
            view.printMap(bridge, location, MoveResult.PASS);
        }
        return MoveResult.PASS;

    }
    private MoveResult move() {
        view.printMoveTypeRequest();
        BridgeType userInput = BridgeType.of(ui.readMoving());
        MoveResult moveResult = bridgeGame.move(userInput);
        return moveResult;
    }


    private List<BridgeType> makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );
        return BridgeType.toBridge(bridge);
    }
}
