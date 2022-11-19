package bridge.controller;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.service.BridgeGameService;
import bridge.service.GameResultService;
import bridge.view.InputView;
import bridge.view.OutputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private  int count;
    private int tryCount;

    public void runGame() {
        String bridgeSize = InputView.readBridgeSize();
        Bridge bridge = BridgeGameService.initBridge(bridgeSize);
        tryCount = BridgeGameService.initTryCount();
        startGame(bridge);
        OutputView.printResult(tryCount);
    }

    private void startGame(Bridge bridge) {
        GameResult gameResult = GameResultService.initGameResult();
        count = BridgeGameService.initCount();
        move(bridge, gameResult);

        if(count == bridge.getBridgeLength()){
            return;
        }
        retry(bridge);
    }

    public void move(Bridge bridge, GameResult gameResult) {
        while (count < bridge.getBridgeLength()) {
            if(canCross(bridge,count,gameResult)){
                return;
            }
            count ++;
        }
    }

    private boolean canCross(Bridge bridge, int count,GameResult gameResult) {
        String userMoving = InputView.readMoving();
        String d = bridge.judgeMoving(userMoving,count);
        gameResult.recordResult(d,userMoving);

        if(d.equals("X")){
            return false;
        }
        return true;
    }

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
