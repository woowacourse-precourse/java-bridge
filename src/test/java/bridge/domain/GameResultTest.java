package bridge.domain;

import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;

public class GameResultTest {
    GameResult gameResult = new GameResult();

    @DisplayName("고른 칸 결과 리스트에 정답을 추가하고 고르지 않은 칸 리스트에 공백을 추가한다.")
    @Test
    void addUpSideGameResult() {
        gameResult.addGameResult(true, new PlayerMoving("U"));
        assertThat(gameResult.getUpSideResult()).containsExactly("O");
        assertThat(gameResult.getDownSideResult()).containsExactly(" ");
    }

    @DisplayName("고른 칸 결과 리스트에 오답을 추가하고 고르지 않은 칸 리스트에 공백을 추가한다.")
    @Test
    void addDownSideGameResult() {
        gameResult.addGameResult(false, new PlayerMoving("D"));
        assertThat(gameResult.getDownSideResult()).containsExactly("X");
        assertThat(gameResult.getUpSideResult()).containsExactly(" ");
    }
}