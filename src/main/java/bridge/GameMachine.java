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
        RetryCommand retry = RetryCommand.RETRY;
        while (retry == RetryCommand.RETRY) {
            play();
            retry = RetryCommand.of(ui.readGameCommand());
        }
    }

    private void play() {
        List<BridgeType> bridge = makeBridge();
        bridge.stream().forEach(a -> System.out.println(a));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int location = 0; location < bridge.size(); location++) {
            BridgeType userInput = BridgeType.of(ui.readMoving());
            if (MoveResult.FAIL == bridgeGame.move(userInput)) {
                System.out.println("FAIL");
                return;
            }
            System.out.println("PASS");
        }

    }

    private List<BridgeType> makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );
        return BridgeType.toBridge(bridge);
    }
}
