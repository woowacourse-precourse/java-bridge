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
        bridgeGame = new BridgeGame(bridge.size());
    }

    @DisplayName("플레이어 이동 테스트")
    @Test
    void createMovingTest() {
        String moving = "U";

        MovingResult firstResult = bridgeGame.move(bridge, moving);
        MovingResult secondResult = bridgeGame.move(bridge, moving);

        assertThat(firstResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of("U", Result.SUCCESS));

        assertThat(secondResult)
                .usingRecursiveComparison()
                .isEqualTo(MovingResult.of("U", Result.FAIL));
    }

    @DisplayName("플레이어 이동 예외 처리 테스트")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "s", "u", "d"})
    void createMovingException(String moving) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> bridgeGame.move(bridge, moving));
    }

    @DisplayName("게임 결과 확인 테스트 - 진행 중")
    @Test
    void createInProgressTest() {
        MovingResult movingResult = bridgeGame.move(bridge, "U");

        assertThat(bridgeGame.getGameResult(movingResult)).isEqualTo(Result.IN_PROGRESS);
    }

    @DisplayName("게임 결과 확인 테스트 - 실패")
    @Test
    void createFailTest() {
        bridgeGame.move(bridge, "U");

        MovingResult movingResult = bridgeGame.move(bridge, "U");

        assertThat(bridgeGame.getGameResult(movingResult)).isEqualTo(Result.FAIL);
    }

    @DisplayName("게임 결과 확인 테스트 - 성공")
    @Test
    void createSuccessTest() {
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "D");

        MovingResult movingResult = bridgeGame.move(bridge, "D");

        assertThat(bridgeGame.getGameResult(movingResult)).isEqualTo(Result.SUCCESS);
    }
}