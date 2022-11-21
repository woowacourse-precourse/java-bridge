package bridge;

import bridge.constant.ErrorMessage;
import bridge.constant.EventMessage;
import bridge.util.Converter;
import bridge.util.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(EventMessage.INPUT_BRIDGE_SIZE);
        String input = getNumberInput();

        // 문자열 -> 숫자로 변환
        int bridgeSize = Converter.StringToInteger(input);

        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(EventMessage.INPUT_MOVING_SIZE);
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }

    private String getNumberInput(){
        String input = Console.readLine().trim();
        validateNumberInput(input);
        return input;
    }

    private void validateNumberInput(String input){
        validateEmptyInput(input);
        validateHasCharacterInput(input);
    }

    private void validateEmptyInput(String input){
        if (Validator.isEmpty(input)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_IS_EMPTY_ERROR.getMessage());
        }
    }

    private void validateHasCharacterInput(String input){
        if (!Validator.hasNotCharacter(input)){
            throw new IllegalArgumentException(ErrorMessage.INPUT_HAS_CHARACTER_ERROR.getMessage());
        }
    }
}
