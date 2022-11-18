package bridge.view;

import java.security.PublicKey;

public class InputView {
    private final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";

    public void showGameStartMessage() {
        System.out.println(GAME_START_MESSAGE);
    }

    public int readBridgeSize() {
        return 0;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
