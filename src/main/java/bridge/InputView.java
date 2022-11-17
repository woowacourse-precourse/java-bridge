package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    final String readBridgeSizeMs = "다리의 길이를 입력해주세요.";
    final String readMovingMs = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    final String readGameCommandMs = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    final String exceptNumber = "[ERROR] 3이상 20이하의 숫자를 입력해주세요.";
    final String exceptMoving = "[ERROR] U 혹은 D를 입력해주세요.";
    final String exceptRetry = "[ERROR] R 혹은 Q를 입력해주세요.";
    static int size;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMs);
        try {
            String input = Console.readLine();
            if (checkNumber(input)) getSize();
            size = Integer.parseInt(input);
            if (size < 3 || size > 20) getSize();
        } catch (IllegalArgumentException e) {
            size = readBridgeSize();
        }
        return size;
    }

    void getSize() {
        System.out.println(exceptNumber);
        throw new IllegalArgumentException();
    }

    private boolean checkNumber(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            return true;
        }
        return false;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String input;
        System.out.println(readMovingMs);
        try {
            input = Console.readLine().toUpperCase();
            if (!Objects.equals(input, "U") && !Objects.equals(input, "D")) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(exceptMoving);
            input = readMoving();
        }
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input;
        System.out.println(readGameCommandMs);
        try {
            input = Console.readLine();
            if (!Objects.equals(input, "R") && !Objects.equals(input, "Q")) throw new IllegalArgumentException();
        } catch (IllegalArgumentException e) {
            System.out.println(exceptRetry);
            input = readGameCommand();
        }
        return input;
    }
}
