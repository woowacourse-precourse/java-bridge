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

    public void printResult(BridgeGame bridgeGame) {
        System.out.println("최종 게임 결과");
        printMap(bridgeGame.getBridgeGameState());
        System.out.println("게임 성공 여부: " + getSuccessString(bridgeGame.isWon()));
        System.out.println("총 시도한 횟수: " + bridgeGame.getTryCount());
    }

    private String getSuccessString(boolean isSuccess) {
        if (isSuccess) {
            return "성공";
        }
        return "실패";
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
