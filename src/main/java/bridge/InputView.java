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

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String uOrD = isUOrD(inputMoving());
        return uOrD;
    }

    public String inputMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String input = Console.readLine();
        return input;
    }

    public String isUOrD(String input) {
        if("U".equals(input) || "D".equals(input)) {
            return input;
        }
        throw new IllegalArgumentException("U 또는 D만 입력할 수 있습니다.");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public static int stringToInt(String input) {
        return Integer.parseInt(input);
    }
}
