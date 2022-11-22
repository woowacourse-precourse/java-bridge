package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

import static bridge.BridgeGameConstants.MIN_BRIDGE_SIZE;
import static bridge.BridgeGameConstants.MAX_BRIDGE_SIZE;
import static bridge.BridgeGameConstants.UPPER;
import static bridge.BridgeGameConstants.LOWER;
import static bridge.BridgeGameConstants.RESTART;
import static bridge.BridgeGameConstants.QUIT;

import static bridge.ExceptionMessage.BRIDGE_SIZE_ERROR_MESSAGE;
import static bridge.ExceptionMessage.INVALID_MOVING_ERROR_MESSAGE;
import static bridge.ExceptionMessage.INVALID_STATUS_ERROR_MESSAGE;

import static bridge.GameStatus.GAME_CONTINUE;
import static bridge.GameStatus.GAME_FAIL;
/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            return (parseBridgeSize(readLine()));
        } catch (NumberFormatException ex) {
            throw (new IllegalArgumentException(BRIDGE_SIZE_ERROR_MESSAGE.toString()));
        }
    }

    private int parseBridgeSize(String userInput) {
        int parsed = Integer.parseInt(userInput);
        if (parsed < MIN_BRIDGE_SIZE || MAX_BRIDGE_SIZE < parsed) {
            throw (new NumberFormatException());
        }
        return (parsed);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = readLine();
        if (UPPER.equals(userInput) || LOWER.equals(userInput)) {
            return (userInput);
        }
        throw (new IllegalArgumentException(INVALID_MOVING_ERROR_MESSAGE.toString()));
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public GameStatus readGameCommand() {
        String userInput = readLine();
        if (RESTART.equals(userInput)) {
            return (GAME_CONTINUE);
        }
        if (QUIT.equals(userInput)) {
            return (GAME_FAIL);
        }
        throw (new IllegalArgumentException(INVALID_STATUS_ERROR_MESSAGE.toString()));
    }
}
