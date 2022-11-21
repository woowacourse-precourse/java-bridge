package bridge.controller;

import bridge.domain.UserResult;
import bridge.service.BridgeGameService;
import bridge.service.MovingService;
import bridge.service.UserService;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    public void runGame() {
        String bridgeSize;
        do {
            bridgeSize = InputView.readBridgeSize();
        }while (bridgeSize == "error");

        List<String> bridge = BridgeGameService.initBridge(bridgeSize);
        UserResult userResult = UserService.generateUserResult();

        startGame(bridge,userResult);
        endGame(bridge, userResult);
    }

    private void endGame(List<String> bridge, UserResult userResult) {
        OutputView.printResult(userResult);
        if(userResult.sameBridgeSize(bridge.size())){
            OutputView.printSuccess();
            return;
        }
        OutputView.printFail();
    }

    private void startGame(List<String> bridge, UserResult userResult) {
        UserService.initUserResult(userResult);
        move(bridge, userResult);

        if(userResult.sameBridgeSize(bridge.size())){
            return;
        }
        retry(bridge,userResult);
    }

    public void move(List<String> bridge, UserResult userResult) {
        while (userResult.lessThanBridgeSize(bridge.size())) {
            if(!(canCross(bridge,userResult))){
                OutputView.printMap(userResult);
                return;
            }
            userResult.upCount();
            OutputView.printMap(userResult);
        }
    }

    private boolean canCross(List<String> bridge, UserResult userResult) {
        String userMoving;
        do {
            userMoving = InputView.readMoving();
        }while (userMoving == "error");

        if(MovingService.judgeMoving(bridge,userResult,userMoving)){
            return true;
        }
        return false;
    }

    public void retry(List<String> bridge, UserResult userResult) {
        OutputView.printRetry();
        String retryInput;
        do {
            retryInput = InputView.readGameCommand();
        }while(retryInput == "error");
        if(retryInput.equals("R")){
            userResult.plusTryCoint();
            startGame(bridge,userResult);
        }
    }

}
