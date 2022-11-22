package bridge;

import static bridge.Util.toInt;

import java.util.List;

public class Controller {

    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    BridgeGame bridgeGame;

    public void run() {
        List<String> bridge = makeBridge();
        bridgeGame = new BridgeGame(bridge);

    }

    public List<String> makeBridge() {
        try {
            int size = toInt(inputView.readBridgeSize());
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            return bridgeMaker.makeBridge(size);
        } catch (IllegalArgumentError e) {
            return makeBridge();
        }
    }


    // 건널 수 있을 때 까지 건너기
    public void crossBridgeToEnd() {
        while (!bridgeGame.isCleared()) {
            if (!move()) {
                break;
            }
        }
    }

    public boolean move() {
        try {
            Direction nextDirection = Direction.toDirection(inputView.readMoving());
            boolean moved = bridgeGame.move(nextDirection);
            return moved;
        } catch (IllegalArgumentError e) {
            return move();
        }
    }


}
