package bridge;

import bridge.domain.GameResult;
import bridge.domain.MovingResult;
import bridge.view.View;
import java.util.List;

public class GameController {

    private final View view;
    private final List<String> bridge;
    private final BridgeGame bridgeGame;

    public GameController(View view, List<String> bridge, BridgeGame bridgeGame) {
        this.view = view;
        this.bridge = bridge;
        this.bridgeGame = bridgeGame;
    }

    public void play(int countOfTry, int round) {
        while (round != bridge.size()) {
            MovingResult movingResult = bridgeGame.move(view, bridge, round++);
            view.printMap(movingResult);

            if (movingResult.isSuccess()) {
                continue;
            }

            if (!bridgeGame.retry(view)) {
                GameResult gameResult = new GameResult("실패", countOfTry);
                view.printResult(gameResult);
                continue;
            }

            countOfTry++;
            round = 0;
            view.initMap();
        }

        GameResult gameResult = new GameResult("성공", countOfTry);
        view.printResult(gameResult);
    }

}
