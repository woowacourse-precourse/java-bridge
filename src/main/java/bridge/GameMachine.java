package bridge;

import bridge.types.BridgeType;
import bridge.types.MoveResult;
import bridge.types.RetryCommand;
import bridge.views.InputView;
import bridge.views.OutputView;

import java.util.List;

public class GameMachine {
    private InputView ui = new InputView();
    private OutputView view = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    private List<BridgeType> bridge;
    private BridgeGame bridgeGame;

    private int gameCounter;

    public GameMachine() {
        view.printStart();
        view.printBridgeSizeRequest();

        bridge = makeBridge();
        bridgeGame = new BridgeGame(bridge);
        gameCounter = 0;
    }

    public void run() {
        RetryCommand respond;
        do {
            bridgeGame.retry();
            MoveResult gameResult = play();
            respond = askRetry(gameResult);
        } while (respond == RetryCommand.RETRY);
        end();
    }

    private RetryCommand askRetry(MoveResult gameResult) {
        RetryCommand respond = RetryCommand.QUIT;

        if (gameResult == MoveResult.FAIL) {
            view.printRestartRequest();
            respond = RetryCommand.of(ui.readGameCommand());
        }

        return respond;
    }

    private void end() {
        view.printResult();
        view.printGameCount(gameCounter);
    }

    private MoveResult play() {
        gameCounter++;
        MoveResult result = MoveResult.PASS;
        for (int location = 0; location < bridge.size() && isPass(result); location++) {
            result = move();
            view.printMap(bridge, location, result);
        }
        return result;
    }

    private boolean isPass(MoveResult result) {
        return result == MoveResult.PASS;
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
