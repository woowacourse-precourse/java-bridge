package bridge.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 20;

    public String input() {
        return Console.readLine();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String size) throws IllegalArgumentException {
        validateIsNotEmpty(size);
        validateIsNumber(size);
        return validateIsLengthRange(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String direction) throws IllegalArgumentException {
        validateIsNotEmpty(direction);
        validateDirection(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    public void validateIsNotEmpty(String size) {
        if(size.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 입력이 비어있습니다.");
        }
    }

    public void validateIsNumber(String size) {
        String regExp = "^[0-9]*$";
        if(!size.matches(regExp) || String.valueOf(size.charAt(0)).equals("0")) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    public int validateIsLengthRange(String input) {
        int size = Integer.parseInt(input);
        if(size < MIN_LENGTH || size > MAX_LENGTH) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        return size;
    }

    public void validateDirection(String direction) {
        if(!isExistDirection(direction)) {
            throw new IllegalArgumentException("[ERROR] U(위) 또는 D(아래)만을 입력해야 합니다.");
        }
    }

    public boolean isExistDirection(String direction) {
        return Arrays.asList("U", "D").contains(direction);
    }
}
