package bridge.game;

import java.util.List;

import static bridge.enums.IntEnum.*;
import static bridge.enums.StringEnum.DOWN;
import static bridge.enums.StringEnum.UP;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private final List<String> bridge;
    private final int lastStage;
    private int stage;

    public BridgeGame(List<String> bridge) {
        this.bridge = bridge;
        stage = RESET_STAGE.num();
        lastStage = bridge.size() - 1;
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int move(String inputBridgeStage) {
        if (bridge.get(stage).equals(inputBridgeStage)) {
            if (isGameWin()) return GAME_WIN.num();
            return GAME_CONTINUE.num();
        }
        return GAME_LOSE.num();
    }

    private boolean isGameWin() {
        return lastStage == stage;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
        stage = RESET_STAGE.num();
    }

    public String nowBridgeStage(int nowState) {
        StringBuilder upPrint = new StringBuilder("[");
        StringBuilder downPrint = new StringBuilder("[");
        makeMap(nowState, upPrint, downPrint);
        upPrint.append("]");
        downPrint.append("]");
        stage++;
        upPrint.append("\n").append(downPrint);
        return upPrint.toString();
    }

    private void lastIndexPrint(int nowState, StringBuilder upPrint, StringBuilder downPrint) {
        if (nowState == GAME_WIN.num() || nowState == GAME_CONTINUE.num()) {
            continuePrint(stage, upPrint, downPrint);
        }
        if (nowState == GAME_LOSE.num()) {
            failPrint(upPrint, downPrint);
        }
    }

    private void failPrint(StringBuilder upPrint, StringBuilder downPrint) {
        if (bridge.get(stage).equals(UP.key())) {
            upPrint.append("  ");
            downPrint.append(" X ");
        }
        if (bridge.get(stage).equals(DOWN.key())) {
            upPrint.append(" X ");
            downPrint.append("   ");
        }
    }

    private void addBarPrint(StringBuilder upPrint, StringBuilder downPrint) {
        upPrint.append("|");
        downPrint.append("|");
    }

    private void continuePrint(int duringIndex, StringBuilder upPrint, StringBuilder downPrint) {
        if (bridge.get(duringIndex).equals(UP.key())) {
            upPrint.append(" O ");
            downPrint.append("   ");
        }
        if (bridge.get(duringIndex).equals(DOWN.key())) {
            upPrint.append("   ");
            downPrint.append(" O ");
        }
    }

    private void duringPrint(StringBuilder upPrint, StringBuilder downPrint) {
        for (int duringIndex = 0; duringIndex < stage; duringIndex++) {
            if (duringIndex == RESET_STAGE.num()) {
                continuePrint(duringIndex, upPrint, downPrint);
            }
            if (duringIndex > RESET_STAGE.num()) {
                addBarPrint(upPrint, downPrint);
                continuePrint(duringIndex, upPrint, downPrint);
            }
        }
    }

    private void makeMap(int result, StringBuilder upPrint, StringBuilder downPrint) {
        if (stage == RESET_STAGE.num()) {
            lastIndexPrint(result, upPrint, downPrint);
        }
        if (stage > RESET_STAGE.num()) {
            duringPrint(upPrint, downPrint);
            addBarPrint(upPrint, downPrint);
            lastIndexPrint(result, upPrint, downPrint);
        }
    }
}
