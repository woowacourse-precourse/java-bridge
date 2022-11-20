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
        sb.append(getPrevious(bridgeGame, stair));
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

    private static String getPrevious(BridgeGame bridgeGame, String stage) {
        StringBuilder previous = new StringBuilder();

        int stageNumber = bridgeGame.getStageNumber();
        List<String> bridge = bridgeGame.getBridge();

        for (int i = 0; i < stageNumber; i++) {
            if (!stage.equals(bridge.get(i))) {
                previous.append(BLANK);
            } else {
                previous.append(CORRECT);
            }
            previous.append(DELIMITER);
        }
        return previous.toString();
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