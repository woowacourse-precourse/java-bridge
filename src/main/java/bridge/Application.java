package bridge;

import java.util.List;

public class Application {

    private static final String GAME_START = "다리 건너기 게임을 시작합니다.";

    public static void main(String[] args) {
        OutputView.printMessage(GAME_START);

        BridgeGame bridgeGame = new BridgeGame(makeBridge());
        bridgeGame.progress();
    }

    private static List<String> makeBridge() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        return bridgeMaker.makeBridge(getBridgeSize());
    }

    private static int getBridgeSize() {
        InputView inputView = new InputView();
        return inputView.getBridgeSize();
    }
}
