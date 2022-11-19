package bridge;

import java.util.ArrayList;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 * 요구 사항 분석 :
 * BridgeGame 클래스에서 InputView, OutputView 를 사용하지 않는다.
 * <p>
 * 제공된 BridgeGame 클래스를 활용해 구현해야 한다.
 * BridgeGame에 필드(인스턴스 변수)를 추가할 수 있다.
 * BridgeGame의 패키지는 변경할 수 있다.
 * BridgeGame의 메서드의 이름은 변경할 수 없고, 인자와 반환 타입은 필요에 따라 추가하거나 변경할 수 있다.
 * 게임 진행을 위해 필요한 메서드를 추가 하거나 변경할 수 있다.
 */
public class BridgeGame {
    List<MovePath> bridge;

    public BridgeGame(List<String> bridge) {
        this.bridge = makeEnumBridge(bridge);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 메서드 이름은 변경할 수 없다.
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public MoveResult move(MovePath movePath, int playerPosition) {
        MoveResult moveResult = judgeMoveResult(movePath, playerPosition);
        return moveResult;
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 메서드 이름은 변경할 수 없다.
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public void retry() {
    }

    private MoveResult judgeMoveResult(MovePath movePath, int playerPosition) {
        if (bridge.get(playerPosition) == movePath) {
            if (hasPassedBridge(playerPosition)) {
                return MoveResult.PASS_BRIDGE;
            }
            playerPosition++;
            return MoveResult.O;
        }
        playerPosition++;
        return MoveResult.X;
    }

    private boolean hasPassedBridge(int playerPosition) {
        return bridge.size() == playerPosition + 1;
    }

    private List<MovePath> makeEnumBridge(List<String> bridge) {
        List<MovePath> enumBridge = new ArrayList<>();
        copyToEnumBridge(bridge, enumBridge);
        return enumBridge;
    }

    private void copyToEnumBridge(List<String> bridge, List<MovePath> enumBridge) {
        for (String path : bridge) {
            if (path.equals("D")) {
                enumBridge.add(MovePath.D);
                continue;
            }
            enumBridge.add((MovePath.U));
        }
    }
}
