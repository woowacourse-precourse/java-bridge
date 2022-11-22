package bridge;

import java.util.List;
import java.util.Objects;

public class Application {

    private static final InputView iv = new InputView();
    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final OutputView ov = new OutputView(bridgeGame);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ov.printGuide();
        int bridgeSize = iv.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        playGame(bridge);
        System.out.println();
        ov.printResult();
    }

    public static void playGame(List<String> bridge) {
        for (String bridgeData : bridge) {
            String inputMoving = iv.readMoving();
            String nowResult = bridgeGame.getNowResult(bridgeData, inputMoving);
            if (!Objects.equals(nowResult, null)) {
                doIfNowResultIsNotNull(nowResult, bridge, inputMoving);
                break;
            }
            ov.printMap(inputMoving);
        }
    }

    public static void doIfNowResultIsNotNull(String nowResult, List<String> bridge, String inputMoving) {
        if (Objects.equals(nowResult, "Q")) {
            ov.printMapWhenFailed(inputMoving);
        }
        if (Objects.equals(nowResult, "R")) {
            bridgeGame.retry();
            playGame(bridge);
        }
    }
}

