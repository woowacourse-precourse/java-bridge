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
    final String sizeExceptionMs = "[ERROR] 3이상 20이하의 숫자를 입력해주세요.";
    final String movingExceptionMs = "[ERROR] U 혹은 D를 입력해주세요.";
    final String retryExceptionMs = "[ERROR] R 혹은 Q를 입력해주세요.";
    final String gameStart = "다리 건너기 게임을 시작합니다.\n";
    int size;
    String input;

    public void printStart() {
        System.out.println(gameStart);
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(readBridgeSizeMs);
        try {
            input = getInput();
            if (confirmInteger(input) || confirmRange(input)) sizeException(); //숫자가 아니라면, 또는 3~20 사이의 범위가 아닐경우
            size = Integer.parseInt(input);
        } catch (IllegalArgumentException e) {
            size = readBridgeSize();
        }
        return size;
    }

    private boolean confirmRange(String input) {
        return Integer.parseInt(input) < 3 || Integer.parseInt(input) > 20;
    }

    void sizeException() {
        System.out.println(sizeExceptionMs);
        throw new IllegalArgumentException(sizeExceptionMs);
    }

    private boolean confirmInteger(String input) {
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
        System.out.println(readMovingMs);
        try {
            input = getInput().toUpperCase();
            if (confirmMoving()) movingException();
        } catch (IllegalArgumentException e) {
            input = readMoving();
        }
        return input;
    }

    private boolean confirmMoving() {
        return !Objects.equals(input, "U") && !Objects.equals(input, "D");
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(readGameCommandMs);
        try {
            input = getInput();
            if (confirmRetry()) retryException();
        } catch (IllegalArgumentException e) {
            input = readGameCommand();
        }
        return input;
    }

    private void retryException() {
        System.out.println(retryExceptionMs);
        throw new IllegalArgumentException(retryExceptionMs);
    }

    private boolean confirmRetry() {
        return !Objects.equals(input, "R") && !Objects.equals(input, "Q");
    }

    private String getInput() {
        return Console.readLine();
    }

    void movingException() {
        System.out.println(movingExceptionMs);
        throw new IllegalArgumentException(movingExceptionMs);
    }
}
