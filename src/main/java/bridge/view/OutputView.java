package bridge.view;

import bridge.model.User;

import java.util.List;

public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    private static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
    }

    public static void printInputMoving() {
        System.out.println(INPUT_MOVING);
    }

    public static void printMap(List<String> userChoices, List<Boolean> compareResults) {
        StringBuilder topLine = new StringBuilder("[");
        StringBuilder bottomLine = new StringBuilder("[");

        for (int i = 0; i < compareResults.size(); i++) {
            String choice = userChoices.get(i);
            boolean compareResult = compareResults.get(i);

            if (choice.equals("U")) {
                if (compareResult) {
                    topLine.append("O|");
                    bottomLine.append(" |");
                } else {
                    topLine.append("X|");
                    bottomLine.append(" |");
                }
            } else {
                if (compareResult) {
                    topLine.append(" |");
                    bottomLine.append("O|");
                } else {
                    topLine.append(" |");
                    bottomLine.append("X|");
                }
            }
        }

        topLine.append("\b]");
        bottomLine.append("\b]");

        System.out.println(topLine);
        System.out.println(bottomLine);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
