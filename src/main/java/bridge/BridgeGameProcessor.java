package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameProcessor {

    private BridgeGame bridgeGame;
    private InputView inputView;
    private OutputView outputView;

    public BridgeGameProcessor(BridgeGame bridgeGame, InputView inputView, OutputView outputView) {
        this.bridgeGame = bridgeGame;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start(List<String> bridge, List<String> route) {
        boolean gameContinue = true;
        do {
            gameContinue = routing(bridge, route);
        } while (gameContinue && !(route.size()==bridge.size()));
        if (!gameContinue) retry(bridge, route);
    }

    private boolean routing(List<String> bridge, List<String> route) {
        boolean isPossibleRoute;
        outputView.printChoosingMovingDirection();
        route = bridgeGame.move(inputView.readMoving(), route);
        isPossibleRoute = isPossibleRoute(route, bridge);
        return isPossibleRoute;
    }

    private boolean isPossibleRoute(List<String> route, List<String> bridge) {
        int currentLocation = route.size()-1;
        if (route.get(currentLocation).equals(bridge.get(currentLocation))) return true;
        return false;
    }

    private void retry(List<String> bridge, List<String> route) {
        outputView.printChoosingWhetherRestart();
        boolean isRetryWannted = bridgeGame.retry(inputView.readGameCommand());
        if (isRetryWannted) {
            start(bridge, route);
        }
    }

}
