package bridge.service;

import bridge.constant.ErrorCode;
import bridge.constant.MatchConst;
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

    public boolean retry(Player player) {
        if (player.isSuccess()) return false;
        String gameCommand = inputView.readGameCommand();
        if (Objects.equals(gameCommand, MatchConst.Button.RETRY_BOTTON)) {
            player.removeAllMatcher();
            return true;
        }
        if (Objects.equals(gameCommand, MatchConst.Button.END_BOTTON)) {
            return false;
        }
        throw new IllegalArgumentException(ErrorCode.WRONG_INPUT.getMessage());
    }
}
