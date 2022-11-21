package bridge.domain;

import bridge.Exception.QuitGameException;
import bridge.Exception.SuccessGameException;
import bridge.validator.Unit;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    private final List<String> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String userInput) {
        BridgeRecord.addUserInput(userInput);
    }

    public StageResult compareInputWithBridge(String userInput) {
        int currentStage = BridgeStage.currentStage();

        if(bridge.get(currentStage).equals(userInput)) {
            if(BridgeStage.isFinalStage(bridge.size())) {
                return StageResult.SUCCESS;
            }
            return StageResult.PASS;
        }
        return StageResult.FAIL;
    }

    public StageResult processStage(String userInput) {
        move(userInput);

        StageResult stageResult = compareInputWithBridge(userInput);

        return stageResult;
    }

    public void pass() {
        BridgeStage.nextStage();
    }


    public void success() {
        throw new SuccessGameException();
    }

    public void quit() {
        throw new QuitGameException();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        BridgeStage.resetStage();
        BridgeStage.increaseRetry();
        BridgeRecord.resetRecord();
    }
}
