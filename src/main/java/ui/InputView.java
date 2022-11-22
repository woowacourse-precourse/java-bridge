package ui;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    Validator validator = new Validator();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        int validatedBridgeSize;
        while (true) {
            System.out.println("다리의 길이를 입력해주세요.");
            String userInput = readLine();
            try {
                validatedBridgeSize = validator.validateBridgeSizeInput(userInput);
                return validatedBridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String validatedUserMoving;
        while (true) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String userInput = readLine();
            try {
                validatedUserMoving = validator.validateMovingInput(userInput);
                return validatedUserMoving;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String validatedUserGameCommand;
        while (true) {
            System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
            String userInput = readLine();
            try {
                validatedUserGameCommand = validator.validateGameCommandInput(userInput);
                return validatedUserGameCommand;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
