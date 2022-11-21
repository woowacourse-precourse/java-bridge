package bridge.controller;

import bridge.Util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.IntStream;


/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private List<String> myBridge;
    private int trial;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        myBridge = new ArrayList<>();
        trial = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String direction) {
        myBridge.add(direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        myBridge.remove(myBridge.size() - 1);
        trial++;
    }

    public List<String> getAnswerBridge() {
        return Collections.unmodifiableList(bridge);
    }

    public List<String> getPlayerBridge() {
        return Collections.unmodifiableList(myBridge);
    }

    public boolean isMatchDirection() {
        int size = myBridge.size();
        List<String> subAnswerBridge = bridge.subList(0, size);
        return subAnswerBridge.equals(myBridge);
    }

    public boolean isGameLoss(){
        return isNotFinish() || !isAllMatch();
    }

    public boolean isNotFinish() {
        return myBridge.size() != bridge.size();
    }

    private boolean isAllMatch() {
        int count = (int) IntStream.range(0, bridge.size())
                .filter(idx -> Util.valueEqualCheck(bridge, myBridge, idx))
                .count();
        return count == bridge.size();
    }

    public boolean isGameWin() {
        return !isNotFinish() && isAllMatch();
    }

    public int getTrial() {
        return trial;
    }
}
