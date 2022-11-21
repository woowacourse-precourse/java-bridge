package bridge;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

/**
 * 게임을 관리해주는 역할을 한다.
 */
public class GameManager {
    private final InputView inputView;
    private final OutputView ouputView;

    public GameManager(InputView input, OutputView output) {
        this.inputView = input;
        this.ouputView = output;
    }

    public void start() {
        ouputView.printGameStart();
        int bridgeSize = getBridgeSize();
        BridgeGame bridgeGame = new BridgeGame(bridgeSize);
        boolean activation = true;
        int round = 0;
        int tried = 1;
        List<String> upResult = new ArrayList<>();
        List<String> downResult = new ArrayList<>();

        while (activation) {
            String moving = getMoving();
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
                if (activation) {
                    tried++;
                }
            }

            if (round == bridgeSize) {
                activation = false;
            }
        }

        ouputView.printResult(Arrays.asList(upResult, downResult), isSuccess(upResult, downResult), tried);
    }

    public boolean isRetried() {
        String command = getGameCommand();
        return Objects.equals(command, "R");
    }

    public String isSuccess(List<String> upResult, List<String> downResult) {
        String success = "실패";

        if (!upResult.contains(" X ") && !downResult.contains(" X ")) {
            success = "성공";
        }

        return success;
    }

    public int getBridgeSize() {
        try {
            return inputView.readBridgeSize();
        } catch (IllegalArgumentException e) {
            ouputView.printException(e.getMessage());
            return getBridgeSize();
        }
    }

    public String getMoving() {
        try {
            return inputView.readMoving();
        } catch (IllegalArgumentException e) {
            ouputView.printException(e.getMessage());
            return getMoving();
        }
    }

    public String getGameCommand() {
        try {
            return inputView.readGameCommand();
        } catch (IllegalArgumentException e) {
            ouputView.printException(e.getMessage());
            return getGameCommand();
        }
    }
}
