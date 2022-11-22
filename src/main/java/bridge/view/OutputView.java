package bridge.view;

import static bridge.domain.Message.FAIL;
import static bridge.domain.Message.FINAL_GAME_RESULT;
import static bridge.domain.Message.GAME_SUCCESS_OR_NOT;
import static bridge.domain.Message.SUCCESS;
import static bridge.domain.Message.TOTAL_COUNT_OF_TRY;

import bridge.domain.BridgeGame;
import bridge.domain.GameResult;
import java.text.MessageFormat;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BRIDGE_BEGINNING = "[ ";
    private static final String BRIDGE_END = " ]";
    private static final String BRIDGE_BLOCK_SEPARATOR = " | ";
    private static final String NEW_LINE = "\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    public void printMap(BridgeGame bridgeGame) {
        GameResult gameResult = bridgeGame.getGameResult();
        printBridge(gameResult.getUpperBridge(), gameResult.getLowerBridge());
    }

    private void printBridge(List<String> upperBridge, List<String> lowerBridge) {
        System.out.println(makeBridgeFormat(upperBridge));
        System.out.println(makeBridgeFormat(lowerBridge));
        System.out.println();
    }

    private String makeBridgeFormat(List<String> bridgeResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BRIDGE_BEGINNING);
        appendMiddleElement(bridgeResult, stringBuilder);
        stringBuilder.append(BRIDGE_END);
        return stringBuilder.toString();
    }

    private void appendMiddleElement(List<String> bridgeResult, StringBuilder stringBuilder) {
        for (int i = 0; i < bridgeResult.size(); i++) {
            stringBuilder.append(bridgeResult.get(i));
            if (i == bridgeResult.size() - 1) {
                break;
            }
            stringBuilder.append(BRIDGE_BLOCK_SEPARATOR);
        }
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    public void printResult(BridgeGame bridgeGame) {
        printMessage(FINAL_GAME_RESULT.toString());
        GameResult gameResult = bridgeGame.getGameResult();
        printBridge(gameResult.getUpperBridge(), gameResult.getLowerBridge());

        String gameResultInfo = MessageFormat.format(
                GAME_SUCCESS_OR_NOT + NEW_LINE + TOTAL_COUNT_OF_TRY, getResultMessage(bridgeGame),
                Integer.toString(bridgeGame.getTryCount()));
        System.out.print(gameResultInfo);
    }

    private String getResultMessage(BridgeGame bridgeGame) {
        if (bridgeGame.getMoveState()) {
            return SUCCESS.toString();
        }
        return FAIL.toString();
    }

    public void printMessageWithNewLine(String message) {
        System.out.println(message + NEW_LINE);
    }

    public void printMessage(String message) {
        System.out.println(message);
    }
}
