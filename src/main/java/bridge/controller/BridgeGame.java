package bridge.controller;

import bridge.BridgeRandomNumberGenerator;
import bridge.model.BridgeComparator;
import bridge.model.BridgeMaker;
import bridge.model.UserBridgeCorrector;
import bridge.presentation.InputView;
import bridge.presentation.OutputView;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();
    BridgeComparator compareBridge = new BridgeComparator();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move(List<String> userSelectResult) {
        UserBridgeCorrector userBridgeCorrector = new UserBridgeCorrector();
        outputView.moveGuide();
        String movement = inputView.readMoving();
        // 입력에 대한 예외 검사 추가
        userSelectResult = userBridgeCorrector.addBridge(movement,userSelectResult);
        return userSelectResult;
    }//move

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        inputView.readGameCommand();
        // 입력에 대한 예외 검사 추가
    }// retry

    public List<String> make() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        int size = inputView.readBridgeSize();
        return bridgeMaker.makeBridge(size);
    }//make

    public void startSetUp() {
        outputView.startGuide();
        // 길이에 대한 에외 검사 추가
    }//lengthens

    public boolean isSuccess(List<String> userSelectResult,List<String> computerBridge) {
        boolean success= compareBridge.isSame(userSelectResult,computerBridge);
        outputView.printMap(userSelectResult,success);

        return success;
    }//compare
} // end class
