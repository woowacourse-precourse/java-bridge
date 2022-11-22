package bridge.view;

import java.util.ArrayList;
import java.util.List;

import bridge.domain.BridgeStatus;

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

    
    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<BridgeStatus> path) {
        List<String> upRow = new ArrayList<>();
        List<String> downRow = new ArrayList<>();
        for (int i = 0; i < path.size(); i++) {
            upRow.add(printRow(path.get(i), "U"));
            downRow.add(printRow(path.get(i), "D"));
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
        String successMessage = "실패";
        if (isSuccess) {
            successMessage = "성공";
        }
        System.out.printf(GAME_SUCCESS_MESSAGE, successMessage);
        System.out.printf(TRY_COUNT_MESSAGE, tryCount);
    }
}
