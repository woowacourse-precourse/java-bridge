package bridge.view;

import bridge.validator.*;
import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private final NumberValidator numberValidator;
    private final SingleCharacterValidator singleCharacterValidator;
    private final UppercaseValidator uppercaseValidator;

    public InputView(
            NumberValidator numberValidator,
            SingleCharacterValidator singleCharacterValidator,
            UppercaseValidator uppercaseValidator
    ) {
        this.numberValidator = numberValidator;
        this.singleCharacterValidator = singleCharacterValidator;
        this.uppercaseValidator = uppercaseValidator;
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String input = getInput();
        numberValidator.validate(input);
        return Integer.parseInt(input);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMove() {
        String input = getInput();
        singleCharacterValidator.validate(input);
        uppercaseValidator.validate(input);
        return input;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        String input = getInput();
        singleCharacterValidator.validate(input);
        uppercaseValidator.validate(input);
        return input;
    }

    private String getInput() {
        return Console.readLine();
    }

}
