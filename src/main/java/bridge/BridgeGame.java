package bridge;

import bridge.enums.Inputs;
import java.util.ArrayList;
import java.util.List;

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

    public boolean move(Inputs move) {
        String correctMove = bridge.get(nextPosition);
        moveLog.add(move);
        if (correctMove == move.getMessage()) {
            nextPosition++;
            return true;
        }
        return false;
    }

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
