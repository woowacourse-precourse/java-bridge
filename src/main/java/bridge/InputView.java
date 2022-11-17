package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String readBridgeSizeMessage = "다리의 길이를 입력해주세요.";
    private static final String readBridgeSizeErrorMessage = "[ERROR] 숫자를 입력해 주세요.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMessage);
        return parseStrToInt(Console.readLine());
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

    /**
     * String을 Integer로 파싱한다.
     * 숫자가 아닌 문자일 경우 IllegalArgumentException을 발생 시킨다.
     */
    private int parseStrToInt(String str) {
        int ret;
        try {
            ret = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(readBridgeSizeErrorMessage);
        }
        return ret;
    }
}
