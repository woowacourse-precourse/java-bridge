package bridge.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    BridgeGame game;

    @BeforeEach
    void before() {
        game = new BridgeGame(List.of("U"));
    }

    @DisplayName("사용자의 입력값이 정답일 경우 움직일 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void move(String input, boolean expected) {
        GameResult gameResult = game.move(0, input);
        assertThat(gameResult.getGameResult()).containsExactly(expected);
    }

    @DisplayName("게임을 재시작할 때 시도 횟수가 증가한다.")
    @Test
    void retry() {
        game.retry();
        assertThat(game.getTryNumber()).isEqualTo(2);
    }
}
