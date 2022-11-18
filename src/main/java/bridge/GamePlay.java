package bridge;

import java.util.List;

public class GamePlay {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;

    public GamePlay() {
        this.inputView = new InputView();
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    private List<String> start() {
        final String EVENT_MESSAGE = "다리 건너기 게임을 시작합니다.\n\n다리의 길이를 입력해주세요.";

        System.out.println(EVENT_MESSAGE);
        int bridgeSize = this.inputView.readBridgeSize();
        List<String> bridge = this.bridgeMaker.makeBridge(bridgeSize);

        return bridge;
    }
}
