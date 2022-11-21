package bridge.domain;

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

    public Bridge makeBridge(BridgeSize size) {
        List<BridgeMove> moves = new ArrayList<>();
        for (int count = 1; count <= size.getSize(); count++) {
            moves.add(BridgeMove.getBridgeMoveByMoveCode(bridgeNumberGenerator.generate()));
        }
        return BridgeFactory.from(size, moves);
    }
}
