package bridge;

import bridge.domain.BridgeMove;
import java.util.ArrayList;
import java.util.List;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        if (bridgeNumberGenerator == null) {
            throw new NullPointerException("BridgeNumberGenerator는 Null이 될 수 없습니다.t ");
        }
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    public List<String> makeBridge(int size) {
        List<String> moves = new ArrayList<>();
        for (int count = 1; count <= size; count++) {
            int number = bridgeNumberGenerator.generate();
            String move = BridgeMove.getBridgeMoveByMoveCode(number).getMoveCommand();
            moves.add(move);
        }
        return moves;
    }
}
