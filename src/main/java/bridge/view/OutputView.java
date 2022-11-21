package bridge.view;

import bridge.utils.Message;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(String[][] map) {
        String result = "[ %s ]";
        for (String[] line : map) {
            String format = String.format(result, String.join(" | ", line));
            System.out.println(format);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(String[][] map, boolean success, int attempts) {
        System.out.println(Message.PRINT_TOTAL_RESULT);
        printMap(map);
        System.out.println(Message.getGameResult(success));
        System.out.println(Message.getAttempts(attempts));
    }

    public void printErrorMessage(String message) {
        System.out.println(Message.createErrorMessage(message));
    }

    public void printStartMessage() {
        System.out.println(Message.START_GAME);
        System.out.println();
    }
}
