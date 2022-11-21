package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import java.util.List;

import static bridge.view.OutputConstants.*;

public class OutputView {

    public static void printStartMessage() {
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    public static void printMap(BridgeGame bridgeGame) {
        printDependOn(UP_STAIR, bridgeGame);
        printDependOn(DOWN_STAIR, bridgeGame);
        System.out.println();
    }

    private static void printDependOn(String stair, BridgeGame bridgeGame) {
        StringBuilder sb = new StringBuilder(START_PREFIX);
        List<String> bridge = bridgeGame.getBridge();
        int maxStage = bridgeGame.getStageNumber();

        sb.append(getPrevious(bridge, maxStage, stair));
        sb.append(getNext(bridgeGame, stair));
        sb.append(END_REGEX);
        System.out.println(sb);
    }

    private static String getNext(BridgeGame bridgeGame, String stage) {
        Player player = bridgeGame.getPlayer();
        if (player.isAlive() && stage.equals(player.getLastSelection())) {
            return CORRECT;
        }
        if (!player.isAlive() && stage.equals(player.getLastSelection())) {
            return WRONG;
        }
        return BLANK;
    }

    private static String getPrevious(List<String> bridge, int maxStage, String upOrDown) {
        StringBuilder previous = new StringBuilder();
        for (int i = 0; i < maxStage; i++) {
            String previousStage = bridge.get(i);
            previous.append(getCorrectOrBlank(upOrDown, previousStage));
            previous.append(DELIMITER);
        }
        return previous.toString();
    }

    private static String getCorrectOrBlank(String upOrDown, String previousStage) {
        if (previousStage.equals(upOrDown)) {
            return CORRECT;
        }
        return BLANK;
    }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(GAME_RESULT_MESSAGE);
        printMap(bridgeGame);
        System.out.println(String.format(SUCCESS_OR_FAILURE, isSuccess(bridgeGame)));
        System.out.println(String.format(TRIAL_COUNT_MESSAGE, bridgeGame.getTrialCount()));
    }

    private static String isSuccess(BridgeGame bridgeGame) {
        if (bridgeGame.isPlayerAlive()) {
            return SUCCESS;
        }
        return FAILURE;
    }
}