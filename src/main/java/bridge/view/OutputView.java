package bridge.view;

import bridge.model.BridgeGame;

import static bridge.view.ViewEnum.*;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public static void printGameStart() {
        System.out.println(OUTPUT_GAME_START_MESSAGE.getMessage());
    }

    public static void printMap(BridgeGame bridgeGame) {
        int bridgeSize = bridgeGame.getUpPresentBridge().size();

        System.out.print(PRINT_START_BRIDGE.getMessage());
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals(PRINT_U.getMessage())) {
                System.out.printf(PRINT_CONTINUE_HAVE_BRIDGE.getMessage(), bridgeGame.getUpPresentBridge().get(i));
            } else {
                System.out.print(PRINT_CONTINUE_BRIDGE.getMessage());
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals(PRINT_U.getMessage())) {
            System.out.printf(PRINT_END_HAVE_BRIDGE.getMessage(), bridgeGame.getUpPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf(PRINT_END_BRIDGE.getMessage());
        }

        System.out.print(PRINT_START_BRIDGE.getMessage());
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals(PRINT_D.getMessage())) {
                System.out.printf(PRINT_CONTINUE_HAVE_BRIDGE.getMessage(), bridgeGame.getDownPresentBridge().get(i));
            } else {
                System.out.print(PRINT_CONTINUE_BRIDGE.getMessage());
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals(PRINT_D.getMessage())) {
            System.out.printf(PRINT_END_HAVE_BRIDGE.getMessage(), bridgeGame.getDownPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf(PRINT_END_BRIDGE.getMessage());
        }

        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals(PRINT_D.getMessage())) {
            if (bridgeGame.getDownPresentBridge().get(bridgeSize - 1).equals(PRINT_X.getMessage())) {
                throw new IllegalArgumentException();
            }
        } else
            if (bridgeGame.getUpPresentBridge().get(bridgeSize - 1).equals(PRINT_X.getMessage())) {
                throw new IllegalArgumentException();
            }
        }

    public static void printResult(BridgeGame bridgeGame) {
        System.out.println(OUTPUT_GAME_RESULT_MAP_PRINT_MESSAGE.getMessage());

        int bridgeSize = bridgeGame.getUpPresentBridge().size();

        System.out.print(PRINT_START_BRIDGE.getMessage());
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals(PRINT_U.getMessage())) {
                System.out.printf(PRINT_CONTINUE_HAVE_BRIDGE.getMessage(), bridgeGame.getUpPresentBridge().get(i));
            } else {
                System.out.print(PRINT_CONTINUE_BRIDGE.getMessage());
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals(PRINT_U.getMessage())) {
            System.out.printf(PRINT_END_HAVE_BRIDGE.getMessage(), bridgeGame.getUpPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf(PRINT_END_BRIDGE.getMessage());
        }

        System.out.print(PRINT_START_BRIDGE.getMessage());
        for (int i = 0; i < bridgeSize - 1; i++) {
            if (bridgeGame.getUserMoveList().get(i).equals(PRINT_D.getMessage())) {
                System.out.printf(PRINT_CONTINUE_HAVE_BRIDGE.getMessage(), bridgeGame.getDownPresentBridge().get(i));
            } else {
                System.out.print(PRINT_CONTINUE_BRIDGE.getMessage());
            }
        }
        if (bridgeGame.getUserMoveList().get(bridgeSize - 1).equals(PRINT_D.getMessage())) {
            System.out.printf(PRINT_END_HAVE_BRIDGE.getMessage(), bridgeGame.getDownPresentBridge().get(bridgeSize - 1));
        } else {
            System.out.printf(PRINT_END_BRIDGE.getMessage());
        }

        System.out.printf(OUTPUT_GAME_RESULT_MESSAGE.getMessage(),bridgeGame.getGameSuccess());
        System.out.printf(OUTPUT_TOTAL_GAME_COUNT_MESSAGE.getMessage(),bridgeGame.getGameCount());
    }
}
