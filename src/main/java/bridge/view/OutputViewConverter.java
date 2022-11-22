package bridge.view;

import bridge.constant.OutputMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResults;

import java.util.List;
import java.util.StringJoiner;

import static bridge.constant.OutputMessage.*;

public class OutputViewConverter {

    String bridgeFormat(final BridgeGameResults bridgeGameResults) {
        String upResultFormat = resultFormat(bridgeGameResults.upLineResults());
        String downResultFormat = resultFormat(bridgeGameResults.downLineResults());

        return new StringJoiner("\n")
                .add(upResultFormat)
                .add(downResultFormat)
                .toString();
    }

    private String resultFormat(final List<String> results) {
        final String BRIDGE_PREFIX = LEFT_BOARDER.getMessage();
        final String BRIDGE_SUFFIX = RIGHT_BOARDER.getMessage();
        final String BRIDGE_DELIMITER = BAR.getMessage();

        return BRIDGE_PREFIX + String.join(BRIDGE_DELIMITER, results) + BRIDGE_SUFFIX;
    }

    String finalResultFormat(final BridgeGame bridgeGame) {
        return new StringJoiner("\n")
                .add(FINAL_GAME_RESULT_MESSAGE.getMessage())
                .add(bridgeFormat(bridgeGame.bridgeGameResults()))
                .add(SUCCESS_MESSAGE.getMessage() + bridgeGame.gameResult())
                .add(RETRY_SUM_MESSAGE.getMessage() + bridgeGame.totalChallengeNumbers())
                .toString();
    }
}
