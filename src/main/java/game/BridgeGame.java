package game;


import bridge.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private int countRestart = 1;

    private int bridgeCursor = 0;

    private final List<String> answerBridge;

    private static final BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();

    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

    public BridgeGame(int size) {
        answerBridge = bridgeMaker.makeBridge(size);
    }

    public int getCountRestart() {
        return this.countRestart;
    }

    public int getBridgeCursor() {
        return this.bridgeCursor;
    }

    public String getBridgeCursorValue() {
        return this.answerBridge.get(bridgeCursor);
    }

    public boolean isLastIndex() {
        return this.bridgeCursor == answerBridge.size()-1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void move() {
        bridgeCursor++;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        countRestart++;
        bridgeCursor = 0;
    }
}
