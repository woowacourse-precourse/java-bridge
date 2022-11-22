package bridge.view;

import bridge.bridge.BridgePosition;
import bridge.bridgeGame.BridgeGame;
import bridge.bridgeGame.BridgeGameState;

public class OutputView {
    public static final String BRIDGE_MATCHED = "O";
    public static final String BRIDGE_UNMATCHED = "X";
    public static final String BRIDGE_EMPTY = " ";
    public void printMap(BridgeGameState bridgeGameState) {
        printLine(bridgeGameState, BridgePosition.BRIDGE_UP);
        printLine(bridgeGameState, BridgePosition.BRIDGE_DOWN);
        System.out.println();
    }

    private void printLine(BridgeGameState bridgeGameState, BridgePosition position) {
        System.out.print("[ ");
        for (int i = 0; i < bridgeGameState.currentSize(); ++i) {
            if (i != 0) {
                System.out.print(" | ");
            }
            System.out.print(getMatchString(bridgeGameState.getCurrentAt(i), bridgeGameState.getMatched(i), position));
        }
        System.out.println(" ]");
    }

    private String getMatchString(String currentAt, boolean matched, BridgePosition position) {
        if (!currentAt.equals(position.getPosition())) {
            return BRIDGE_EMPTY;
        }
        if (matched) {
            return BRIDGE_MATCHED;
        }
        return BRIDGE_UNMATCHED;
    }

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     * <p>
     * 출력을 위해 필요한 메서드의 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void printResult(BridgeGame bridgeGame) {
    }

    public void printInitGameMessage() {
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void printRequestBridgeMoving() {
        System.out.printf("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n",
                BridgePosition.BRIDGE_UP.getPosition(),
                BridgePosition.BRIDGE_DOWN.getPosition());
    }

    public void printRequestGameRetry() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시작: R, 종료: Q)");
    }
}
