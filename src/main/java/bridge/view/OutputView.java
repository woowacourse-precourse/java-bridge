package bridge.view;

import bridge.model.User;

import java.util.List;

public class OutputView {

    public static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    public static final String INPUT_BRIDGE_LENGTH = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_RETRY_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String ERROR_PREFIX = "[ERROR] ";
    public static final String ERROR_BRIDGE_SIZE = "잘못 입력했습니다. 3 이상 20 이하의 숫자를 입력해주세요.";
    public static final String ERROR_MOVING = "잘못 입력했습니다. U 또는 D를 입력해주세요.";
    public static final String ERROR_RETRY = "잘못 입력했습니다. R 또는 Q를 입력해주세요.";

    public static void printStart() {
        System.out.println(START_MESSAGE);
    }

    public static void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_LENGTH);
    }

    public static void printInputMoving() {
        System.out.println(INPUT_MOVING);
    }

    // TODO: 리팩토링
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
            }
            if (choice.equals("D")) {
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

    public static void printInputRetryCommand() {
        System.out.println(INPUT_RETRY_COMMAND);
    }

    public static void printResult(User user, List<Boolean> compareResults) {
        System.out.println("\n최종 게임 결과");
        printMap(user.getChoices(), compareResults);

        System.out.println("\n게임 성공 여부: " + user.getDoesSuccess());
        System.out.println("총 시도한 횟수: " + user.getTotalTryCount());
    }

    public static void printError(IllegalArgumentException illegalArgumentException) {
        System.out.println(illegalArgumentException.getMessage());
    }
}
