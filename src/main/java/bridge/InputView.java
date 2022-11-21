package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * readInput()을 통해 입력된 값을
     * 인자로 받은 람다식에 대입하여 true 값이 나올 때까지 반복시켜주는 메소드
     *
     * @param lambda true 가 나올 때까지 반복하고 싶은 람다식(Loopable 인터페이스를 받는)
     * @return true 값이 나온 입력
     */
    private String loopUntilValid(Loopable lambda) {
        String rawInput;
        boolean isRawInputValid;
        do {
            rawInput = readInput();
            isRawInputValid = lambda.check(rawInput);
        } while (!isRawInputValid);
        return rawInput;
    }

    /**
     * 사용자의 입력을 받는 메소드
     * @return 사용자가 입력한 String 값
     */
    private String readInput() {
        return Console.readLine();
    }

    /**
     * 사용자의 입력을 받아 다리 길이를 반환
     */
    public int readBridgeSize() {
        String size = loopUntilValid((input) -> {
            try {
                return ValidateInput.isAllDigit(input) && ValidateInput.isInRange(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                return false;
            }
        });
        return Integer.parseInt(size);
    }

    /**
     * 사용자의 입력을 받아 이동할 방향 반환
     */
    public String readMoving() {
        return loopUntilValid((input) -> {
            try {
                return ValidateInput.isUorD(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                return false;
            }
        });
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return loopUntilValid((input) -> {
            try {
                return ValidateInput.isRorQ(input);
            } catch (IllegalArgumentException e) {
                System.out.println("[ERROR] " + e.getMessage());
                return false;
            }
        });
    }
}
