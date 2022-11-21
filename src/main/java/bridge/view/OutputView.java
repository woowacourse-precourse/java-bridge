package bridge.view;

import static bridge.constant.Message.FINAL_GAME_RESULT;
import static bridge.constant.Message.GAME_SUCCESS_OR_NOT;
import static bridge.constant.Message.TOTAL_COUNT_OF_TRY;

import bridge.BridgeGame;
import bridge.GameResult;
import bridge.constant.Message;
import java.text.MessageFormat;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static final String BEGINNING_BRIDGE = "[ ";
    private static final String END_BRIDGE = " ]";
    private static final String BLOCK_SEPARATOR = " | ";

    private static final String SUCCESS= "성공";
    private static final String FAIL= "실패";
    private static final String NEW_LINE= "\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(BridgeGame bridgeGame) {
        GameResult gameResult = bridgeGame.getGameResult();
        printBridge(gameResult.getUpperBridge(), gameResult.getLowerBridge());
    }

    private String makeBridgeFormat(List<String> bridgeResult) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(BEGINNING_BRIDGE);
//        int i = 0;
//        while(i < bridgeResult.size() - 1) {
//            stringBuilder.append(bridgeResult.get(i));
//            stringBuilder.append(BLOCK_SEPARATOR);
//            i++;
//        }
//        stringBuilder.append(END_BRIDGE);
        for (int i = 0; i < bridgeResult.size(); i++) {
            stringBuilder.append(bridgeResult.get(i));
            if (i == bridgeResult.size() - 1) {
                stringBuilder.append(END_BRIDGE);
                break;
            }
            stringBuilder.append(BLOCK_SEPARATOR);
        }
        return stringBuilder.toString();
    }

    private void printBridge(List<String> upperBridge, List<String> lowerBridge) {
        System.out.println(makeBridgeFormat(upperBridge));
        System.out.println(makeBridgeFormat(lowerBridge) + NEW_LINE);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame, int countTry) {
        printMessage(FINAL_GAME_RESULT);
        printBridge(bridgeGame.getGameResult().getUpperBridge(), bridgeGame.getGameResult()
                .getLowerBridge());
        String messageFormat = MessageFormat.format(GAME_SUCCESS_OR_NOT.toString() + TOTAL_COUNT_OF_TRY.getMessage(), getResultMessage(bridgeGame), Integer.toString(countTry));
        System.out.print(messageFormat);
    }

    private String getResultMessage(BridgeGame bridgeGame) {
        if (bridgeGame.getMoveState()) {
            return SUCCESS;
        }
        return FAIL;
    }

    public void printMessageWithNewLine(Message message) {
        System.out.println(message.toString());
    }

    public void printMessage(Message message) {
        System.out.println(message.getMessage());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    public void printNewLine() {
        System.out.println();
    }
}
