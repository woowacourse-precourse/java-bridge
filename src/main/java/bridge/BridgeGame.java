package bridge;

import static bridge.Messages.*;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */

public class BridgeGame {

    public static int retryCount = 1;
    public static boolean gameFlag = true;

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */

    public List<String> move(CompareBridge playerMove, List<String> upSideDownSideMove, String bridgeElement) {
        upSideDownSideMove.set(0, upSideDownSideMove.get(0)
                + playerMove.getUpSideMove(playerMove, bridgeElement).toString());
        upSideDownSideMove.set(1, upSideDownSideMove.get(1)
                + playerMove.getDownSideMove(playerMove, bridgeElement).toString());
        return upSideDownSideMove;
    }

    public boolean isFailure(List<String> upSideDownSideMove) {
        return upSideDownSideMove.stream()
                .anyMatch(move -> move.contains(INCORRECT));
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry(String gameCommand) {
        if (gameCommand.equals(RETRY)) {
            retryCount += 1;
            gameFlag = true;
        }
        if (gameCommand.equals(QUIT)) {
            gameFlag = false;
        }
    }
}
