package bridge;

import bridge.domain.game.BridgeGameCommand;
import java.util.List;

public class TestInputView extends InputView {
    private final List<BridgeMove> moves;
    private final List<BridgeGameCommand> commands;
    
    public TestInputView(List<BridgeMove> moves, List<BridgeGameCommand> commands) {
        this.moves = moves;
        this.commands = commands;
    }
    
    @Override
    public int readBridgeSize() {
        return moves.size();
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