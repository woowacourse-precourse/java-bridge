package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameResults;

import java.util.List;
import java.util.StringJoiner;

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
        final String BRIDGE_PREFIX = "[ ";
        final String BRIDGE_SUFFIX = " ]";
        final String BRIDGE_DELIMITER = " | ";

        return BRIDGE_PREFIX + String.join(BRIDGE_DELIMITER, results) + BRIDGE_SUFFIX;
    }

    String finalResultFormat(final BridgeGame bridgeGame) {
        return new StringJoiner("\n")
                .add("최종 게임 결과")
                .add(bridgeFormat(bridgeGame.bridgeGameResults()))
                .add("게임 성공 여부: " + bridgeGame.gameResult())
                .add("총 시도한 횟수: " + bridgeGame.totalNumberOfChallenges())
                .toString();
    }
}
