package bridge.service;

import bridge.BridgeMaker;
import bridge.domain.AnswerBridge;
import bridge.domain.BridgeGame;
import bridge.domain.Direction;
import bridge.domain.MoveResult;
import bridge.domain.Player;
import java.util.List;
import java.util.Objects;

public class BridgeGameService {

    private static final String INVALID_GAME_STATE_MESSAGE = "게임을 진행할 수 없습니다.";

    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    public void initializeBridgeGame(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        AnswerBridge answerBridge = new AnswerBridge(bridge);
        this.bridgeGame = new BridgeGame(answerBridge);
    }

    public List<List<MoveResult>> play(Player player, String move) {
        validate();
        Direction direction = Direction.toEnum(move);
        player.move(bridgeGame, direction);
        return player.getBridgeGameResult();
    }

    private void validate() {
        if (!isPlayable()) {
            throw new IllegalStateException(INVALID_GAME_STATE_MESSAGE);
        }
    }

    public boolean isPlayable() {
        if (Objects.isNull(bridgeGame)) {
            return false;
        }
        return bridgeGame.isPlayable();
    }
}
