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

    private int counter;

    public GameMachine() {
        view.printStart();
        view.printBridgeSizeRequest();

        bridge = makeBridge();
        bridgeGame = new BridgeGame(bridge);
        counter = 1;
    }

    public void run() {
        RetryCommand respond;
        do {
            MoveResult gameResult = play();
            respond = askRetryByResult(gameResult);
        } while (respond == RetryCommand.RETRY);
        end();
    }

    private RetryCommand askRetryByResult(MoveResult gameResult) {
        RetryCommand respond = RetryCommand.QUIT;

        if (gameResult == MoveResult.FAIL) {
            view.printRestartRequest();
            counter++;
            respond = RetryCommand.of(ui.readGameCommand());
        }

        return respond;
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
