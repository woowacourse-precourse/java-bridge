package bridge.view;

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

    /**
     * 다리의 길이를 입력받는다.
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
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static String readGameCommand() {
        return null;
    }

}
