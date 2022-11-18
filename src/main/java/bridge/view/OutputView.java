package bridge.view;

import bridge.utils.constants.BridgeConstants;
import bridge.utils.constants.GameConstants;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    private static StringBuilder upBridgeBuilder;
    private static StringBuilder downBridgeBuilder;

    public static void printStart() {
        System.out.println(GameConstants.START_GAME);
    }

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printMap(List<String> bridge, List<String> userAnswer) {
        upBridgeBuilder = new StringBuilder();
        downBridgeBuilder = new StringBuilder();

        appendPoint(BridgeConstants.BRIDGE_START_POINT);

        for (int i = 0; i < userAnswer.size(); i++) {
            if (i > 0 && i < bridge.size()) {
                appendPoint(BridgeConstants.BRIDGE_DIVIDING_POINT);
            }
            String answer = bridge.get(i);
            String step = userAnswer.get(i);
            if (step.equals(answer)) {
                appendResult(step, BridgeConstants.CORRECT_ANSWER);
            }
            if (!step.equals(answer)) {
                appendResult(step, BridgeConstants.INCORRECT_ANSWER);
            }
        }

        appendPoint(BridgeConstants.BRIDGE_END_POINT);

        System.out.println(upBridgeBuilder);
        System.out.println(downBridgeBuilder);
    }

    private static void appendResult(String step, String correctAnswer) {
        if (step.equals(BridgeConstants.UP_CROSS)) {
            upBridgeBuilder.append(correctAnswer);
            downBridgeBuilder.append(BridgeConstants.SPACE);
        }
        if (step.equals(BridgeConstants.DOWN_CROSS)) {
            upBridgeBuilder.append(BridgeConstants.SPACE);
            downBridgeBuilder.append(correctAnswer);
        }
    }

    private static void appendPoint(String bridgeStartPoint) {
        upBridgeBuilder.append(bridgeStartPoint);
        downBridgeBuilder.append(bridgeStartPoint);
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public static void printResult(boolean gameResult, int gameCount) {
        System.out.println(GameConstants.GAME_RESULT);
        System.out.println(upBridgeBuilder);
        System.out.println(downBridgeBuilder);

        if (gameResult) {
            System.out.println(GameConstants.SUCCESS_GAME);
        }
        if (!gameResult) {
            System.out.println(GameConstants.FAIL_GAME);
        }
        System.out.printf(GameConstants.GAME_TRY_COUNT, gameCount);
    }
}
