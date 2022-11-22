package bridge;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    private void failMove(String moveCommand, List<String> upBridgeResult, List<String> downBridgeResult) {

        if (moveCommand.equals("U")) {
            upBridgeResult.add("X");
            downBridgeResult.add(" ");
        } else if (moveCommand.equals("D")) {
            upBridgeResult.add(" ");
            downBridgeResult.add("X");
        }
    }

    private void successMove(String moveCommand, List<String> upBridgeResult, List<String> downBridgeResult) {

        if (moveCommand.equals("U")) {
            upBridgeResult.add("O");
            downBridgeResult.add(" ");
        } else if (moveCommand.equals("D")) {
            upBridgeResult.add(" ");
            downBridgeResult.add("O");
        }
    }

    public boolean isPossibleMove(List<String> bridge, String moveCommand, int turn) {

        String bridgeInformation = bridge.get(turn);

        if (bridgeInformation.equals(moveCommand)) {
            return true;
        }

        return false;
    }
    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }
}
