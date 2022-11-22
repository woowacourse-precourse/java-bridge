package bridge.view;

import bridge.domain.BridgeMoveType;
import bridge.domain.BridgeGameHistory;

import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static bridge.config.CharacterConfiguration.ENTER;
import static bridge.domain.BridgeMoveType.*;
import static bridge.config.BridgeConfiguration.*;
import static bridge.view.OutputViewMessage.*;

public class OutputView {

    public void printMap(BridgeGameHistory bridgeGameHistory) {
        List<BridgeMoveType> playerMoveHistory = bridgeGameHistory.getPlayerBridge();
        List<BridgeMoveType> bridgeAnswerHistory = bridgeGameHistory.getBridgeAnswer();

        String bridgeUpHistory = createBridgeHistory(playerMoveHistory, bridgeAnswerHistory, UP);
        String bridgeDownHistory = createBridgeHistory(playerMoveHistory, bridgeAnswerHistory, DOWN);

        System.out.print(MessageFormat.format("{0}{1}{2}{3}{4}",
                bridgeUpHistory, ENTER.getConfig(), bridgeDownHistory, ENTER.getConfig(), ENTER.getConfig()));
    }

    public void printResult(BridgeGameHistory bridgeGameHistory) {
        System.out.print(FINAL_GAME_RESULT.getMessage());
        printMap(bridgeGameHistory);
        System.out.print(
                MessageFormat.format(GAME_WIN_RESULT.getMessage(), bridgeGameHistory.getGameResult().getType()));
        System.out.print(
                MessageFormat.format(TOTAL_ROUND.getMessage(), bridgeGameHistory.getBridgeGameRound()));
    }

    private String createBridgeHistory(List<BridgeMoveType> playerMoveHistory,
                                       List<BridgeMoveType> bridgeAnswerHistory,
                                       BridgeMoveType bridgeType
    ) {
        return LEFT_SQUARE_BRACKET.getConfig() +
                IntStream.range(0, playerMoveHistory.size())
                        .mapToObj(currentLocation -> {
                            BridgeMoveType answerMoveType = bridgeAnswerHistory.get(currentLocation);
                            BridgeMoveType playerMoveType = playerMoveHistory.get(currentLocation);
                            return convertToBridgeHistoryFrom(bridgeType, answerMoveType, playerMoveType);
                        }).collect(Collectors.joining(VERTICAL_BAR.getConfig())) +
                RIGHT_SQUARE_BRACKET.getConfig();
    }

    private String convertToBridgeHistoryFrom(BridgeMoveType bridgeType,
                                              BridgeMoveType answerMoveType,
                                              BridgeMoveType playerMoveType
    ) {
        if (answerMoveType.isSame(bridgeType)) {
            if (answerMoveType.isSame(playerMoveType)) {
                return BRIDGE_CORRECT_EXPRESSION.getConfig();
            }
            return BRIDGE_EMPTY_EXPRESSION.getConfig();
        }
        if (answerMoveType.isNotSame(playerMoveType)) {
            return BRIDGE_NOT_CORRECT_EXPRESSION.getConfig();
        }
        return BRIDGE_EMPTY_EXPRESSION.getConfig();
    }

    public void printException(String message) {
        System.out.println(message);
    }
}
