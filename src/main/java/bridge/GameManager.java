package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 게임을 관리해주는 역할을 한다.
 */
public class GameManager {
    InputView inputView;
    OutputView ouputView;
    BridgeMaker bridgeMaker;
    List<String> bridge;
    List<String> upResult = new ArrayList<>();
    List<String> downResult = new ArrayList<>();

    public GameManager(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.ouputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void start() {
        ouputView.printGameStart();
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int round = 0; round < bridgeSize; round++) {
            String moving = inputView.readMoving();
            String[] result = bridgeGame.move(round, moving);
            setGameResult(result);
            ouputView.printMap(upResult, downResult);
        }
    }

    public void setGameResult(String[] result) {
        upResult.add(result[1]);
        upResult.add("|");
        downResult.add(result[0]);
        downResult.add("|");
    }
}
