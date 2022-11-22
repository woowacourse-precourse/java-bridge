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

    private int counter;
    public void run() {
        view.printBridgeSizeRequest();
        List<BridgeType> bridge = makeBridge();
        BridgeGame bridgeGame = new BridgeGame(bridge);

        int counter = 1;
        view.printStart();
        RetryCommand retry = RetryCommand.RETRY;
        while (retry == RetryCommand.RETRY) {
            bridgeGame.retry();
            MoveResult gameResult = play(bridge, bridgeGame);

            if (gameResult == MoveResult.FAIL) {
                view.printRestartRequest();
                retry = RetryCommand.of(ui.readGameCommand());
                counter++;
                continue;
            }
            retry = RetryCommand.QUIT;
        }
        view.printResult();
        view.printGameCount(counter);
    }

    private MoveResult play(List<BridgeType> bridge, BridgeGame bridgeGame) {
        for (int location = 0; location < bridge.size(); location++) {
            view.printMoveTypeRequest();
            BridgeType userInput = BridgeType.of(ui.readMoving());
            if (MoveResult.FAIL == bridgeGame.move(userInput)) {
                view.printMap(bridge, location, MoveResult.FAIL);
                return MoveResult.FAIL;
            }
            view.printMap(bridge, location, MoveResult.PASS);
        }
        return MoveResult.PASS;

    }

    private List<BridgeType> makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );
        return BridgeType.toBridge(bridge);
    }
}
