package bridge.service;

import bridge.domain.Attempt;
import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Result;

import java.util.ArrayList;
import java.util.List;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeGameService {

    private Attempt attempt;
    private Bridge bridge;
    private List<String> user;

    /**
     * 게임을 시작할 때 사용하는 메서드
     */
    public void start() {
        printStart();
        attempt = Attempt.begin();
        bridge = Bridge.make(readBridgeSize());
    }

    public Result move() {
        attempt.increase();
        user = new ArrayList<>();
        while (bridge.isProceeding(user)) {
            printMoveOptionInput();
            user.add(readMoving());
            printMap(bridge, user);
            if (bridge.compare(user).equals(Result.FAIL)) {
                return Result.FAIL;
            }
        }
        return Result.SUCCESS;
    }

    public Command retry() {
        printRestartOptionInput();
        return readGameCommand();
    }

    public void finish() {
        printResult(bridge, user, attempt);
    }
}
