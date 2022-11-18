package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.move_result.MoveResults;
import java.util.List;
import java.util.StringJoiner;

public class OutputViewFormatter {

    String bridgeFormat(final MoveResults moveResults) {
        String upResultFormat = resultFormat(moveResults.upLineResults());
        String downResultFormat = resultFormat(moveResults.downLineResults());

        return new StringJoiner("\n")
                .add(upResultFormat)
                .add(downResultFormat)
                .toString();
    }

    private String resultFormat(final List<String> results) {
        return "[ " + String.join(" | ", results) + " ]";
    }

    String resultFormat(final BridgeGame bridgeGame, final String gameResult) {
        return new StringJoiner("\n")
                .add("최종 게임 결과")
                .add(bridgeFormat(bridgeGame.moveResults()))
                .add("게임 성공 여부: " + gameResult)
                .add("총 시도한 횟수: " + bridgeGame.totalNumberOfChallenges())
                .toString();
    }
}
