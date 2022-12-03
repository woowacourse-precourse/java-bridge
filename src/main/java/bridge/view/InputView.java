package bridge.view;

import bridge.validator.BridgeSizeValidator;
import bridge.validator.DirectionValidator;
import bridge.validator.GameCommandValidator;
import bridge.validator.Validator;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private final BridgeSizeValidator bridgeSizeValidator;
    private final DirectionValidator directionValidator;
    private final GameCommandValidator gameCommandValidator;

    public InputView() {
        bridgeSizeValidator = new BridgeSizeValidator();
        directionValidator = new DirectionValidator();
        gameCommandValidator = new GameCommandValidator();
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return Integer.parseInt(readInputValue(bridgeSizeValidator));
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readInputValue(directionValidator);
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readInputValue(gameCommandValidator);
    }

    private String readInputValue(Validator validator) {
        String inputValue;
        do {
            inputValue = Console.readLine();
        } while (!validateInputValue(inputValue, validator));
        return inputValue;
    }

    private boolean validateInputValue(String inputValue, Validator validator) {
        try {
            validator.validate(inputValue);
            return true;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
        return false;
    }
}
