package bridge.view;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final String INPUT_BRIDGE_SIZE_INFO_MESSAGE = "다리의 길이를 입력해 주세요.";

    private static final String POSITIVE_NUMBER_INPUT_ERROR_MESSAGE = "[ERROR] 양의 숫자를 입력하여야 합니다.";

    private static final String POSITIVE_NUMBER_REGEX = "^[1-9]+\\d*$";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        printInputBridgeSizeInfoMessage();
        String bridgeSizeInput = Console.readLine();
        validateIsPositiveNumber(bridgeSizeInput);
        return Integer.parseInt(bridgeSizeInput);
    }

    private void printInputBridgeSizeInfoMessage(){
        System.out.println(INPUT_BRIDGE_SIZE_INFO_MESSAGE);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private void validateIsPositiveNumber(String input){
        if(input.matches(POSITIVE_NUMBER_REGEX)){
            return;
        }
        throw new IllegalArgumentException(POSITIVE_NUMBER_INPUT_ERROR_MESSAGE);
    }
}
