package bridge;

import bridge.types.BridgeType;
import bridge.types.MoveResult;
import bridge.types.RetryCommand;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

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
