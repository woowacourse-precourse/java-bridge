package bridge.model;

import bridge.model.BridgeMaker;
import bridge.model.BridgeNumberGenerator;
import bridge.model.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> upPresentBridge;
    private List<String> downPresentBridge;

    public BridgeGame(List<String> bridge) {
        this.bridge=bridge;
        upPresentBridge=new ArrayList<>();
        downPresentBridge=new ArrayList<>();
    }
    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void move(String userMove) {
        if(userMove=="U"){
            upPresentBridge.add("O");
            downPresentBridge.add("X");
            return;
        }
        upPresentBridge.add("X");
        downPresentBridge.add("O");
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    public List<String> getUpPresentBridge() {
        return upPresentBridge;
    }

    public List<String> getDownPresentBridge() {
        return downPresentBridge;
    }

    public List<String> getBridge() {
        return bridge;
    }
}
