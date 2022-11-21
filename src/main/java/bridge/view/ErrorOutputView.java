package bridge.view;

public class ErrorOutputView extends ErrorOutput {
    private static final String BRIDGE_SIZE_ERROR_MESSAGE = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String MOVE_ERROR_MESSAGE = "이동할 칸은 U 또는 D여야 합니다.";
    private static final String RETRY_ERROR_MESSAGE = "재시작은 R 또는 Q여야 합니다.";

    public void printBridSizeError() {
        super.printError();
        System.out.println(BRIDGE_SIZE_ERROR_MESSAGE);
    }

    public void printMoveError() {
        super.printError();
        System.out.println(MOVE_ERROR_MESSAGE);
    }

    public void printRetryError() {
        super.printError();
        System.out.println(RETRY_ERROR_MESSAGE);
    }
}
