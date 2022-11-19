package bridge;

import static bridge.MessageUtil.BRIDGE_SIZE_INPUT_INTRO;
import static bridge.MessageUtil.POSITION_CHOICE_INPUT;
import static bridge.MessageUtil.START_GAME_INTRO;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<Boolean> moveResult, List<String> playersMove) {
        printMapUpper(moveResult, playersMove);
        printMapLower(moveResult, playersMove);
        System.out.println();
    }

    private void printMapUpper(List<Boolean> moveResult, List<String> playersMove) {
        System.out.print('[');
        for (int i = 0; i < playersMove.size(); i++) {
            printMoveAtIdx(moveResult, playersMove, i, "U");
            if (printWallIfNotEnd(playersMove, i)) {
                break;
            }
        }
        System.out.println(']');
    }

    private void printMapLower(List<Boolean> moveResult, List<String> playersMove) {
        System.out.print('[');
        for (int i = 0; i < playersMove.size(); i++) {
            printMoveAtIdx(moveResult, playersMove, i, "D");
            if (printWallIfNotEnd(playersMove, i)) {
                break;
            }
        }
        System.out.println(']');
    }

    private void printMoveAtIdx(List<Boolean> moveResult, List<String> playersMove, int i, String d) {
        if (playersMove.get(i).equals(d)) {
            System.out.printf(" %s ", resultMapper(moveResult.get(i)));
            return;
        }
        System.out.print("   ");
    }

    private boolean printWallIfNotEnd(List<String> playersMove, int i) {
        if (i == playersMove.size() - 1) {
            return true;
        }
        System.out.print("|");
        return false;
    }

    private String resultMapper(boolean result) {
        if (result) {
            return "O";
        }
        return "X";
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }

    public void printOpening() {
        System.out.println(START_GAME_INTRO.message + "\n");
    }

    public void printBrideSizeOpening() {
        System.out.println(BRIDGE_SIZE_INPUT_INTRO.message);
    }

    public void printUserChoiceOpening() {
        System.out.println(POSITION_CHOICE_INPUT.message);
    }

    public void printErrorMessage(String errorMsg) {
        System.out.println("[ERROR]" + errorMsg + "\n");
    }

    public void printEmptyLine() {
        System.out.println();
    }

}
