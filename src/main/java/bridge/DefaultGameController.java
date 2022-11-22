package bridge;

import java.util.List;

public class DefaultGameController implements GameController {
    BridgeGame game;
    private static final String QUIT_SIGN = "Q";

    @Override
    public void initGame() {
        BridgeNumberGenerator randomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(randomNumberGenerator);
        OutputView.printStartGame();
        int size = InputView.readBridgeSizeUntilSuccess();
        game = new BridgeGame(bridgeMaker.makeBridge(size));
    }

    /**
     * @return 게임 종료조건 충족시 false 리턴하면 된다
     */
    @Override
    public boolean gameFlow() {
        String direction = InputView.readMovingUntilSuccess();
        boolean isAvailable = game.move(direction);
        OutputView.printMap(game.getCrossedBridge(), isAvailable);
        if (isEnd(isAvailable, game.getCrossedBridge(), game)) {
            OutputView.printResult(game.getCrossedBridge(), isAvailable, game.getTries());
            return false;
        }
        return true;
    }

    private boolean isEnd(boolean isAvailable, List<String> history, BridgeGame game) {
        if (isAvailable && !game.isMapSizeSameWith(history.size())) {
            return false;
        }
        if (isAvailable || InputView.readGameCommandUntilSuccess().equals(QUIT_SIGN)) {
            return true;
        }
        game.retry();
        return false;
    }
}
