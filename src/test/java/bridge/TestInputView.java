package bridge;

import bridge.domain.bridge.BridgeMove;
import bridge.domain.game.BridgeGameCommand;
import bridge.view.InputView;
import java.util.List;

public class TestInputView extends InputView {
    private final int bridgeSize;
    private final List<BridgeMove> moves;
    private final List<BridgeGameCommand> commands;
    
    public TestInputView(int bridgeSize, List<BridgeMove> moves, List<BridgeGameCommand> commands) {
        this.bridgeSize = bridgeSize;
        this.moves = moves;
        this.commands = commands;
    }
    
    @Override
    public int readBridgeSize() {
        return bridgeSize;
    }
    
    @Override
    public BridgeMove readMoving() {
        return moves.remove(0);
    }
    
    @Override
    public BridgeGameCommand readGameCommand() {
        return commands.remove(0);
    }
}