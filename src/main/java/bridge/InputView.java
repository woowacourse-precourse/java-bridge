package bridge;

import camp.nextstep.edu.missionutils.Console;

import static bridge.Application.bridgeGame;
import static bridge.Application.outputView;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ErrorCheck errorCheck = new ErrorCheck();
    private final int END_GAME = 0;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        Message.inputBridgeLength();
        String bridgeLength = Console.readLine();
        if(errorCheck.isValidInteger(bridgeLength) && errorCheck.isValidBridgeLengthRange(bridgeLength));

        return Integer.parseInt(bridgeLength);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        Message.choiceMove();
        String nextMove = Console.readLine();
        if(errorCheck.isValidUpOrDown(nextMove));
        return nextMove;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public int readGameCommand(int gameCnt, int BRIDGE_LENGTH) {
        Message.inputTryOrQuit();
        String retry = Console.readLine();
        errorCheck.isValidRetryOrQuit(retry);
        int retryOrQuit = bridgeGame.retry(retry, BRIDGE_LENGTH);
        if(retryOrQuit == END_GAME) decideQuit(gameCnt);

        return retryOrQuit;
    }

    public void decideQuit(int gameCnt) {
        outputView.retryAnswerIsQuit(gameCnt);
    }
}
