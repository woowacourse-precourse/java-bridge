package bridge.domain;

import java.util.ArrayList;
import java.util.List;

public class MoveResult {
    private List<String> upMoves;
    private List<String> downMoves;

    public MoveResult() {
        this.upMoves = new ArrayList<>();
        this.downMoves = new ArrayList<>();
    }

    public void addMove(String moving, String result) {
        if (moving.equals("U")) {
            addUpMove(result);
            return;
        }
        addDownMove(result);
    }

    private void addUpMove(String result) {
        upMoves.add(result);
        downMoves.add(" ");
    }

    private void addDownMove(String result) {
        downMoves.add(result);
        upMoves.add(" ");
    }

    public String getUpMovesString() {
        return String.join(" | ", upMoves);
    }

    public String getDownMovesString() {
        return String.join(" | ", downMoves);
    }

    public int getStep() {
        return upMoves.size();
    }

    public boolean isFinish(int bridgeSize) {
        return upMoves.size() == bridgeSize;
    }
}
