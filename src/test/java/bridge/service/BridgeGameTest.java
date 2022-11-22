package bridge.service;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.Bridge;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    @Test
    @DisplayName("다리게임 생성 시 예외")
    void makeBridgeGame() {
        assertThatThrownBy(() -> new BridgeGame(null))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("진행되지 않은 다리 게임 public 메소드 호출 시 예외")
    void checkResult() {
        BridgeGame game = new BridgeGame();

        assertThatThrownBy(game::recentResult)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::end)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::movable)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::checkCross)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::printPlayCount)
                .isInstanceOf(IllegalStateException.class);
        assertThatThrownBy(game::state)
                .isInstanceOf(IllegalStateException.class);
    }

    @ParameterizedTest
    @DisplayName("게임 커맨드 U, D 아닐 시에 예외")
    @CsvSource(value = {
            "A,0",
            "B,1",
            "C,2"
    })
    void checkUpDown(String input, int defaultCount) {
        BridgeGame game = new BridgeGame(new Bridge(List.of("U", "D", "D")));

        assertThatThrownBy(() -> game.move(input, defaultCount))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] U 또는 D를 입력해주세요");
    }

    @ParameterizedTest
    @DisplayName("게임 종료 커맨드 R, Q 아닐 시에 예외")
    @CsvSource(value = {
            "A",
            "B",
            "C"
    })
    void checkUpDown(String input) {
        BridgeGame game = new BridgeGame(new Bridge(List.of("U", "D", "D")));

        assertThatThrownBy(() -> game.retry(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] Q 또는 R을 입력해주세요");
    }
}
