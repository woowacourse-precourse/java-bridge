package bridge.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameTest {

    @DisplayName("사용자의 입력값이 정답일 경우 움직일 수 있다.")
    @ParameterizedTest
    @CsvSource(value = {"U,true", "D,false"})
    void move(String input, boolean expected) {
        BridgeGame game = new BridgeGame(List.of("U"));
        GameResult gameResult = game.move(0, input);

        assertThat(gameResult.getGameResult()).containsExactly(expected);
    }
}
