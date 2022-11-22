package bridge;

import java.util.ArrayList;
import java.util.List;

import bridge.enums.Inputs;

public class BridgeGame {
    private List<String> bridge;
    private List<Inputs> moveLog;
    private int nextPosition;
    private int trials;

    public BridgeGame(int bridgeSize, BridgeNumberGenerator bridgeNumberGenerator) {
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        this.bridge = bridgeMaker.makeBridge(bridgeSize);
        this.moveLog = new ArrayList<>();
        this.nextPosition = 0;
        this.trials = 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean move(Inputs move) {
        String correctMove = bridge.get(nextPosition);
        moveLog.add(move);
        if (correctMove == move.getMessage()) {
            nextPosition++;
            return true;
        }
        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public void retry() {
        nextPosition = 0;
        moveLog = new ArrayList<>();
        trials++;
    }

    public boolean gameWon() {
        if (nextPosition >= bridge.size()) {
            return true;
        }
        return false;
    }

    public int getTrials() {
        return trials;
    }

    @Override
    public String toString() {
        String upper = getOutputString(Inputs.MOVE_UP);
        String lower = getOutputString(Inputs.MOVE_DOWN);
        return upper + "\n" + lower;
    }

    private String getOutputString(Inputs target) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < moveLog.size(); i++) {
            String s = getMoveOutput(i, target);
            sb.append(" " + s + " |");
        }
        sb.setLength(sb.length()-1);
        return sb.append("]").toString();
    }

    private String getMoveOutput(int index, Inputs target) {
        Inputs move = moveLog.get(index);
        if (move == target && bridge.get(index).equals(move.getMessage())) {
            return "O";
        }
        if (move == target && !bridge.get(index).equals(move.getMessage())) {
            return "X";
        }
        return " ";
    }
}
