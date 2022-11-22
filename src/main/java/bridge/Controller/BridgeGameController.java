package bridge.Controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.Model.BridgeGame;
import bridge.Model.BridgeMaker;
import bridge.View.InputView;
import bridge.View.OutputView;

import java.util.List;
import java.util.Objects;

import static bridge.Constant.Constant.START_BRIDGE_GAME;
import static bridge.Constant.Constant.SUCCESS;

public class BridgeGameController {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public BridgeGameController() {
    }

    public void playGame() {
        System.out.println(START_BRIDGE_GAME);
        List<String> bridge = createBridge(inputView.readBridgeSize());
        BridgeGame bridgeGame = new BridgeGame(bridge);

        GameStart(bridgeGame);
        outputView.printResult(bridgeGame.getUp(), bridgeGame.getDown(), bridgeGame);
    }

    private List<String> createBridge(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(size);
    }

    private void GameStart(BridgeGame bridgeGame) {
        moveBridge(bridgeGame);
        restart(bridgeGame);
    }

    public void moveBridge(BridgeGame bridgeGame) {
        for (int i = 0; i < bridgeGame.getBridge().size(); i++) {
            boolean success = bridgeGame.move(inputView.readMoving(), i);
            outputView.printMap(bridgeGame.getUp(), bridgeGame.getDown());
            if (!success) {
                return;
            }
        }
    }

    public void restart(BridgeGame bridgeGame) {
        if (Objects.equals(bridgeGame.whenSuccess(), SUCCESS)) {
            return;
        }
        String restartCommand = inputView.readGameCommand();
        if (restartCommand.equals("R")) {
            bridgeGame.retry();
            GameStart(bridgeGame);
        }
    }
}
