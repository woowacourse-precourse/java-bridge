package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> bridge;
    private int nowPosition = -1;
    private int tryNumber = 0;
    private int moveResult;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        tryNumber = 1;
    }

    public int getTryNumber() {
        return tryNumber;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String nextMove) {
        this.nowPosition++;
        this.moveResult = 0;
        if (!bridge.get(this.nowPosition).equals(nextMove)) {
            this.moveResult = -1;
        }
        if (nowPosition + 1 == bridge.size()) {
            this.moveResult = 1;
        }
        return this.moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        this.nowPosition = -1;
        tryNumber++;
    }
    private void toStringBodyBuilder(StringBuilder upBridge, StringBuilder downBridge){
        for (int i = 0; i < this.nowPosition; i++) {
            if (this.bridge.get(i).equals("U")) {
                upBridge.append("O | ");
                downBridge.append("  | ");
                continue;
            }
            upBridge.append("  | ");
            downBridge.append("O | ");
        }
    }
    private void toStringTailBuilder(StringBuilder upBridge, StringBuilder downBridge,String lastResult){

        if (this.bridge.get(this.nowPosition).equals("U")) {
            upBridge.append(lastResult).append(" ]");
            downBridge.append("  ]");
            return;
        }
            upBridge.append("  ]");
            downBridge.append(lastResult).append(" ]");
    }

    @Override
    public String toString() {
        StringBuilder upBridge = new StringBuilder("[ ");
        StringBuilder downBridge = new StringBuilder("[ ");
        toStringBodyBuilder(upBridge, downBridge);
        String lastResult = "O";
        if(this.moveResult == -1){
            lastResult = "X";
        }
        toStringTailBuilder(upBridge,downBridge,lastResult);
        return upBridge.toString() + System.lineSeparator() + downBridge.toString();
    }
}
