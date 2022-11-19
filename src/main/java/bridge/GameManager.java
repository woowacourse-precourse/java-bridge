package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 게임을 관리해주는 역할을 한다.
 */
public class GameManager {
    InputView inputView;
    OutputView ouputView;
    BridgeMaker bridgeMaker;
    List<String> bridge;

    public GameManager(InputView input, OutputView output, BridgeRandomNumberGenerator generator) {
        this.inputView = input;
        this.ouputView = output;
        this.bridgeMaker = new BridgeMaker(generator);
    }

    public void start() {
        ouputView.printGameStart();
        boolean activation = true;
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        int round = 0;

        while (activation) {
            String moving = inputView.readMoving();
            List<List<String>> result = bridgeGame.move(round, moving);
            List<String> upResult = result.get(0);
            List<String> downResult = result.get(1);
            ouputView.printMap(upResult, downResult);
            round++;

            if (upResult.contains(" X ") || downResult.contains(" X ")) {
                activation = retry();
                bridgeGame.retry();
                round = 0;
            }

            if (round == bridgeSize) {
                activation = false;
            }
        }
    }

    public boolean retry() {
        String command = inputView.readGameCommand();
        return Objects.equals(command, "R");
    }
}
