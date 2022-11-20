package bridge;

/**
 * 필드 변수 추가 가능 패키지 변경 가능 메서드 이름 변경 불가 인자 변경 가능 타입 변경 가능 추가 메서드 구현 가능
 */

import java.util.ArrayList;
import java.util.List;
import bridge.Constants.BridgeShape;
import bridge.Constants.Command;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    private List<String> upLine;
    private List<String> downLine;
    private int bridgeIndex;
    public String result = "실패";

    public static final String FAIL = "실패";
    public static final String SUCCESS = "성공";
    private static List<String> bridge;
    private static int countAttempt = 0;

    BridgeGame() {
        this.upLine = new ArrayList<String>();
        this.downLine = new ArrayList<String>();
        this.bridgeIndex = 0;
    }

    public static int getCountAttempt() {
        return BridgeGame.countAttempt;
    }

    public static void setCountAttempt() {
        BridgeGame.countAttempt += 1;
    }


    public static void setBridge(List<String> bridge) {
        BridgeGame.bridge = bridge;
    }

    public boolean isSuccessFinish() {
        if (BridgeGame.bridge.size() == this.bridgeIndex) {
            this.result = SUCCESS;
            return true;
        }
        this.result = FAIL;
        return false;
    }


    public String getUpLineForm() {
        return String.join(BridgeShape.SEPERATOR, this.upLine);

    }

    public String getDownLineForm() {
        return String.join(BridgeShape.SEPERATOR, this.downLine);
    }


    public boolean isCorrectDirection(String command) {
        return BridgeGame.bridge.get(bridgeIndex).equals(command);
    }

    private void addMovement(List<String> selectedLine, List<String> oppositeLine, boolean isCorrect) {
        if (isCorrect) {
            selectedLine.add(BridgeShape.MOVABLE);
            oppositeLine.add(BridgeShape.BLANK);
            this.bridgeIndex += 1;
            return;
        }
        selectedLine.add(BridgeShape.UNMOVABLE);
        oppositeLine.add(BridgeShape.BLANK);
        this.bridgeIndex += 1;
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
        if (command.equals(Command.QUIT)) {
            return false;
        }
        return true;
    }
}
