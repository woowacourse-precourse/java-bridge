package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = isNum(inputBridgeLength());
        return stringToInt(input);
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

    public String inputBridgeLength() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        return input;
    }

    public static String isNum(String input) {
        try{
            Integer.parseInt(input);
        } catch (Exception e) {
            throw new IllegalArgumentException("숫자만 입력할 수 있습니다.");
        }
        return input;
    }

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
