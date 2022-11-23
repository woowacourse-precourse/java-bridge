package bridge;

import bridge.InputValidation;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    InputValidation checkValidation = new InputValidation();
    private boolean isRightInput;

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String bridgeSizeInput;
        do{
            bridgeSizeInput = Console.readLine();
            isRightInput = checkValidation.validateBridgeLength(bridgeSizeInput);
        }while(!isRightInput);

        return Integer.parseInt(bridgeSizeInput);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String movingInput;
        do{
            movingInput = Console.readLine();
            isRightInput = checkValidation.validateMovingInput(movingInput);
        }while(!isRightInput);

        return movingInput;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String gameCommandInput;
        do{
            gameCommandInput = Console.readLine();
            isRightInput = checkValidation.validateGameCommandInput(gameCommandInput);
        }while(!isRightInput);

        return gameCommandInput;
    }
}
