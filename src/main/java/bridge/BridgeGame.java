package bridge;

/**
 * 필드 변수 추가 가능 패키지 변경 가능 메서드 이름 변경 불가 인자 변경 가능 타입 변경 가능 추가 메서드 구현 가능
 */

import bridge.Constants.BridgeShape;
import bridge.Constants.Command;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private List<String> upLine;
    private List<String> downLine;
    private int bridgeIndex;

    private static List<String> bridge;
    private static int countAttempt = 0;
    public static String RESULT = "실패";

    BridgeGame() {
        this.upLine = new ArrayList<String>();
        this.downLine = new ArrayList<String>();
        this.bridgeIndex = 0;
    }

    public boolean isFinish() {
        if (BridgeGame.bridge.size() == this.bridgeIndex) {
            return true;
        }
        return false;
    }

    public String getUpLineForm() {
        return String.join(BridgeShape.SEPERATOR, this.upLine);

    }

    public String getDownLineForm() {
        return String.join(BridgeShape.SEPERATOR, this.downLine);
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

    public boolean isCorrectDirection(String command) {
        if (BridgeGame.bridge.get(bridgeIndex).equals(command)) {
            return true;
        }
        return false;
    }

//    public boolean judgeMovement(String direction, String command) {
//        if (isCorrectDirection(Command.UP)) {
//            this.upLine.add(BridgeShape.MOVABLE);
//            this.downLine.add(BridgeShape.BLANK);
//            this.bridgeIndex += 1;
//            return true;
//        }
//        this.upLine.add(BridgeShape.UNMOVABLE);
//        this.downLine.add(BridgeShape.BLANK);
//        this.bridgeIndex += 1;
//        return false;
//    }

    public void addMovement(List<String> selectedLine, List<String> oppositeLine, boolean isCorrect) {
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
    //TODO 브릿지 그리는 부분 분리하기
    public boolean move(String direction) {
        List<String> mainLine = this.upLine;
        List<String> oppositeLine = this.downLine;
        if (direction.equals(Command.DOWN)) {
            mainLine = this.downLine;
            oppositeLine = this.upLine;
        }
        if (isCorrectDirection(direction)) {
            addMovement(mainLine, oppositeLine, true);
            return true;
        }
        addMovement(mainLine, oppositeLine, false);
        return false;
//        if(direction.equals(Command.UP)) {
//            if(isCorrectDirection(Command.UP)) {
//                addMoving(mainLine, oppositeLine, true);
//                return true;
//            }
//            addMoving(mainLine, oppositeLine, false);
//            return false;
//        }
//        if(isCorrectDirection(Command.DOWN)) {
//            addMoving(mainLine, oppositeLine, true);
//            return true;
//        }
//        addMoving(mainLine, oppositeLine, false);
//        return false;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
