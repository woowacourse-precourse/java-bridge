package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    /**
     * readInput()을 통해 입력된 값을
     * 인자로 받은 람다식에 대입하여 true 값이 나올 때까지
     * 재입력을 반복시켜주는 메소드
     *
     * @param lambda 원하는 조건을 가진 람다식
     * @return true 값이 나온 입력
     */
    private String loopUntilValid(Input lambda) {
        String rawInput;
        boolean isRawInputValid;
        do {
            rawInput = readInput();
            isRawInputValid = catchIfFail(lambda, rawInput);
        } while (!isRawInputValid);
        return rawInput;
    }

    /**
     * 입력값을 Input 인터페이스의 람다식에 대입 후, 에러가 발생하면 에러 메세지와 false 를 반환 <br>
     * 람다식에서 에러가 발생하지 않으면 true 반환
     *
     * @param input 사용자의 입력값
     */
    private boolean catchIfFail(Input lambda, String input) {
        try {
            return lambda.check(input);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return false;
        }
    }

    /**
     * 사용자의 입력을 받는 메소드
     *
     * @return 사용자가 입력한 String 값
     */
    private String readInput() {
        return Console.readLine();
    }

    /**
     * 사용자의 입력을 받아 다리 길이를 반환
     */
    public int readBridgeSize() {
        String size = loopUntilValid(
                (input) -> ValidateInput.isAllDigit(input) && ValidateInput.isInRange(input));
        return Integer.parseInt(size);
    }


    /**
     * 사용자의 입력을 받아 이동할 방향 반환
     */
    public String readMoving() {
        return loopUntilValid(ValidateInput::isUorD);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return loopUntilValid(ValidateInput::isRorQ);
    }
}
