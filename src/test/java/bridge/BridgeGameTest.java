package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeGameTest {

    List<String> bridge;
    BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridge = List.of("U", "D", "D");
        bridgeGame = new BridgeGame();
    }

    @DisplayName("플레이어 이동 테스트")
    @Test
    void createMovingTest() {
        String moving = "U";

        MovingResult movingResult = bridgeGame.move(bridge, moving);

        assertThat(movingResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of("U", Result.SUCCESS));
    }

    @DisplayName("플레이어 이동 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "s", "u", "d"})
    void createMovingException(String moving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeGame.move(bridge, moving));
    }
}