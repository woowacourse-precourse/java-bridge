package bridge.view;

import java.util.List;

import static bridge.enums.IntEnum.*;
import static bridge.enums.StringEnum.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private final List<String> bridge;
    private int stage;

    public OutputView(List<String> bridge) {
        this.bridge = bridge;
        this.stage = RESET_STAGE.num();
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String printMap(int result) {
        StringBuilder upPrint = new StringBuilder("[");
        StringBuilder downPrint = new StringBuilder("[");
        makeMap(result, upPrint, downPrint);
        upPrint.append("]");
        downPrint.append("]");
        stage++;
        upPrint.append("\n").append(downPrint);
        return upPrint.toString();
    }


    private void lastIndexOutput(int result, StringBuilder upPrint, StringBuilder downPrint) {
        if (result == GAME_WIN.num() || result == GAME_CONTINUE.num()) {
            continuePrint(stage, upPrint, downPrint);
        }
        if (result == GAME_LOSE.num()) {
            failPrint(upPrint, downPrint);
        }
    }

    private void failPrint(StringBuilder upPrint, StringBuilder downPrint) {
        if (bridge.get(stage).equals(UP.key())) {
            upPrint.append("  ");
            downPrint.append(" x ");
        }
        if (bridge.get(stage).equals(DOWN.key())) {
            upPrint.append(" x ");
            downPrint.append("   ");
        }
    }
    private void addBar(StringBuilder upPrint, StringBuilder downPrint) {
        upPrint.append("|");
        downPrint.append("|");
    }

    private void continuePrint(int duringIndex, StringBuilder upPrint, StringBuilder downPrint) {
        if (bridge.get(duringIndex).equals(UP.key())) {
            upPrint.append(" o ");
            downPrint.append("   ");
        }
        if (bridge.get(duringIndex).equals(DOWN.key())) {
            upPrint.append("   ");
            downPrint.append(" o ");
        }
    }
    private void duringOutput(StringBuilder upPrint, StringBuilder downPrint) {
        for (int duringIndex = 0; duringIndex < stage; duringIndex++) {
            if (duringIndex == RESET_STAGE.num()) {
                continuePrint(duringIndex, upPrint, downPrint);
            }
            if (duringIndex > RESET_STAGE.num()) {
                addBar(upPrint, downPrint);
                continuePrint(duringIndex, upPrint, downPrint);
            }
        }
    }
    private void makeMap(int result, StringBuilder upPrint, StringBuilder downPrint) {
        if (stage == RESET_STAGE.num()) {
            lastIndexOutput(result, upPrint, downPrint);
        }
        if (stage > RESET_STAGE.num()) {
            duringOutput(upPrint, downPrint);
            addBar(upPrint,downPrint);
            lastIndexOutput(result, upPrint, downPrint);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printGameStart() {
        System.out.println(GAME_START.key());
    }

    public void printAskMoving() {
        System.out.println(ASK_MOVING.key());
    }

    public void printAskCommand() {
        System.out.println(ASK_COMMAND.key());
    }

    public void printAskLength() {
        System.out.println(ASK_BRIDGE_LENGTH.key());
    }

}
