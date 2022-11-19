package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static OutputView instance;
    private static final String ERROR_MESSAGE_HEADER = "[ERROR]";

    private OutputView() {
    } // for singleton pattern

    public static OutputView getInstance() {
        if (instance == null) {
            instance = new OutputView();
        }
        return instance;
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

    /*
     * message로 시작하고, end로 끝나는 문자열을 출력함
     * 즉, message + end의 형태가 출력되는 것
     */
    public void printMessage(String message, String end) {
        System.out.print(message + end);
    }

    public void printErrorMessage(String message) {
        System.out.println(ERROR_MESSAGE_HEADER + " " + message);
    }
}
