package bridge.view;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeStatus;
import bridge.domain.Direction;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String FRONT_BRACKET = "[ ";
    private static final String BACK_BRACKET = " ]";
    private static final String PATH_DELIMITER = " | ";

    private static final String RIGHT_STATUS = "O";
    private static final String WRONG_STATUS = "X";
    private static final String EMPTY_STATUS = " ";

    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과\n";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: %s\n";
    private static final String TRY_COUNT_MESSAGE = "총 시도한 횟수: %s\n";

    public void printBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void printGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }
    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeStatus> path) {
        List<String> upRow = new ArrayList<>();
        List<String> downRow = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            upRow.add(printRow(path.get(i), Direction.UP.getMoveOutput()));
            downRow.add(printRow(path.get(i), Direction.DOWN.getMoveOutput()));
        } 
        System.out.println(FRONT_BRACKET + String.join(PATH_DELIMITER, upRow) + BACK_BRACKET);
        System.out.println(FRONT_BRACKET + String.join(PATH_DELIMITER, downRow) + BACK_BRACKET);
        System.out.println();
    }

    private String printRow(BridgeStatus path, String command) {
        if (path.getPath().equals(command) && path.getPathAnswer()) {
            return RIGHT_STATUS;
        }
        if (path.getPath().equals(command) && !path.getPathAnswer()) {
            return WRONG_STATUS;
        }
        return EMPTY_STATUS;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<BridgeStatus> path, boolean isSuccess, int tryCount) {
        System.out.printf(GAME_RESULT_MESSAGE);
        printMap(path);
        printSuccess(isSuccess);
        printTryCount(tryCount);
    }

    private void printSuccess(boolean isSuccess) {
        String successMessage = "실패";
        if (isSuccess) {
            successMessage = "성공";
        }
        System.out.printf(GAME_SUCCESS_MESSAGE, successMessage);
    }

    private void printTryCount(int tryCount) {
        System.out.printf(TRY_COUNT_MESSAGE, tryCount);
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }
}
