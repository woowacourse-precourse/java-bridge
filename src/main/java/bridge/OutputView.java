package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String UP_MOVING_CHARACTER = "U";
    private static final String DOWN_MOVING_CHARACTER = "D";
    private static final String BLANK = " ";
    private static final String LEFT_SQUARE_BRACKET = "[ ";
    private static final String RIGHT_SQUARE_BRACKET = " ]";
    private static final String DELIMITER = " | ";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String GAME_SUCCESS_MESSAGE = "게임 성공 여부: 성공";
    private static final String GAME_FAILURE_MESSAGE = "게임 성공 여부: 실패";
    private static final String GAME_COUNT_MESSAGE = "총 시도한 횟수: ";

    public void makeMap(String moving, String str, List<List<String>> bridgeMap) {
        if (moving.equals(UP_MOVING_CHARACTER)) {
            bridgeMap.add(List.of(BLANK, str));
        } else if (moving.equals(DOWN_MOVING_CHARACTER)) {
            bridgeMap.add(List.of(str, BLANK));
        }
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> bridgeMap) {
        List<String> downBridge = new ArrayList<>();
        List<String> upperBridge = new ArrayList<>();
        for (List<String> map : bridgeMap) {
            downBridge.add(map.get(0));
            upperBridge.add(map.get(1));
        }

        System.out.print(LEFT_SQUARE_BRACKET);
        System.out.print(String.join(DELIMITER, upperBridge));
        System.out.print(RIGHT_SQUARE_BRACKET);
        System.out.println();

        System.out.print(LEFT_SQUARE_BRACKET);
        System.out.print(String.join(DELIMITER, downBridge));
        System.out.print(RIGHT_SQUARE_BRACKET);
        System.out.println();
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> bridgeMap, boolean success, int gameCount) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeMap);
        printSuccess(success);
        printGameCount(gameCount);
    }

    public void printSuccess(boolean success) {
        if (success) {
            System.out.println(GAME_SUCCESS_MESSAGE);
        } else if (!success) {
            System.out.println(GAME_FAILURE_MESSAGE);
        }
    }

    public void printGameCount(int gameCount) {
        System.out.println(GAME_COUNT_MESSAGE + gameCount);
    }
}
