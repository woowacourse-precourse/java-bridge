package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static int cnt;

    public static void main(String[] args) {
        outputView.printStart();

        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = makeBridge(bridgeSize);

        List<String> result = new ArrayList<>();
        String gameStatus = tryGame(bridge, result);
        cnt = 1;

        gameStatus = retryGame(gameStatus, bridge, result);

        outputView.printResult(gameStatus, cnt, result, bridge);
    }

    private static List<String> makeBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static String tryGame(List<String> bridge, List<String> result) {
        for (int i = 0; i < bridge.size(); i++) {
            String movingValue = inputView.readMoving();
            String movingResult = bridgeGame.move(movingValue, bridge.get(i));
            result.add(movingResult);
            outputView.printMap(result, bridge);
            if (result.contains("X")) {
                return "실패";
            }
        }
        return "성공";
    }

    private static String retryGame(String gameStatus, List<String> bridge, List<String> result) {
        while (gameStatus.equals("실패")) {
            String regameInput = inputView.readGameCommand();
            if (regameInput.equals("Q")) break;
            result = bridgeGame.retry(result);
            gameStatus = tryGame(bridge, result);
            cnt += 1;
        }
        return gameStatus;
    }
}
