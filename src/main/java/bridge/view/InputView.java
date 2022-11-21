package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    Validator validator = new Validator();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        while(true) {
            try {
                String size = Console.readLine();
                validateBridgeSize(size);
                return Integer.parseInt(size);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateBridgeSize(String size) {
            validator.inputSizeValidator(size);
            validator.validatorBridgeSizeRange(size);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        while(true) {
            try {
                String moving = Console.readLine();
                validator.validateMoving(moving);
                return moving;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }


    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        while(true) {
            try {
                String command = Console.readLine();
                validator.validateRetryCommand(command);
                return command;
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
