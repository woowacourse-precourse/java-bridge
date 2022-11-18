package bridge;

import java.util.List;

/**
 * 게임의 진행을 관리하는 역할을 한다.
 */
public class GameController {
    public void begin(){
        OutputView outputView =new OutputView();
        outputView.gameStartMessage();
        outputView.bridgeSizeMessage();

        InputView inputView = new InputView();
        int size = inputView.readBridgeSize();
        System.out.println(size);

        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> answer_bridge = bridgeMaker.makeBridge(size);
        System.out.println(answer_bridge);
    }
}
