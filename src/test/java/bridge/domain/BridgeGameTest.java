package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private final List<String> bridge = List.of("U", "D", "U");
    private final BridgeGameAnswer gameAnswer = new BridgeGameAnswer(bridge);
    private final BridgeGame bridgeGame = new BridgeGame(gameAnswer);

    @Test
    @DisplayName("[정상] 매 라운드와 방향을 입력, 정답일 경우 MovingResult.SUCCESS 반환한다.")
    void move_when_success() {
        MoveResult result = bridgeGame.move(Round.valueOf(1), Move.UP);

        assertThat(result).isEqualTo(MoveResult.SUCCESS);
    }

    @Test
    @DisplayName("[정상] 매 라운드와 방향을 입력, 오답일 경우 MovingResult.FAIL 반환한다.")
    void move_when_fail() {
        MoveResult result = bridgeGame.move(Round.valueOf(1), Move.DOWN);

        assertThat(result).isEqualTo(MoveResult.FAIL);
    }
}
