package bridge.domain;

import static bridge.Constants.FAIL_MESSAGE;
import static bridge.Constants.UP_BRIDGE;
import static bridge.Constants.DOWN_BRIDGE;
import static bridge.Constants.PASS_MESSAGE;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private int index = 0;

    List<String> upBridge = new ArrayList<>();
    List<String> downBridge = new ArrayList<>();


    BridgeGame(List<String> bridge) {
        this.bridge = bridge;
    }

    //사용자가 칸을 이동할 때 사용하는 메서드
    public boolean move(String inputPosition) {
        if (inputPosition.equals(bridge.get(index))) {
            addPass(inputPosition);
            index++;
            return true;
        }
        addFail(inputPosition);
        index++;
        return false;
    }

    private ListAdder choiceAdder(String inputPosition) {
        ListAdder adder = null;
        if (Objects.equals(inputPosition, UP_BRIDGE)) {
            adder = new UpAdder(upBridge, downBridge);
        }
        if (Objects.equals(inputPosition, DOWN_BRIDGE)) {
            adder = new DownAdder(upBridge, downBridge);
        }
        return adder;
    }

    private void addPass(String inputPosition) {
        ListAdder adder = choiceAdder(inputPosition);
        adder.add(PASS_MESSAGE);
    }

    private void addFail(String inputPosition) {
        ListAdder adder = choiceAdder(inputPosition);
        adder.add((FAIL_MESSAGE));
    }

    //사용자가 게임을 다시 시도할 때 사용하는 메서드
    public void retry() {
        index = 0;
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
    }

    public int getIndex() {
        return index;
    }

    public List<String> getUpBridge() {
        return upBridge;
    }

    public List<String> getDownBridge() {
        return downBridge;
    }
}
