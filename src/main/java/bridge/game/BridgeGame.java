package bridge.game;

import bridge.domain.BridgeMaker;
import bridge.domain.BridgeNumberGenerator;
import bridge.view.InputView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public List<String> move() {
        List<String> userMoving = new ArrayList<>();

        userMoving.add(InputView.readMoving());

        return userMoving;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {

    }

    private int addTryCount(int tryCount){
        return 0;
    }

    public int CompareUserValue(String userValue, String bridgeValue){
        return 0;
    }

    public HashMap<Integer, String> correctValue(int compareValue, String userValue){
        return null;
    }

    public HashMap<Integer, String> wrongValue(int compareValue, String userValue){
        return null;
    }
}
