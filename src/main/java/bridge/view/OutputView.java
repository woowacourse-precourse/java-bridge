package bridge.view;

import static bridge.constant.Message.FAIL;
import static bridge.constant.Message.FINAL_GAME_RESULT;
import static bridge.constant.Message.GAME_SUCCESS_OR_NOT;
import static bridge.constant.Message.SUCCESS;
import static bridge.constant.Message.TOTAL_COUNT_OF_TRY;

import bridge.model.BridgeGame;
import bridge.model.GameResult;
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
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
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
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
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
