package bridge.domain;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 */
public class BridgeGame {

    private final Bridge answerBridge;
    private List<Bridge> records = new ArrayList<>();
    private Bridge onPlayingBridge;

    public BridgeGame(List<String> answerBridge) {
        this.answerBridge = new Bridge(answerBridge);
        this.onPlayingBridge = new Bridge();
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move(String side) {
        if (onPlayingBridge == null) onPlayingBridge = new Bridge();
        onPlayingBridge.connect(side);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        saveCurrentPlay();
        onPlayingBridge = new Bridge();
    }

    public void saveCurrentPlay() {
        records.add(onPlayingBridge);
    }

    public boolean isCorrect() {
        return onPlayingBridge.matchWith(answerBridge);
    }

    public boolean isCompleted() {
        if (onPlayingBridge.isSameSizeWith(answerBridge)) {
            saveCurrentPlay();
            return true;
        }
        return false;
    }

    public int getNumberOfTrials() {
        return records.size();
    }

    public Bridge getResultBridge() {
        Bridge result = onPlayingBridge;
        for (Bridge bridge : records) {
            result = compare(result, bridge);
        }
        return result;
    }

    public Bridge compare(Bridge bridge1, Bridge bridge2) {
        if (bridge1.getSize() > bridge2.getSize()) return bridge1;
        if (bridge1.getSize() < bridge2.getSize()) return bridge2;
        if (bridge1.matchWith(answerBridge)) return bridge1;
        return bridge2;
    }

    public String getResultLaneOf(String side) {
        return getResultBridge().getLaneString(side, answerBridge.getBridge());
    }

    public String getBridgeLaneOf(String side) {
        return onPlayingBridge.getLaneString(side, answerBridge.getBridge());
    }
    
    public String getGameResult() {
        if (getResultBridge().isSameSizeWith(answerBridge)
                && getResultBridge().matchWith(answerBridge)) {
            return "성공";
        }
        return "실패";
    }
}
