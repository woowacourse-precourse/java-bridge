package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String userInput = readLine();
        try {
            return validateBridgeSize(userInput);
        } catch (IllegalArgumentException e) {
            return readBridgeSize();
        }
    }

    /**
     * 다리의 길이가 적절한 값인지 판단한다.
     * 예외 발생시 IllegalArgumentException을 발생시킨다.
     *
     * @param userInput 사용자가 입력한 문자열
     * @return <p>[3,20] - 올바른 값
     * <p>-1 - 올바르지 않은 값
     */
    public int validateBridgeSize(String userInput) {
        try {
            int number = Integer.parseInt(userInput);
            if (3 <= number && number <= 20) return number;
            System.out.println("[ERROR] 다리 크기는 3이상 20이하의 자연수여야 합니다.");
        } catch (NumberFormatException e) {
            System.out.println("[ERROR] 다리 크기는 정수여야 합니다.");
        }
        throw new IllegalArgumentException();
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String userInput = readLine();
        try {
            validateMove(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            return readMoving();
        }
    }

    /**
     * 이동할 칸의 입력이 적절한지 판단한다.
     * 예외 발생시 IllegalArgumentException을 발생시킨다.
     *
     * @param userInput 사용자가 입력한 문자열
     * @return <p>[U,D] - 올바른 값
     * <p>-1 - 올바르지 않은 값
     */
    public void validateMove(String userInput) {
        if (userInput.equals("U") || userInput.equals("D")) return;
        System.out.println("[ERROR] 입력 값은 \"U\" 또는 \"D\"여야 합니다.");
        throw new IllegalArgumentException();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String userInput = readLine();
        try {
            validateGameCommand(userInput);
            return userInput;
        } catch (IllegalArgumentException e) {
            return readGameCommand();
        }
    }

    /**
     * 다시 시도 입력값이 적절한지 판단한다.
     * 예외 발생시 IllegalArgumentException을 발생시킨다.
     *
     * @param userInput 사용자가 입력한 문자열
     * @return [R, Q] - 올바른 값
     */
    public void validateGameCommand(String userInput) {
        if (userInput.equals("R") || userInput.equals("Q")) return;
        System.out.println("[ERROR] 입력 값은 \"R\" 또는 \"Q\"여야 합니다.");
        throw new IllegalArgumentException();
    }


}
