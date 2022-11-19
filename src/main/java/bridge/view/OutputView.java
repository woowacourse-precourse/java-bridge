package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.Player;
import java.util.List;

public class OutputView {
    private static final String GAME_START_MESSAGE = "다리 건너기 게임을 시작합니다.";
    private static final String GAME_RESULT_MESSAGE = "최종 게임 결과";
    private static final String SUCCESS_OR_FAILURE = "게임 성공 여부: %s";
    private static final String TRIAL_COUNT_MESSAGE = "총 시도한 횟수: %d";
    private static final String UP_STAIR = "U";
    private static final String DOWN_STAIR = "D";

    public static void printStartMessage(){
        System.out.println(GAME_START_MESSAGE);
        System.out.println();
    }

    public static void printMap(BridgeGame bridgeGame) {
        printDependOn(UP_STAIR, bridgeGame);
        printDependOn(DOWN_STAIR, bridgeGame);
        System.out.println();
    }

    private static void printDependOn(String stair, BridgeGame bridgeGame) {
        StringBuilder sb = new StringBuilder("[");
        sb.append(getPrevious(bridgeGame, stair));
        sb.append(getNext(bridgeGame, stair));
        sb.append("]");
        System.out.println(sb);
    }

    private static String getNext(BridgeGame bridgeGame, String stage) {
        Player player = bridgeGame.getPlayer();
        if (player.isAlive() && stage.equals(player.getLastSelection())) {
            return " O ";
        }
        if (!player.isAlive() && stage.equals(player.getLastSelection())) {
            return " X ";
        }

        return "   ";
    }

    private static String getPrevious(BridgeGame bridgeGame, String stage) {
        StringBuilder previous = new StringBuilder();

        int stageNumber = bridgeGame.getStageNumber();
        List<String> bridge = bridgeGame.getBridge();

        for (int i = 0; i < stageNumber; i++) {
            if (!stage.equals(bridge.get(i))) {
                previous.append("   |");
            } else {
                previous.append(" O |");
            }
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
            return "성공";
        }
        return "실패";
    }
}