package bridge;

import java.util.List;
import view.InputView;
import view.OutputView;


public class GameMachine {
    private InputView ui = new InputView();
    private OutputView view = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );

        play(BridgeType.toBridge(bridge));
    }

    private void play(List<BridgeType> bridge) {
        System.out.println(bridge);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int location = 0; location <= bridge.size(); location++) {
            BridgeType userInput = BridgeType.of(ui.readMoving());
            if (MoveResult.FAIL == bridgeGame.move(userInput)) {
                System.out.println("FAIL");
                return;
            }
            System.out.println("PASS");
        }

    }
}
