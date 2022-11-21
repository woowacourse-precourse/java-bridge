package bridge;

import bridge.domain.Bridge;
import bridge.domain.GameResult;
import bridge.utils.constants.Comments;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameResultTest {

    GameResult gameResult = new GameResult();
    Bridge bridge = new Bridge(List.of("U", "U", "D"));

    void addResult(Comments comments) {
        gameResult.addResult(bridge, comments);
    }

    @BeforeEach
    void resetResult() {
        gameResult.resetResult();
    }

    @Test
    void 게임_성공_true() {
        addResult(Comments.UP);
        addResult(Comments.UP);
        addResult(Comments.DOWN);

        Assertions.assertThat(gameResult.isGameSuccess(bridge.getBridgeSize())).isTrue();
    }

    @Test
    void 게임_성공_false() {
        addResult(Comments.UP);
        addResult(Comments.UP);
        addResult(Comments.UP);

        Assertions.assertThat(gameResult.isGameSuccess(bridge.getBridgeSize())).isFalse();
    }

    @Test
    void 게임_성공_false_이전에종료() {
        addResult(Comments.UP);
        addResult(Comments.UP);

        Assertions.assertThat(gameResult.isGameSuccess(bridge.getBridgeSize())).isFalse();
    }

    @Test
    void 게임_실패_true() {
        addResult(Comments.UP);
        addResult(Comments.UP);
        addResult(Comments.UP);

        Assertions.assertThat(gameResult.isGameFail()).isTrue();
    }

    @Test
    void 게임_실패_false() {
        addResult(Comments.UP);
        addResult(Comments.UP);
        addResult(Comments.DOWN);

        Assertions.assertThat(gameResult.isGameFail()).isFalse();
    }

    @Test
    void addResult_O() {
        gameResult.addResult(bridge, Comments.UP);
        Assertions.assertThat(gameResult.getResult().get(0)).isEqualTo(List.of("O"));
    }

    @Test
    void addResult_X() {
        gameResult.addResult(bridge, Comments.DOWN);
        Assertions.assertThat(gameResult.getResult().get(1)).isEqualTo(List.of("X"));
    }

    @Test
    void addResult_BLANK() {
        gameResult.addResult(bridge, Comments.DOWN);
        Assertions.assertThat(gameResult.getResult().get(0)).isEqualTo(List.of(" "));
    }

}