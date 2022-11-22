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

    public void run() {
        int counter = 0;
        view.printStart();
        RetryCommand retry = RetryCommand.RETRY;
        while (retry == RetryCommand.RETRY) {
            play();
            view.printRestartRequest();
            retry = RetryCommand.of(ui.readGameCommand());
            counter++;
        }
        view.printResult();
        view.printGameCount(counter);
    }

    private void play() {
        view.printBridgeSizeRequest();
        List<BridgeType> bridge = makeBridge();
        bridge.stream().forEach(a -> System.out.println(a));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int location = 0; location < bridge.size(); location++) {
            view.printMoveTypeRequest();
            BridgeType userInput = BridgeType.of(ui.readMoving());
            if (MoveResult.FAIL == bridgeGame.move(userInput)) {
                view.printMap(bridge, location, MoveResult.FAIL);
                return;
            }
            view.printMap(bridge, location, MoveResult.PASS);
        }

    }

    private List<BridgeType> makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );
        return BridgeType.toBridge(bridge);
    }
}
