package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.service.BridgeService;
import bridge.service.MovingService;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static int count;
    private int tryCount;

    public void runGame() {
        Bridge bridge = initBridge();
        initTryCount();
        startGame(bridge);
    }

    private void initTryCount() {
        tryCount = 1;
    }

    private Bridge initBridge() {
        Integer bridgeSize = InputView.readBridgeSize();
        Bridge bridge = BridgeService.makeBridge(bridgeSize);
        return bridge;
    }

    private void startGame(Bridge bridge) {
        GameResult gameResult = initGameResult();
        initCount();
        move(bridge, gameResult);
        if(count == bridge.getBridgeLength()){
            OutputView.printResult(tryCount);
            return;
        }
        retry(bridge);
    }

    private void initCount() {
        count = 0;
    }

    private GameResult initGameResult() {
        return BridgeService.makeInitialGameResult();
    }


    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(Bridge bridge, GameResult gameResult) {
        while (count < bridge.getBridgeLength()) {
            String moveOrStop = judgeMoving(bridge, gameResult);
            if (moveOrStop.equals("X")){
                break;
            }
            count ++;
        }
    }

    private static String judgeMoving(Bridge bridge, GameResult gameResult) {
        String moving = InputView.readMoving();
        String passOrNot = MovingService.crossBridge(bridge, moving, count);
        gameResult.recordResult(passOrNot, moving);
        OutputView.printMap(gameResult);
        return passOrNot;
    }


    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(Bridge bridge) {
        String retryInput = InputView.readRetry();
        if(judgeRetry(retryInput)){
            tryCount += 1;
            startGame(bridge);
        }
    }

    private boolean judgeRetry(String retryInput) {
        if(retryInput.equals("R")){
            return true;
        }
        return false;
    }
}
