package bridge.extensible;

public interface InputView {

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
