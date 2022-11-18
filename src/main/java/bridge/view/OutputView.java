package bridge.view;

public class OutputView {
    public static void printGameStart() {
        System.out.println(OutputMessage.GAME_START_MESSAGE.getInputMessage());
    }

    public static void printInputNumber() {
        System.out.println(OutputMessage.INPUT_NUMBER_MESSAGE.getInputMessage());
    }

    public static void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public static void printInputMoving() {
        System.out.println(OutputMessage.INPUT_MOVING_MESSAGE.getInputMessage());
    }

    public static void printInputRestart() {
        System.out.println(OutputMessage.INPUT_RESTART_MESSAGE.getInputMessage());
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap() {
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult() {
    }
}
