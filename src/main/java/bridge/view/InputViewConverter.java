package bridge.view;

import bridge.constant.GameCommand;
import bridge.constant.MoveCommand;
import bridge.domain.BridgeSizeValidator;

public class InputViewConverter {

    BridgeSizeValidator bridgeSize(String inputValue) {
        validateThisIsNumber(inputValue);
        return new BridgeSizeValidator(Integer.parseInt(inputValue));
    }

    MoveCommand moveCommands(String inputValue) {
        return MoveCommand.of(inputValue);
    }

    GameCommand gameCommands(String inputValue) {
        return GameCommand.of(inputValue);
    }

    private void validateThisIsNumber(final String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}
