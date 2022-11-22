package bridge;

import static bridge.Application.inputView;
import static bridge.Application.outputView;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {
    ErrorCheck errorCheck = new ErrorCheck();
    private final int END_GAME = 0;
    private final String QUIT = "Q";

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public String move() {
        Message.choiceMove();
        String nextMove = inputView.readMoving();
        if(errorCheck.isValidUpOrDown(nextMove));
        return nextMove;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public int retry(int gameCnt, String answerOfRetry, int BRIDGE_LENGTH) {
        if(answerOfRetry.equals(QUIT)) {
            retryAnswerIsQuit(gameCnt);
            return END_GAME;
        }
        return BRIDGE_LENGTH;
    }

    public void retryAnswerIsQuit(int gameCnt) {
        Message.gameResult();
        outputView.printUpBridge();
        outputView.printDownBridge();
        Message.blank();
        Message.gameFail();
        Message.tryCount(gameCnt);
    }

    public void retryAnswerIsSuccess(int gameCnt) {
        Message.gameResult();
        outputView.printUpBridge();
        outputView.printDownBridge();
        Message.blank();
        Message.gameSuccess();
        Message.tryCount(gameCnt);
    }
}
