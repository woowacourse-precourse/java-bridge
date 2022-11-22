package bridge.domain.player;

import bridge.domain.provider.BridgeGame;
import bridge.domain.provider.BridgeMaker;
import bridge.view.InputView;

public class Player {
    private final InputView inputView;
    private final BridgeMaker bridgeMaker;
    private final BridgeGame bridgeGame;

    public Player(InputView inputView, BridgeMaker bridgeMaker, BridgeGame bridgeGame) {
        this.inputView = inputView;
        this.bridgeMaker = bridgeMaker;
        this.bridgeGame = bridgeGame;
    }

    public void StartBridge() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        final int bridgeSize = inputView.readBridgeSize();
        bridgeGame.getBridge(bridgeSize);
    }

}
