package bridge.view;

import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import bridge.domain.validation.BridgeSize;

public class InputValueConverter {

    BridgeSize bridgeSize(String inputValue) {
        validateThisIsNumber(inputValue);
        return new BridgeSize(Integer.parseInt(inputValue));
    }

    MoveCommands moveCommands(String inputValue) {
        return MoveCommands.of(inputValue);
    }

    GameCommands gameCommands(String inputValue) {
        return GameCommands.of(inputValue);
    }

    private void validateThisIsNumber(final String inputValue) {
        final String REGEX_FOR_NUMBER = "^\\d+$";
        if (!inputValue.matches(REGEX_FOR_NUMBER)) {
            throw new IllegalArgumentException("숫자만 입력해 주세요.");
        }
    }
}
