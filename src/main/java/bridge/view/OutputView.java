package bridge.view;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String ERROR_FLAG = "[ERROR] ";
    private static final String ENTER_BRIDGE_SIZE_MESSAGE = "다리의 길이를 입력해주세요.";

    public static void startBridgeGame() {
        System.out.println(START_MESSAGE);
        printNewLine();
    }
    
    public static void readBridgeSize() {
        System.out.println(ENTER_BRIDGE_SIZE_MESSAGE);
    }

    public static void printError(String message) {
        System.out.println(ERROR_FLAG + message);
        printNewLine();
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

    private static void printNewLine() {
        System.out.println();
    }
}
