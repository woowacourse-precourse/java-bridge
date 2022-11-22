package bridge;

import bridge.domain.GameResult;
import bridge.domain.PlayerMoving;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    GameResult gameResult = new GameResult();

    @DisplayName("고른 칸 결과 리스트에 정답(2)을 추가하고 고르지 않은 칸 리스트에 공백(0)을 추가한다.")
    @Test
    void addUpSideGameResult() {
        gameResult.addGameResult(true, new PlayerMoving("U"));
        assertThat(gameResult.getUpSideResult()).contains(2);
        assertThat(gameResult.getDownSideResult()).contains(0);
    }

    @DisplayName("고른 칸 결과 리스트에 오답(1)을 추가하고 고르지 않은 칸 리스트에 공백(0)을 추가한다.")
    @Test
    void addDownSideGameResult() {
        gameResult.addGameResult(false, new PlayerMoving("D"));
        assertThat(gameResult.getDownSideResult()).contains(1);
        assertThat(gameResult.getUpSideResult()).contains(0);
    }
}