package bridge.view;

public class OutputView {
    static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    static final String INPUT_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";

    public void printStart() {
        System.out.println(START_GAME);
    }

    public void printInputBridgeSize() {
        System.out.println(INPUT_BRIDGE_SIZE);
    }

    public void printInputMoving() {
        System.out.println(INPUT_MOVING);
    }

    public void printMap() {
    }

    public void printResult() {
    }
}
