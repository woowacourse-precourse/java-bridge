package bridge.service;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.*;
import bridge.presentation.InputView;
import bridge.presentation.OutputView;

import java.util.List;


public class BridgeGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeComparator compareBridge = new BridgeComparator();

    public List<String> move(List<String> userSelectResult) {
        UserBridgeCorrector userBridgeCorrector = new UserBridgeCorrector();
        outputView.moveGuide();
        String movement = inputView.readMoving();
        // 입력에 대한 예외 검사 추가
        userSelectResult = userBridgeCorrector.addBridge(movement, userSelectResult);
        return userSelectResult;
    }//move

    public boolean retry(boolean UnitSuccess, boolean gameSuccess) {
        boolean restart = false;
        if (!(gameSuccess) && !(UnitSuccess)) {
            outputView.restartGuide();
            String command = inputView.readGameCommand();
            // 입력에 대한 예외 검사 추가
            GameRestarter gameRestarter = new GameRestarter();
            restart = gameRestarter.isRestart(command);
        }//if
        return restart;
    }// retry

    public List<String> make() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputView.readBridgeSize();
        // 길이에 대한 에외 검사 추가
        return bridgeMaker.makeBridge(size);
    }//make

    public void startSetUp() {
        outputView.startGuide();
    }//startSetUp

    public boolean isSuccess(List<String> userSelectResult, List<String> computerBridge) {
        boolean success = compareBridge.isSame(userSelectResult, computerBridge);
        outputView.printMap(userSelectResult, success);
        return success;
    }//isSuccess

    public boolean isGameSuccess(List<String> userSelectResult, List<String> computerBridge, boolean UnitSuccess) {
        GameJudge gameJudge = new GameJudge();
        return gameJudge.isOver(userSelectResult, computerBridge, UnitSuccess);
    }//isGameSuccess

} // end class
