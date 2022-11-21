package bridge;

import console.ErrorMessage;
import console.BridgeGameMessage;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    static boolean isComplete = true;
    static String lastUserInput;
    static int totalCount;
    static int attempt = 1;
    static InputView iv = new InputView();

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        String userInput = iv.readMoving();
        totalCount++;
        return lastUserInput = userInput;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String retryOrQuit) {
        if (retryOrQuit.equals(BridgeGameMessage.REDO.getMessage())) {
            totalCount = 0; attempt++;
            return isComplete = true;
        }
        if (retryOrQuit.equals(BridgeGameMessage.QUIT.getMessage())) isComplete = false;
        if (!retryOrQuit.equals(BridgeGameMessage.QUIT.getMessage())) throw new IllegalArgumentException(ErrorMessage.ERROR_RETRY.getMessage());
        return false;
    }
}
