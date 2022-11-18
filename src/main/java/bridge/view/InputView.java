package bridge.view;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public interface InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    int readBridgeSize();

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    String readMoving();

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    String readGameCommand();
}
