package bridge;

import java.util.List;

public class GameMachine {
    private InputView ui = new InputView();
    private OutputView view = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );

        play(bridge);
    }

    private void play(List<String> bridge) {
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int location = 0; location <= bridge.size(); location++) {
            String userInput = ui.readMoving();
            if (MoveResult.FAIL == bridgeGame.move(userInput)) {
                System.out.println("FAIL");
                return;
            }
            System.out.println("pass");
        }

    }
}
