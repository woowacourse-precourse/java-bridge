package bridge.view;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameRoundResult;
import bridge.domain.BridgeGameTrialResult;
import bridge.domain.BridgeMove;
import java.util.ArrayList;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static void printStartMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(BridgeGameTrialResult trialResult) {
        String upper = buildString(BridgeMove.UP, trialResult);
        String lower = buildString(BridgeMove.DOWN, trialResult);
        System.out.println(upper);
        System.out.println(lower);
        System.out.println();
    }

    public static String buildString(BridgeMove side, BridgeGameTrialResult trialResult) {
        StringBuilder builder = new StringBuilder();
        builder.append("[ ");
        List<String> results = new ArrayList<>();
        for (int round = 1; round <= trialResult.getTotalRound(); round++) {
            results.add(getRoundResultString(side, trialResult.getRoundResult(round)));
        }
        builder.append(String.join(" | ", results));
        builder.append(" ]");
        return builder.toString();
    }

    private static String getRoundResultString(BridgeMove side, BridgeGameRoundResult roundResult) {
        if (roundResult.getMove() != side) {
            return " ";
        }

        if (roundResult.passed()) {
            return "O";
        }

        return "X";
    }

    public static void printResult(BridgeGame bridgeGame) {
        BridgeGameTrialResult finalTrial = bridgeGame.getResult().getCurrentTrialResult();
        boolean finalResult = bridgeGame.getResult().getCurrentTrialResult().didCrossedBridge(bridgeGame.getLength());
        System.out.println("최종 게임 결과");
        printMap(finalTrial);
        System.out.println("게임 성공 여부: " + convertBooleanToString(finalResult));
        System.out.println("총 시도한 횟수: " + bridgeGame.getResult().getTotalTrial());
    }

    private static String convertBooleanToString(boolean target) {
        if (target) {
            return "성공";
        }
        return "실패";
    }

    public static void printErrorMessage(Exception exception) {
        System.out.println("[ERROR] " + exception.getMessage());
    }
}
