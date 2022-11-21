package bridge;

import static bridge.Constant.*;

import bridge.BridgeGame.MoveResult;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        BridgeGame bridgeGame = startGame();
    }

    public static BridgeGame startGame() {
        System.out.println(MESSAGE_GAME_START);
        System.out.println(MESSAGE_ENTER_LENGTH);
        InputView inputView = new InputView();
        int length = inputView.readBridgeSize();
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(length);
        return new BridgeGame(bridge);
    }
}
