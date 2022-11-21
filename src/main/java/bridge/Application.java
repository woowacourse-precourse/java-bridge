package bridge;

import java.util.List;

public class Application {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        OutputView.printMessage(GAME_START);

        InputView inputView = new InputView();
        int bridgeSize = inputView.getBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridge = " + bridge);

        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.progress();
    }

}
