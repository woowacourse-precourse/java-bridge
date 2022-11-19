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
        System.out.println(MESSAGE_GAME_START);
        System.out.println(MESSAGE_INPUT_BRIDGE_SIZE);
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
        System.out.print(resultMapToString(resultMap));
    }

    private StringBuilder resultMapToString(List<List<String>> resultMap) {
        StringBuilder sb = new StringBuilder();
        for (List<String> strings : resultMap) {
            sb.append("[");
            addResultsToBuilder(strings, sb);
            sb.append("]");
            sb.append(System.lineSeparator());
        }
        return sb;
    }

    private void addResultsToBuilder(List<String> results, StringBuilder builder) {
        for (int i = 0; i < results.size(); i++) {
            builder.append(Command.BLANK_SPACE.getMessage())
                    .append(results.get(i))
                    .append(Command.BLANK_SPACE.getMessage());

            if (i != results.size() - 1) {
                builder.append("|");
            }
        }
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
