package bridge;

import java.util.List;
import java.util.Objects;

public class Application {

    static InputView iv = new InputView();
    static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    static BridgeGame bridgeGame = new BridgeGame();
    static OutputView ov = new OutputView(bridgeGame);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        int bridgeSize = iv.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println(bridge);
        playGame(bridge);
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
        ov.printResult();
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

