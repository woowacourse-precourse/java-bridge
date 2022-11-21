package bridge.core;

import bridge.domain.Bridge;

import java.util.List;

import static java.util.regex.Pattern.matches;

public class GameInitializer {

    public BridgeGame init(String bridgeLength) {
        validate(bridgeLength);
        BridgeMaker bridgeMaker = BridgeMaker.getBridgeMaker();
        List<String> bridgeMap = bridgeMaker.makeBridge(Integer.valueOf(bridgeLength));
        Bridge bridge = new Bridge(bridgeMap);
        GameStatusOperator gameStatusOperator = GameStatusOperator.initGameStatusOperator();
        return new BridgeGame(bridge, gameStatusOperator);
    }

    private void validate(String input) {
        if (validateNonNumeric(input) || validateOutOfRange(input)) {
            throw new IllegalArgumentException();
        }
    }

    private boolean validateNonNumeric(String input) {
        String pattern = "^[0-9]+$";
        if (!matches(pattern, input)) return true;
        return false;
    }

    private boolean validateOutOfRange(String input) {
        Integer number = Integer.valueOf(input);
        if (number < 3 || number > 20) return true;
        return false;
    }
}
