package bridge.core;

import bridge.BridgeMaker;
import bridge.core.exception.Error;
import bridge.core.exception.InvalidInputException;
import bridge.domain.Bridge;

import java.util.List;

import static java.util.regex.Pattern.matches;

public class GameInitializer {

    public BridgeGame init(String bridgeLength) {
        validateNonNumeric(bridgeLength);
        BridgeMaker bridgeMaker = BridgeMaker.getBridgeMaker();
        List<String> bridgeMap = bridgeMaker.makeBridge(Integer.valueOf(bridgeLength));
        Bridge bridge = new Bridge(bridgeMap);
        GameStatusOperator gameStatusOperator = GameStatusOperator.initGameStatusOperator();
        return new BridgeGame(bridge, gameStatusOperator);
    }

    //== validation ==//
    private void validateNonNumeric(String input) {
        String pattern = "^[0-9]+$";
        if (!matches(pattern, input)) throw new InvalidInputException(Error.NON_NUMERIC_ERROR);
    }
}
