package bridge;

import bridge.domain.BridgeMove;
import bridge.service.BridgeMoveService;
import java.util.List;
import view.InputView;
import view.OutputView;

public class BridgeMoveController {

    private final int bridgeSize;
    private final BridgeMoveService bridgeMoveService;

    public BridgeMoveController(int bridgeSize, BridgeMoveService bridgeMoveService) {
        this.bridgeSize = bridgeSize;
        this.bridgeMoveService = bridgeMoveService;
    }

    public List<String>[] run() {
        for (int location = 0; location < bridgeSize; location++) {
            if (!makeBridgeMove(location)) {
                break;
            }
        }
        return bridgeMoveService.findBridgeMove();
    }

    public void clear() {
        bridgeMoveService.clearBridgeMove();
    }

    private boolean makeBridgeMove(int location) {
        BridgeMove move = readMoving();
        boolean correct = bridgeMoveService.checkCorrect(location, move);
        bridgeMoveService.addBridgeMove(move, correct);
        new OutputView().printMap(bridgeMoveService.findBridgeMove());
        if (correct) {
            return true;
        }
        return false;
    }

    private BridgeMove readMoving() {
        String move = new InputView().readMoving();
        return new BridgeMove(move);
    }
}
