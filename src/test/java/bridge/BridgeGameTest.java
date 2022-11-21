package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.User;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


public class BridgeGameTest {
    BridgeGame game;

    @BeforeEach
    void generateGame() {
        List<String> answerBridge = List.of("U", "D", "U");
        User user = new User();
        game = new BridgeGame(answerBridge, user);
    }

    @DisplayName("moveInput 예외처리 테스트")
    @ParameterizedTest(name = "input = {0}")
    @ValueSource(strings = {"a", "1", ",", "u", "d"})
    void checkMoveInputException(String input) {
        assertThatThrownBy(() -> game.move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("move test")
    @ParameterizedTest(name = "input = {0}")
    @CsvSource({"U, true", "D, false"})
    void checkMoveTest(String input, boolean expect) {
        assertThat(game.move(input)).isEqualTo(expect);
    }
}
