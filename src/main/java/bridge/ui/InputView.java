package bridge.ui;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private Integer bridgeLength;
    private static final List<String> CORRECT_MOVING_CASE = new ArrayList(Arrays.asList("D", "U"));
    private boolean invalidMoving = true;
    private String nextMoving;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while (bridgeLength == null) {
            receiveLength();
        }

        return bridgeLength;
    }

    private void receiveLength() {
        try {
            String bridgeSize = Console.readLine();
            int sizeNumber = makeSureNumber(bridgeSize);
            checkLengthRange(sizeNumber);
            bridgeLength = sizeNumber;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private int makeSureNumber(String input) throws IllegalArgumentException {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException numberFormatException) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private void checkLengthRange(int input) throws IllegalArgumentException{
        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        invalidMoving = true;
        while (invalidMoving) {
            receiveMovingChoice();
        }

        return nextMoving;
    }

    private void receiveMovingChoice() {
        try {
            String movingInput = Console.readLine();
            checkMove(movingInput);
            nextMoving = movingInput;
            invalidMoving = false;
        } catch (IllegalArgumentException illegalArgumentException) {
            System.out.println(illegalArgumentException.getMessage());
        }
    }

    private void checkMove(String input) throws IllegalArgumentException {
        boolean correctCase = CORRECT_MOVING_CASE.contains(input);
        if (!correctCase) {
            throw new IllegalArgumentException("[ERROR] 대문자 'D' 혹은 'U' 만 입력 가능합니다");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
