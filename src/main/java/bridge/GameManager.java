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
        int bridgeSize = inputView.readBridgeSize();
        bridge = bridgeMaker.makeBridge(bridgeSize);
        BridgeGame bridgeGame = new BridgeGame(bridge);
        boolean activation = true;
        int round = 0;
        int tried = 0;
        List<String> upResult = new ArrayList<>();
        List<String> downResult = new ArrayList<>();

        while (activation) {
            tried++;
            String moving = inputView.readMoving();
            List<List<String>> result = bridgeGame.move(round, moving);
            upResult = result.get(0);
            downResult = result.get(1);
            ouputView.printMap(upResult);
            ouputView.printMap(downResult);
            round++;

            if (upResult.contains(" X ") || downResult.contains(" X ")) {
                activation = isRetried();
                bridgeGame.retry();
                round = 0;
            }

            if (round == bridgeSize) {
                activation = false;
            }
        }

        ouputView.printResult(Arrays.asList(upResult, downResult), isSuccess(upResult, downResult), tried);
    }

    public boolean isRetried() {
        String command = inputView.readGameCommand();
        return Objects.equals(command, "R");
    }

    public String isSuccess(List<String> upResult, List<String> downResult) {
        String success = "실패";

        if (!upResult.contains(" X ") && !downResult.contains(" X ")) {
            success = "성공";
        }

        return success;
    }
}
