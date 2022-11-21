package bridge.controller;

import bridge.domain.UserResult;
import bridge.service.BridgeGameService;
import bridge.service.GameResultService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private int count;
    private int tryCount;

    public void runGame() {
        String bridgeSize;
        do {
            bridgeSize = InputView.readBridgeSize();
        }while (bridgeSize == "error");

        List<String> bridge = BridgeGameService.initBridge(bridgeSize);
        tryCount = BridgeGameService.initTryCount();

        startGame(bridge);
        endGame(count,tryCount,bridge);
    }

    private void endGame(int count, int tryCount,List<String> bridge) {
        OutputView.printResult(tryCount,count);
        if(count == bridge.size()){
            OutputView.printSuccess();
            return;
        }
        OutputView.printFail();
    }

    private void startGame(List<String> bridge) {
        UserResult userResult = GameResultService.initGameResult();
        count = BridgeGameService.initCount();
        move(bridge, userResult);

        if(count==bridge.size()){
            return;
        }
        retry(bridge);
    }

    public void move(List<String> bridge, UserResult userResult) {
        while (count < bridge.size()) {
            if(!(canCross(bridge,count, userResult))){
                OutputView.printMap(userResult);
                return;
            }
            count ++ ;
            OutputView.printMap(userResult);
        }
    }

    private boolean canCross(List<String> bridge, int count, UserResult userResult) {
        String userMoving;
        do {
            userMoving = InputView.readMoving();
        }while (userMoving == "error");
        String movingResult = bridge.judgeMoving(userMoving,count);
        userResult.recordResult(movingResult,userMoving);
        if(movingResult.equals("O")){
            return true;
        }
        return false;
    }

    public void retry(List<String> bridge) {
        OutputView.printRetry();
        String retryInput;
        do {
            retryInput = InputView.readGameCommand();
        }while(retryInput == "error");
        if(retryInput.equals("R")){
            tryCount ++ ;
            startGame(bridge);
        }
    }

}
