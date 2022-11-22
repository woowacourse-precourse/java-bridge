package bridge;

public class BridgeGameStart {
    public BridgeGame start(BridgeMaker bridgeMaker, InputView inputView) {
        return new BridgeGame(bridgeMaker.makeBridge(inputView.readBridgeSize()));
    }

}
