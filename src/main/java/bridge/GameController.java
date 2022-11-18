package bridge;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    private OutputView outputView =new OutputView();
    private InputView inputView = new InputView();
    private BridgeGame bridgeGame = new BridgeGame();
    public void begin(){
        outputView.gameStartMessage();
        outputView.bridgeSizeMessage();

        int size = inputView.readBridgeSize();

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> answer_bridge = bridgeMaker.makeBridge(size);
        bridgeGame.move();
    }
}
