package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("BridgeGame 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeGameTest {

    private final AnswerBridge bridge = new AnswerBridge(List.of("U", "D", "U"));
    private final BridgeGame bridgeGame = new BridgeGame(bridge);

    @Test
    void move는_라운드와_방향을_입력받아_정답인_경우_MoveResult_SUCCESS를_반환한다() {
        MoveResult result = bridgeGame.move(new Round(1), Direction.UP);

        assertThat(result).isEqualTo(MoveResult.SUCCESS);
    }

    @Test
    void move는_라운드와_방향을_입력받아_오답인_경우_MoveResult_FAIL을_반환한다() {
        MoveResult result = bridgeGame.move(new Round(1), Direction.DOWN);

        assertThat(result).isEqualTo(MoveResult.FAIL);
    }
}
