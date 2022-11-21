package bridge.service;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.bridge.Bridge;
import bridge.domain.bridge.BridgeSize;
import bridge.domain.bridge.Square;
import bridge.domain.game.SquareResult;
import bridge.domain.move.MoveResult;

import java.util.List;

public class BridgeService {

    private Bridge bridge;

    public void createBridge(int size) {
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);

        BridgeSize bridgeSize = new BridgeSize(size);
        List<String> tempBridge = bridgeMaker.makeBridge(bridgeSize.get());

        bridge = Bridge.valueOf(tempBridge);
    }

    public SquareResult getOneSpaceMoveResult(String move, int position) {
        Square userMove = Square.of(move);
        boolean moveResult = bridge.canMoveForward(userMove, position);

        return new SquareResult(userMove, MoveResult.of(moveResult));
    }
}
