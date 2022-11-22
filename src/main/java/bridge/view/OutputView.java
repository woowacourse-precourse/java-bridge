package bridge.view;

import java.util.List;

import static bridge.view.Message.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public void printStart() {
        System.out.println(MESSAGE_GAME_START.getMessage());
        System.out.println(MESSAGE_INPUT_BRIDGE_SIZE.getMessage());
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
        System.out.println(MESSAGE_GAME_RESULT.getMessage());
        printMap(resultMap);
        System.out.printf(MESSAGE_GAME_END.getMessage(), isSuccess, gameCount);
    }

    public static void printError(String message) {
        System.out.println(MESSAGE_ERROR.getMessage() + message);
    }
}
