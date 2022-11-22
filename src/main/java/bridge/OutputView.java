package bridge;

import bridge.Util.COMMAND_CONSTANTS;
import bridge.Util.GAME_MESSAGE;
import bridge.Util.GAME_STATE;

import java.util.List;
import java.util.Objects;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printInitialize() {
        System.out.println(GAME_MESSAGE.INITIALIZE.getMessage());
    }

    public static void printSelectMessage() {
        System.out.println(GAME_MESSAGE.CHOOSE_MOVE.getMessage());
    }

    public static void printRetryMessage() {
        System.out.println(GAME_MESSAGE.CHOOSE_RETRY.getMessage());
    }

    public static void printMap(List<String> bridge, GAME_STATE state) {
        int printingIndex = GAME_STATE.INDEX.getValue();
        String upperString, lowerString;
        upperString = bridgeBuilder(bridge, printingIndex, COMMAND_CONSTANTS.MOVE_UP.getCommand());
        lowerString = bridgeBuilder(bridge, printingIndex, COMMAND_CONSTANTS.MOVE_DOWN.getCommand());
        if (state == GAME_STATE.QUIT || state == GAME_STATE.RETRY) {
            upperString = fixWrong(new StringBuilder(upperString)).toString();
            lowerString = fixWrong(new StringBuilder(lowerString)).toString();
        }
        System.out.println(upperString);
        System.out.println(lowerString + "\n");
    }

    private static String bridgeBuilder(List<String> bridge, int index, String floor) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder = startOfLine(stringBuilder, Objects.equals(bridge.get(0), floor));
        for (int i = 1; i < index; i++) {
            stringBuilder = append(stringBuilder, Objects.equals(bridge.get(i), floor));
        }
        stringBuilder.append(" ]");
        return stringBuilder.toString();
    }

    private static StringBuilder startOfLine(StringBuilder stringBuilder, boolean isCorrect) {
        if (isCorrect) {
            return stringBuilder.append("[ O");
        }
        return stringBuilder.append("[  ");
    }

    private static StringBuilder append(StringBuilder stringBuilder, boolean isCorrect) {
        if (isCorrect) {
            return stringBuilder.append(" | O");
        }
        return stringBuilder.append(" |  ");
    }

    private static StringBuilder fixWrong(StringBuilder stringBuilder) {
        if (stringBuilder.charAt(stringBuilder.length() - 3) == 'O') {
            stringBuilder.deleteCharAt(stringBuilder.length() - 3);
            return stringBuilder.insert(stringBuilder.length() - 2, ' ');
        }
        stringBuilder.deleteCharAt(stringBuilder.length() - 3);
        return stringBuilder.insert(stringBuilder.length() - 2, 'X');
    }


    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(List<String> bridge, GAME_STATE gameState, int count) {
        System.out.println(GAME_MESSAGE.ENDING.getMessage());
        printMap(bridge, gameState);

        System.out.printf(GAME_MESSAGE.ENDING_RESULT.getMessage(), gameState.getState(), count);

    }
}
