package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


class BridgeGameTest {

    @DisplayName("플레이어 이동 테스트")
    @Test
    void createMovingTest() {
        List<String> bridge = List.of("U", "D", "D");
        String moving = "U";

        BridgeGame bridgeGame = new BridgeGame();
        MovingResult movingResult = bridgeGame.move(bridge, moving);

        assertThat(movingResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of("U", Result.SUCCESS));
    }

    @DisplayName("플레이어 이동 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "s", "u", "d"})
    void createMovingException(String moving) {
        List<String> bridge = List.of("U", "D", "D");
        BridgeGame bridgeGame = new BridgeGame();

        assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeGame.move(bridge, moving));
    }
}