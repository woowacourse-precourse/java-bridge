package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (true) {
            try {
                System.out.println("\n다리의 길이를 입력해주세요.");
                String input = Console.readLine();
                validateBridgeSize(input);
                return Integer.parseInt(input);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateBridgeSize(String input) {
        String regex = "^[0-9]+$";
        Matcher matcher = Pattern.compile(regex).matcher(input);
        if (!matcher.matches()) {
            throw new IllegalArgumentException("[ERROR] 길이는 숫자여야 합니다.");
        }
        int bridgeSize = Integer.parseInt(input);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3~20 이하의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while (true) {
            try {
                System.out.println("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
                String input = Console.readLine();
                validateMoving(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateMoving(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] U, D 중 하나를 입력해주세요.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while (true) {
            try {
                System.out.println("\n게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String input = Console.readLine();
                validateGameCommand(input);
                return input;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] R, Q 중 하나를 입력해주세요.");
        }
    }
}
