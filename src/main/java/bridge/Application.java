package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    public static void main(String[] args) {
        outputView.printStart();
        int cnt = 0;

        int bridgeSize = inputView.readBridgeSize();

        List<String> bridge = makeBridge(bridgeSize);

        BridgeGame bridgeGame = new BridgeGame();
        List<String> result = new ArrayList<>();
        String gameStatus = tryGame(bridgeGame, bridge, result);
        cnt += 1;

        String regameStatus = "";
        while (gameStatus.equals("실패") && !regameStatus.equals("Q")) {
            regameStatus = inputView.readGameCommand();
            if (regameStatus.equals("R")) {
                result = new ArrayList<>();
                gameStatus = tryGame(bridgeGame, bridge, result);
                cnt += 1;
            }
        }

        outputView.printResult(gameStatus, cnt, result, bridge);
    }

    private static List<String> makeBridge(int bridgeSize) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static String tryGame(BridgeGame bridgeGame, List<String> bridge, List<String> result) {
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
}
