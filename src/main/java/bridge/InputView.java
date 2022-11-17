package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int bridgeSizeMin = 3;
    private static final int bridgeSizeMax = 20;

    private static final String readBridgeSizeMessage = "다리의 길이를 입력해주세요.";
    private static final String readMovingMessage = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String parseStrToIntErrorMessage = "[ERROR] 숫자를 입력해 주세요.";
    private static final String validateBridgeSizeErrorMessage = "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String validateMovingErrorMessage = "[ERROR] U 또는 D를 입력해야 합니다.";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMessage);
        try {
            return validateBridgeSize(parseStrToInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(readMovingMessage);
        try {
            return validateMoving(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
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
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(parseStrToIntErrorMessage);
        }
    }

    /**
     * 매개변수 size가 3 이상 20 이하가 아니면 IllegalArgumentException을 발생 시킨다.
     */
    private int validateBridgeSize(int size) {
        if (size < bridgeSizeMin || size > bridgeSizeMax)
            throw new IllegalArgumentException(validateBridgeSizeErrorMessage);
        return size;
    }

    /**
     * 매개변수 str이 U나 D가 아니면 IllegalArgumentException을 발생 시킨다.
     */
    private String validateMoving(String str) {
        if (!(str.equals("U") || str.equals("D")))
            throw new IllegalArgumentException(validateMovingErrorMessage);
        return str;
    }
}
