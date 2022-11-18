package bridge;

import java.util.List;

public class GamePlay {
    private final InputView inputView;
    private final List<String> bridge;
    // private final BridgeMaker bridgeMaker;

    public GamePlay() {
        this.inputView = new InputView();
        this.bridge = start();

    }

    private List<String> start() {
        final String EVENT_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

        System.out.println(EVENT_MESSAGE);
        int bridgeSize = this.inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }
}
