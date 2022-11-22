package bridge.model;

import bridge.view.InputView;
import java.util.List;

public class JudgeCommand {
    private BridgeGame bridgeGame;

    public JudgeCommand(GameStatus gameStatus, BridgeMaker bridgeMaker, PresentBridgeMaker presentBridgeMaker) {
        bridgeGame = new BridgeGame(gameStatus, bridgeMaker, presentBridgeMaker);
    }

    public boolean judgeMove(List<String> bridge, String moveCommand, int bridgeIndex) {
        if (bridge.get(bridgeIndex).equals(moveCommand)) {
            return true;
        }
        return false;
    }

    public boolean judgeContinue() {
        String gameCommand = InputView.readGameCommand();

        if (gameCommand.equals("R")) {
            bridgeGame.retry();
            return true;
        }
        return false;
    }
}
