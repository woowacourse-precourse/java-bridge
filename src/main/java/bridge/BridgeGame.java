package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.WordType.*;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final List<String> bridge;
    private final List<List<String>> bridgeMap;
    private List<String> upBridge;
    private List<String> downBridge;

    private int position;
    private int retryCount;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        this.bridgeMap = new ArrayList<>();
        bridgeMapGenerate();
        this.position = -1;
        this.retryCount = 1;
    }

    private void bridgeMapGenerate() {
        upBridge = new ArrayList<>();
        downBridge = new ArrayList<>();
        bridgeMap.add(upBridge);
        bridgeMap.add(downBridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(String direct) {
        position += 1;
        return isMove(direct);
    }

    private boolean isMove(String direct) {
        return bridge.get(position).equals(direct);
    }

    public boolean isEndBridge() {
        return bridge.size() == position + 1;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        removeBridgeMark();
        position -= 1;
        retryCount += 1;
    }

    private void removeBridgeMark() {
        upBridge.remove(position);
        downBridge.remove(position);
    }

    public void bridgeMark(String direct, boolean result) {
        String mark = getMarkToResult(result);

        if (direct.equals(UP.getWord())) {
            addBridgeMark(mark, NOT_CHOICE_MOVE_CHECK.getWord());
            return;
        }
        addBridgeMark(NOT_CHOICE_MOVE_CHECK.getWord(), mark);
    }

    private String getMarkToResult(boolean result) {
        if (result) {
            return MOVE_CHECK.getWord();
        }
        return NOT_MOVE_CHECK.getWord();
    }

    private void addBridgeMark(String upMark, String downMark) {
        upBridge.add(upMark);
        downBridge.add(downMark);
    }

    public List<List<String>> getBridgeMap() {
        return bridgeMap;
    }

    public int getRetryCount() {
        return retryCount;
    }
}
