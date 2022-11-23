package bridge.view;

import bridge.domain.game.BridgeGame;
import bridge.domain.game.BridgeGameResult;

import java.util.List;
import java.util.stream.Collectors;

import static bridge.util.Constants.*;


public class OutputView {
    StringBuilder sb = new StringBuilder();

    public void printMap(BridgeGameResult bridgeGameResult) {
        String bridgeStatus = getBridgeStatus(bridgeGameResult);
        System.out.println(bridgeStatus);
    }

    public void printResult(BridgeGame bridgeGame, boolean isCorrect) {
        printResultGuide();
        printMap(bridgeGame.getGameResult());
        System.out.println(getResultString(bridgeGame.getGameRoundCount(), isCorrect));
    }

    public void printStartGuide() {
        System.out.println(START_GUIDE);
    }

    public void printInputBridgeLengthGuide() {
        System.out.println(INPUT_BRIDGE_LENGTH_GUIDE);
    }

    public void printInputMovingGuide() {
        System.out.println(INPUT_MOVING_GUIDE);
    }

    public void printInputRestartOptionGuide() {
        System.out.println(INPUT_RESTART_OPTION_GUIDE);
    }

    public void printResultGuide() {
        System.out.println(RESULT_GUIDE);
    }

    public String getBridgeStatus(BridgeGameResult bridgeGameResult) {
        sb.setLength(0);
        sb.append(getSingleBridgeStatus(bridgeGameResult.getUpperBridge()))
                .append(SEPARATOR)
                .append(getSingleBridgeStatus(bridgeGameResult.getDownBridge()))
                .append(SEPARATOR);
        return sb.toString();
    }

    private String getSingleBridgeStatus(List<String> bridge) {
        return bridge.stream()
                .collect(Collectors.joining(RESULT_MAP_DELIMITER,
                        RESULT_MAP_PREFIX,
                        RESULT_MAP_SUFFIX));
    }

    private String getResultString(int count, boolean isCorrect) {
        sb.setLength(0);

        sb.append(getIsCorrectString(isCorrect))
                .append(SEPARATOR)
                .append(getCountString(count))
                .append(SEPARATOR);
        return sb.toString();
    }

    private String getCountString(int count) {
        return String.format(COUNT_STRING_GUIDE, count);
    }

    private String getIsCorrectString(boolean isCorrect) {
        return String.format(IS_CORRECT_STRING_GUIDE, changeIsCorrectToString(isCorrect));
    }

    private String changeIsCorrectToString(boolean isCorrect) {
        if (isCorrect) {
            return CORRECT_STRING;
        }
        return WRONG_STRING;
    }

    public void printErrorMessage(Exception e) {
        System.out.println(e.getMessage());
    }

    public void printRetryGuide(int tryCnt) {
        System.out.printf(RETRY_GUIDE, tryCnt);
    }
}
