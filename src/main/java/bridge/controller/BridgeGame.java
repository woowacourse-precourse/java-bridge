package bridge.controller;

import bridge.domain.User;
import bridge.service.BridgeService;
import bridge.service.GameService;
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

        List<String> bridge = BridgeService.initBridge(bridgeSize);
        User user = UserService.generateUserResult();

        startGame(bridge, user);
        endGame(bridge, user);
    }

    private void endGame(List<String> bridge, User user) {
        OutputView.printResult(user);
        if(user.sameBridgeSize(bridge.size())){
            OutputView.printSuccess();
            return;
        }
        OutputView.printFail();
    }

    private void startGame(List<String> bridge, User user) {
        UserService.initUserResult(user);
        move(bridge, user);

        if(user.sameBridgeSize(bridge.size())){
            return;
        }
        retry(bridge, user);
    }

    public void move(List<String> bridge, User user) {
        while (user.lessThanBridgeSize(bridge.size())) {
            boolean crossResult = canCross(bridge, user);
            OutputView.printMap(user);
            if(!crossResult){
                return;
            }
            user.increaseCount();
        }
    }

    private boolean canCross(List<String> bridge, User user) {
        String userMoving;
        do {
            userMoving = InputView.readMoving();
        }while (userMoving == "error");

        if(GameService.judgeMoving(bridge, user,userMoving)){
            return true;
        }
        return false;
    }

    public void retry(List<String> bridge, User user) {
        OutputView.printRetry();
        String retryInput;
        do {
            retryInput = InputView.readGameCommand();
        }while(retryInput == "error");
        if(retryInput.equals("R")){
            user.increaseTryCount();
            startGame(bridge, user);
        }
    }

}
