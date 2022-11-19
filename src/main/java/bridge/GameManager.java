package bridge;

import java.util.List;

/**
 * 게임을 관리해주는 역할을 한다.
 */
public class GameManager {
    InputView inputView;
    OutputView ouputView;
    BridgeMaker bridgeMaker;


    public GameManager(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.ouputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void start() {
        ouputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        String moving = "";
        for (int i = 0; i < bridgeSize; i++) {
            moving = inputView.readMoving();
        }
    }
}
