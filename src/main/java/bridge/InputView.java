package bridge;

import camp.nextstep.edu.missionutils.Console;



/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String ERROR_MESSAGE = "[ERROR]";
    private final ValidationCheck validation = new ValidationCheck();

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() throws IllegalArgumentException {
        try {
            String bridgeSizeStr = Console.readLine();
            return validation.checkBridgeSizeRange(validation.toInts(validation.isBlank(bridgeSizeStr)));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            return readBridgeSize();
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() throws IllegalArgumentException {
        try {
            String moving = Console.readLine();
            return validation.checkMovingEnum(validation.isBlank(moving));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            return readMoving();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand()throws IllegalArgumentException {
        try {
            String gameCommand = Console.readLine();
            return validation.checkGameCommand(validation.isBlank(gameCommand));
        } catch (IllegalArgumentException illegalArgumentException){
            System.out.println(ERROR_MESSAGE + illegalArgumentException.getMessage());
            return readMoving();
        }
    }


}
