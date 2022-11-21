package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final BridgeGameProcessor bridgeGameProcessor = new BridgeGameProcessor(bridgeGame, inputView, outputView);

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        // 다리 생성
        outputView.printIntro();
        List<String> bridge = bridgeMaker.makeBridge(inputView.readBridgeSize());

        // 다리 건너기
        List<String> route = new ArrayList<>();
        bridgeGameProcessor.start(bridge, route);

        // 게임 종료

    }
}
