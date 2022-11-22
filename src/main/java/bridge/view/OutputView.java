package bridge.view;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {
    private static final String UP_BRIDGE = "U";
    private static final String DOWN_BRIDGE = "D";
    private static final String BRIDGE_PASS = " O ";
    private static final String BRIDGE_BLOCK = " X ";
    private static final String BRIDGE_NONE = "   ";
    private static final String BRIDGE_SEPARATOR = "|";
    private static final String PRINT_RESULT = "최종 게임 결과";
    private static final String PRINT_SUCCESS = "게임 성공 여부: %s\n";
    private static final String PRINT_TRY_COUNT = "총 시도한 횟수: %d\n";

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printMap(List<String> answerBridge, List<String> playerBridge) {
        StringBuilder upBridge = new StringBuilder();
        StringBuilder downBridge = new StringBuilder();
        for (int i = 0; i < playerBridge.size(); i++) {
            addUpBridgePart(playerBridge.get(i),answerBridge.get(i), upBridge);
            addDownBridgePart(playerBridge.get(i),answerBridge.get(i), downBridge);
            addSeparator(upBridge, downBridge);
        }
        printPartSuccess(upBridge, downBridge);
    }

    private void addUpBridgePart(String playerBridgePart, String answerBridgePart, StringBuilder upBridge) {
        addUpBridgePartSuccess(playerBridgePart, answerBridgePart, upBridge);
        addUpBridgePartFail(playerBridgePart, answerBridgePart, upBridge);
    }

    private void addDownBridgePart(String playerBridgePart, String answerBridgePart, StringBuilder downBridge) {
        addDownBridgePartSuccess(playerBridgePart, answerBridgePart, downBridge);
        addDownBridgePartFail(playerBridgePart, answerBridgePart, downBridge);
    }

    private void addUpBridgePartSuccess(String playerBridgePart, String answerBridgePart, StringBuilder upBridge) {
        if (playerBridgePart.equals(answerBridgePart)) {
            if (playerBridgePart.equals(UP_BRIDGE)){
                upBridge.append(BRIDGE_PASS);
            }
            if (playerBridgePart.equals(DOWN_BRIDGE)){
                upBridge.append(BRIDGE_NONE);
            }
        }
    }

    private void addDownBridgePartSuccess(String playerBridgePart, String answerBridgePart, StringBuilder downBridge) {
        if (playerBridgePart.equals(answerBridgePart)) {
            if (playerBridgePart.equals(UP_BRIDGE)){
                downBridge.append(BRIDGE_NONE);
            }
            if (playerBridgePart.equals(DOWN_BRIDGE)){
                downBridge.append(BRIDGE_PASS);
            }
        }
    }

    private void addUpBridgePartFail(String playerBridgePart, String answerBridgePart, StringBuilder upBridge) {
        if (!playerBridgePart.equals(answerBridgePart)) {
            if (playerBridgePart.equals(UP_BRIDGE)){
                upBridge.append(BRIDGE_BLOCK);
            }
            if (playerBridgePart.equals(DOWN_BRIDGE)){
                upBridge.append(BRIDGE_NONE);
            }
        }
    }

    private void addDownBridgePartFail(String playerBridgePart, String answerBridgePart, StringBuilder downBridge) {
        if (!playerBridgePart.equals(answerBridgePart)) {
            if (playerBridgePart.equals(UP_BRIDGE)){
                downBridge.append(BRIDGE_NONE);
            }
            if (playerBridgePart.equals(DOWN_BRIDGE)){
                downBridge.append(BRIDGE_BLOCK);
            }
        }
    }

    private void addSeparator(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.append(BRIDGE_SEPARATOR);
        downBridge.append(BRIDGE_SEPARATOR);
    }

    private void printPartSuccess(StringBuilder upBridge, StringBuilder downBridge) {
        upBridge.setLength(upBridge.length() - 1);
        downBridge.setLength(downBridge.length() - 1);
        System.out.printf("[%s]\n", upBridge);
        System.out.printf("[%s]\n", downBridge);
        System.out.println();
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(Bridge playerBridge, Bridge answerBridge, GameResult gameResult) {
        System.out.println(PRINT_RESULT);
        printMap(answerBridge.getBridge(), playerBridge.getBridge());

        printSuccess(gameResult);

        System.out.printf(PRINT_TRY_COUNT, gameResult.getTryCount());
    }

    private void printSuccess(GameResult gameResult) {
        if (gameResult.getSuccess()) {
            System.out.printf(PRINT_SUCCESS, "성공");
        }
        if (!gameResult.getSuccess()) {
            System.out.printf(PRINT_SUCCESS, "실패");
        }
    }
}
