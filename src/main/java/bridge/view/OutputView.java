package bridge.view;

import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String PREFIX = "[ ";
    private static final String SUFFIX = " ]\n";
    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String UP = "U";
    private static final String DOWN = "D";
    private static final String FINAL_RESULT = "최종 게임 결과";
    private static final String IS_SUCCESS = "게임 성공 여부: ";
    private static final String TOTAL_ATTEMPT = "총 시도한 횟수: ";
    public static final String BLANK = " ";
    private static final String CIRCLE = "O";
    private static final String CROSS = "X";


    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> bridge, List<String> userInput) {
        StringBuilder up = new StringBuilder(PREFIX);
        StringBuilder down = new StringBuilder(PREFIX);

        for (int i = 0; i < userInput.size(); i++) {
            up.append(setUpResult(bridge.get(i), userInput.get(i)));
            down.append(setDownResult(bridge.get(i), userInput.get(i)));
            up.append(setPartition(i, userInput.size()));
            down.append(setPartition(i, userInput.size()));
        }
        System.out.println(up + SUFFIX + down + SUFFIX);
    }

    public void startMessage() {
        System.out.println(START_MESSAGE);
    }

    private String setPartition(int i, int size) {
        if (i != size - 1) {
            return " | ";
        }
        return "";
    }

    private String setDownResult(String bridge, String userInput) {
        String input = isSame(bridge, userInput);
        if (userInput.equals(DOWN)) {
            return input;
        }
        return BLANK;
    }

    private String setUpResult(String bridge, String userInput) {
        String input = isSame(bridge, userInput);
        if (userInput.equals(UP)) {
            return input;
        }
        return BLANK;
    }

    private String isSame(String bridge, String userInput) {
        if (bridge.equals(userInput)) {
            return CIRCLE;
        }
        return CROSS;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(List<String> bridge, List<String> userInput, int count) {
        System.out.println(FINAL_RESULT);
        printMap(bridge, userInput);

        String gameResult = "실패";
        if (userInput.equals(bridge)) {
            gameResult = "성공";
        }
        System.out.println(IS_SUCCESS + gameResult);
        System.out.println(TOTAL_ATTEMPT + Integer.toString(count));
    }
}
