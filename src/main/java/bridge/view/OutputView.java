package bridge.view;

public class OutputView {

    private static final String MESSAGE_TITLE = "다리 건너기 게임을 시작합니다.";
    private static final String MESSAGE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";

    public void printTitle() {
        System.out.println(MESSAGE_TITLE);
        System.out.println();
    }

    public void printBridgeSize() {
        System.out.println(MESSAGE_BRIDGE_SIZE);
    }

    public void printMap() {
    }

    public void printResult() {
    }
}
