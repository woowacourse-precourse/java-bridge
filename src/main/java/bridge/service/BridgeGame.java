package bridge.service;

import bridge.domain.Bridge;
import bridge.domain.Player;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.Objects;

public class BridgeGame {
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGame(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public boolean move(Bridge bridge, Player player) {
        String input = inputView.readMoving();
        boolean isTrue = Objects.equals(input, bridge.getBridgeSpace().get(player.getPlayerLocation()));
        player.addBridgeShapeMatcher(input, isTrue);
        return isTrue;
    }

    public void retry() {
    }
}
