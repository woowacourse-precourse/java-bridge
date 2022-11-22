package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Attempt;
import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Result;

import static bridge.view.InputView.*;
import static bridge.view.OutputView.*;

public class BridgeGameService {

    private final BridgeMaker maker;
    private Attempt attempt;
    private Bridge bridge;
    private Bridge user;

    public BridgeGameService() {
        this.maker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    /**
     * 게임을 시작할 때 시도횟수 초기화와 다리를 생성하는 메서드
     */
    public void start() {
        printStart();
        attempt = Attempt.begin();
        bridge = Bridge.of(maker.makeBridge(readBridgeSize()));
    }

    public Result move() {
        attempt.increase();
        user = Bridge.start();
        while (bridge.isProceeding(user)) {
            printMoveOptionInput();
            user = user.move(readMoving());
            printMap(bridge, user);
            if (!bridge.isSuccess(user)) {
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
