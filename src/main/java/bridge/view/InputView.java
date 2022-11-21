package bridge.view;

import bridge.game.BridgeGame;
import bridge.game.GameManager;
import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    // 숫자 입력
    private static final String BRIDGE_SIZE_REGEX = "^\\d*$";
    private static final int MIN_BRIDGE_SIZE = 3;
    private static final int MAX_BRIDGE_SIZE = 20;

    // D 또는 U
    private static final String USER_MOVE_DIRECTION_REGEX = "^[" + BridgeGame.BridgeShape.DOWN.getStringValue() + "|" + BridgeGame.BridgeShape.UP.getStringValue() + "]$";

    // R 또는 Q
    private static final String USER_GAME_COMMAND_REGEX = "^[" + GameManager.GameStatus.RETRY.getStatus() + "|" + GameManager.GameStatus.QUIT.getStatus() + "]$";


    /**
     * TODO: 다리의 길이를 입력받는다.
     *
     * @return 사용자가 입력한 다리의 길이
     */
    public static int readBridgeSize() {
        String bridgeSize = Console.readLine();
        if (!checkBridgeSize_regex(bridgeSize) || !checkBridgeSize_value(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException();
        }
        return Integer.parseInt(bridgeSize);
    }

    /**
     * @param bridgeSize 사용자가 입력한 다리의 길이
     * @return 정규식에 부합한다면 true / 부합하지 않는다면 false
     */
    private static boolean checkBridgeSize_regex(String bridgeSize) {
        Pattern pattern = Pattern.compile(BRIDGE_SIZE_REGEX);
        Matcher matcher = pattern.matcher(bridgeSize);
        return matcher.matches();
    }

    /**
     * @param bridgeSize 사용자가 입력한 다리의 길이
     * @return 값의 범위가 3 이상 20 이하인 경우 true / 범위를 벗어난 경우 false
     */
    private static boolean checkBridgeSize_value(int bridgeSize) {
        return bridgeSize >= MIN_BRIDGE_SIZE && bridgeSize <= MAX_BRIDGE_SIZE;
    }

    /**
     * TODO: 사용자가 이동할 칸을 입력받는다.
     *
     * @return 사용자가 입력한 이동할 칸
     */
    public static String readMoving() {
        String userMoveDirection = Console.readLine();
        if (!checkUserMoveDirection_regex(userMoveDirection)) {
            throw new IllegalArgumentException();
        }
        return userMoveDirection;
    }

    /**
     * @param userMoveDirection 사용자가 입력한 이동할 칸
     * @return 입력이 "U" 또는 "D"라면 true / 그 이외의 값이라면 false
     */
    private static boolean checkUserMoveDirection_regex(String userMoveDirection) {
        Pattern pattern = Pattern.compile(USER_MOVE_DIRECTION_REGEX);
        Matcher matcher = pattern.matcher(userMoveDirection);
        return matcher.matches();
    }

    /**
     * TODO: 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     *
     * @return 사용자가 입력한 재시작 또는 종료 여부
     */
    public static String readGameCommand() {
        String userGameCommand = Console.readLine();
        if (!checkUserGameCommand_regex(userGameCommand)) {
            throw new IllegalStateException();
        }
        return userGameCommand;
    }

    /**
     * @param userGameCommand 사용자가 입력한 재시작 또는 종료 여부
     * @return 입력이 "R" 또는 "Q"라면 true / 그 이외의 값이라면 false
     */
    private static boolean checkUserGameCommand_regex(String userGameCommand) {
        Pattern pattern = Pattern.compile(USER_GAME_COMMAND_REGEX);
        Matcher matcher = pattern.matcher(userGameCommand);
        return matcher.matches();
    }

}
