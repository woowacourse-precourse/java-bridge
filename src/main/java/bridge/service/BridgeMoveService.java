package bridge.service;

import static bridge.constant.Commands.DOWN_COMMAND;
import static bridge.constant.Commands.UP_COMMAND;

import bridge.domain.BridgeMove;
import bridge.repository.BridgeMoveRepository;
import java.util.List;

public class BridgeMoveService {

    public static final String CAN_CROSS_BRIDGE = "O";
    public static final String CANNOT_CROSS_BRIDGE = "X";
    public static final String EMPTY_SPACE = " ";

    private final BridgeMoveRepository bridgeMoveRepository;
    private final List<String> bridge;

    public BridgeMoveService(BridgeMoveRepository bridgeMoveRepository, List<String> bridge) {
        this.bridgeMoveRepository = bridgeMoveRepository;
        this.bridge = bridge;
    }

    public void addBridgeMove(BridgeMove bridgeMove, boolean correct) {
        String move = bridgeMove.getMove();
        if (move.equals(UP_COMMAND)) {
            addUpperBridgeMove(correct);
            return;
        }
        addLowerBridgeMove(correct);
    }

    private void addUpperBridgeMove(boolean correct) {
        if (correct) {
            bridgeMoveRepository.add(CAN_CROSS_BRIDGE, EMPTY_SPACE);
            return;
        }
        bridgeMoveRepository.add(CANNOT_CROSS_BRIDGE, EMPTY_SPACE);
    }

    private void addLowerBridgeMove(boolean correct) {
        if (correct) {
            bridgeMoveRepository.add(EMPTY_SPACE, CAN_CROSS_BRIDGE);
            return;
        }
        bridgeMoveRepository.add(EMPTY_SPACE, CANNOT_CROSS_BRIDGE);
    }

    public boolean checkCorrect(int location, BridgeMove bridgeMove) {
        String move = bridgeMove.getMove();
        if (move.equals(bridge.get(location))) {
            return true;
        }
        return false;
    }

    public List<String>[] findBridgeMove() {
        return bridgeMoveRepository.findAll();
    }

    public void clearBridgeMove() {
        bridgeMoveRepository.clear();
    }
}
