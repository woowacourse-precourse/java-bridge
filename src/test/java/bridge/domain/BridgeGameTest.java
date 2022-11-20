package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertAll;
import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        this.bridgeGame = new BridgeGame(new Bridge(List.of(BridgeShape.UP, BridgeShape.DOWN, BridgeShape.UP)));
    }

    @DisplayName("플레이어 이동 테스트")
    @Nested
    class Move {
        @ParameterizedTest(name = "이동할 때 위 칸은 대문자 U, 아래 칸은 대문자 D가 아닌 경우 예외 처리한다.")
        @NullAndEmptySource
        @ValueSource(strings = {" ", "u", "d", "UP", "DOWN", "abc", "cde"})
        void moveInvalidValue(String shapeName) {
            assertThatThrownBy(() -> bridgeGame.move(shapeName)).isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("이동할 때 위 칸은 대문자 U를 아래 칸은 대문자 D를 입력한다")
        @Test
        void move() {
            assertAll(
                    () -> assertDoesNotThrow(() -> bridgeGame.move("U")),
                    () -> assertDoesNotThrow(() -> bridgeGame.move("D"))
            );
        }
    }

    @DisplayName("이동 결과를 반환한다.")
    @Test
    void result() {
        Bridge bridge = Bridge.createByBridgeShapeValue(List.of("U", "D", "U", "D"));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");

        assertThat(bridgeGame.result()).isEqualTo(new BridgeGameResult(bridge, List.of(true, true, true, false)));
    }
}
