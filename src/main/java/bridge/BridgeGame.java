package bridge;

/**
 * 필드 변수 추가 가능 패키지 변경 가능 메서드 이름 변경 불가 인자 변경 가능 타입 변경 가능 추가 메서드 구현 가능
 */

import bridge.Constants.OutputState;
import bridge.Constants.Result;
import java.util.ArrayList;
import java.util.List;
import bridge.Constants.BridgeShape;
import bridge.Constants.Command;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private static List<String> bridge;
    private static int attemptCount = 0;
    private List<String> upLine;
    private List<String> downLine;
    private int bridgeIndex;
    private String result;

    BridgeGame() {
        this.upLine = new ArrayList<String>();
        this.downLine = new ArrayList<String>();
        this.result = Result.FAIL;
        this.bridgeIndex = 0;
    }

    public static int getAttemptCount() {
        return BridgeGame.attemptCount;
    }

    public static void increaseAttemptCount() {
        BridgeGame.attemptCount += 1;
    }

    public String resultToString() {
        return OutputState.SUCCESS_OR_NOT + result;
    }


    public static void setBridge(List<String> bridge) {
        BridgeGame.bridge = bridge;
    }

    public boolean isSuccessFinish() {
        if (BridgeGame.bridge.size() == this.bridgeIndex) {
            this.result = Result.SUCCESS;
            return true;
        }
        this.result = Result.FAIL;
        return false;
    }


    public String getUpLineForm() {
        return BridgeShape.START_LINE + String.join(BridgeShape.SEPERATOR, this.upLine) + BridgeShape.END_LINE;

    }

    public String getDownLineForm() {
        return BridgeShape.START_LINE + String.join(BridgeShape.SEPERATOR, this.downLine) + BridgeShape.END_LINE;
    }


    public boolean isCorrectDirection(String command) {
        return BridgeGame.bridge.get(bridgeIndex).equals(command);
    }

    private void drawLine(List<String> selectedLine, List<String> oppositeLine, String movable) {
        selectedLine.add(movable);
        oppositeLine.add(BridgeShape.BLANK);
    }
    private void addMovement(List<String> selectedLine, List<String> oppositeLine, boolean isCorrect) {
        this.bridgeIndex += 1;
        if (isCorrect) {
            drawLine(selectedLine, oppositeLine, BridgeShape.MOVABLE);
            return;
        }
        drawLine(selectedLine, oppositeLine, BridgeShape.UNMOVABLE);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    private boolean isCorrectMovement(List<String> mainLine, List<String> oppositeLine, String direction) {
        boolean isCorerct = isCorrectDirection(direction);
        addMovement(mainLine, oppositeLine, isCorerct);
        return isCorerct;
    }

    public boolean move(String direction) {
        List<String> mainLine = this.upLine;
        List<String> oppositeLine = this.downLine;
        if (direction.equals(Command.DOWN)) {
            mainLine = this.downLine;
            oppositeLine = this.upLine;
        }
        return isCorrectMovement(mainLine, oppositeLine, direction);
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        return command.equals(Command.RETRY);
    }
}
