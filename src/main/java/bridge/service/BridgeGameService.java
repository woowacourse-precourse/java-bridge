package bridge.service;

import bridge.common.ErrorMessage;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeGameAnswer;
import bridge.domain.BridgeMaker;
import bridge.domain.Move;
import bridge.domain.Player;
import bridge.dto.MoveResultDto;
import java.util.List;

public class BridgeGameService {
    private final BridgeMaker bridgeMaker;
    private BridgeGame bridgeGame;

    public BridgeGameService(BridgeMaker bridgeMaker) {
        this.bridgeMaker = bridgeMaker;
    }

    /**
     * size 를 통해 인스턴스 변수 BridgeGame 초기화
     *
     * @param size
     */
    public void initBridgeGame(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);
        this.bridgeGame = new BridgeGame(gameAnswer);
    }

    /**
     * 이동할 때 사용하는 메서드
     *
     * @param player
     * @param command
     * @return MoveResultDto
     */
    public MoveResultDto play(Player player, String command) {
        if (!isPlaying()) {
            throw new IllegalArgumentException(ErrorMessage.isInvalidGameStatus());
        }
        player.move(bridgeGame, Move.of(command));
        return MoveResultDto.from(player.getBridgeGameResult());
    }

    public boolean isPlaying() {
        return bridgeGame.isPlayStatus();
    }
}
