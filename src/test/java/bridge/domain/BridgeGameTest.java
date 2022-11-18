package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        int size = 5;
        bridgeGame = new BridgeGame(size);
    }

    @DisplayName("움직임 명령 성공케이스 테스트")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void move_ValidMoveCommand_Boolean(String input) {
        assertThat(bridgeGame.move(input))
                .isIn(true, false);
    }

    @DisplayName("움직임 명령 예외케이스 테스트")
    @ValueSource(strings = {"1", "A", "b", "u", "d", "R", "Q"})
    @ParameterizedTest
    void move_InvalidMoveCommand_ExceptionThrown(String input) {
        assertThatThrownBy(() -> bridgeGame.move(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}