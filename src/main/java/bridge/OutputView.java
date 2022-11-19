package bridge;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String MESSAGE_ERROR = "[ERROR] ";
    public static final String MESSAGE_GAME_START = "다리 건너기 게임을 시작합니다.";
    public static final String MESSAGE_INPUT_BRIDGE_SIZE = System.lineSeparator() + "다리의 길이를 입력해주세요.";
    public static final String MESSAGE_INPUT_BRIDGE_MOVING = System.lineSeparator() + "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String MESSAGE_RETRY_OR_EXIT = System.lineSeparator() + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String MESSAGE_GAME_RESULT = "최종 게임 결과";
    public static final String MESSAGE_GAME_END = System.lineSeparator() + "게임 성공 여부: %s" + System.lineSeparator() + "총 시도한 횟수: %d";

    public void printStart() {
        printOf(OutputView.MESSAGE_GAME_START);
        printOf(OutputView.MESSAGE_INPUT_BRIDGE_SIZE);
    }

    public void printOf(String message) {
        System.out.println(message);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<List<String>> resultMap) {
        StringBuilder sb = new StringBuilder();
        for (List<String> strings : resultMap) {
            sb.append("[");
            for (int j = 0; j < strings.size(); j++) {
                sb.append(" ");
                sb.append(strings.get(j));
                sb.append(" ");
                if (j != strings.size() - 1) {
                    sb.append("|");
                }
            }
            sb.append("]");
            sb.append(System.lineSeparator());
        }
        System.out.print(sb);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<List<String>> resultMap, String isSuccess, int gameCount) {
        System.out.println(MESSAGE_GAME_RESULT);
        printMap(resultMap);
        System.out.printf(MESSAGE_GAME_END, isSuccess, gameCount);
    }

    public static void printError(String message) {
        System.out.println(MESSAGE_ERROR + message);
    }
}
