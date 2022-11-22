package bridge;

import bridge.domain.GameResult;
import bridge.domain.MovingResult;
import bridge.logic.BridgeGame;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import bridge.view.View;
import java.util.List;

public class GameController {

    private final View view;
    private final BridgeGame bridgeGame;

    public GameController(View view, BridgeGame bridgeGame) {
        this.view = view;
        this.bridgeGame = bridgeGame;
    }

    public void play(Integer countOfTry) {
        List<String> bridge = createBridge();

        if (movePlayer(bridge, countOfTry)) {
            end("성공", countOfTry);
        }

        end("실패", countOfTry);
    }

    private List<String> createBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);

        view.printStartGame();
        int size = view.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }

    private boolean movePlayer(List<String> bridge, Integer countOfTry) {
        while (!canCrossBridge(bridge)) {
            String gameCommand = view.readGameCommand();
            if (!bridgeGame.retry(gameCommand)) {
                return false;
            }

            countOfTry++;
            view.initMap();
        }

        return true;
    }

    private boolean canCrossBridge(List<String> bridge) {
        for (int length = bridge.size(), round = 0; round < length; round++) {
            String moving = view.readMoving();
            MovingResult movingResult = bridgeGame.move(moving, bridge, round);
            view.printMap(movingResult);

            if (!movingResult.isSuccess()) {
                return false;
            }
        }

        return true;
    }

    private void end(String result, int countOfTry) {
        GameResult gameResult = new GameResult(result, countOfTry);
        view.printResult(gameResult);
    }

}
