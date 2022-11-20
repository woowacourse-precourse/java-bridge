package bridge.view;

import java.util.List;

public class OutputView {

    public static void printGameStart() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getMessage());
    }

    public static void printInputNumber() {
        System.out.println(OutputMessage.INPUT_NUMBER_MESSAGE.getMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printInputMoving() {
        System.out.println(OutputMessage.INPUT_MOVING_MESSAGE.getMessage());
    }

    public static void printInputRestart() {
        System.out.println(OutputMessage.INPUT_RESTART_MESSAGE.getMessage());
    }

    public static void printMap(List<List<String>> footPrint) {
        for (List<String> hierarchical: footPrint) {
            System.out.print(OutputMessage.START_SQUARE_BRACKET.getMessage());
            printMapMember(hierarchical);
            System.out.println(OutputMessage.END_SQUARE_BRACKET.getMessage());
        }
    }

    private static void printMapMember(List<String> hierarchical) {
        for (Integer index = 0; index < hierarchical.size() - 1; ++index) {
            System.out.print(hierarchical.get(index));
            System.out.print(OutputMessage.VERTICAL_BAR.getMessage());
        }
        System.out.print(hierarchical.get(hierarchical.size() - 1));
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
