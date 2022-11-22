package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 길이를 입력 해 주세요");
        int input;
        try {
            input = Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 숫자만 입력 가능합니다");
        }
        isAvailableNumber(input);
        return input;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String str = Console.readLine();
        isAvailableWord(str);

        return str;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String input = Console.readLine();
        isAvailableCommand(input);
        return input;
    }

    public void isAvailableNumber(int bridgeSize) {
        if (!(2 < bridgeSize && bridgeSize < 21)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public void isAvailableWord(String word) {
        String pattern = "[UD]";
        if (!Pattern.matches(pattern, word)) {
            throw new IllegalArgumentException("[ERROR] U와 D만 입력 가능합니다");
        }
    }

    public void isAvailableCommand(String input) {
        String pattern = "[RQ]";
        if (!Pattern.matches(pattern, input)) {
            throw new IllegalArgumentException("[ERROR] R과 Q만 입력 가능합니다.");
        }
    }
}
