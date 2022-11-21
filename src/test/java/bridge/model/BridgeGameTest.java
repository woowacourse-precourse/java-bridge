package bridge.model;

import bridge.BridgeNumberGenerator;
import org.junit.jupiter.api.BeforeEach;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void init_Test() {
        bridgeGame = new BridgeGame(3, new BridgeStaticNumberGenerator());
    }

    @ParameterizedTest(name = "{0}로 이동 -> {1}")
    @CsvSource(value = {"U,'[ O ]\n[   ]'", "D,'[   ]\n[ X ]'"})
    @DisplayName("입력된 방향으로 이동하면 결과를 가진 지도를 반환한다.")
    void move_RunMove_ReturnMessage(Direction direction, String message) {
        assertThat(bridgeGame.move(direction)).isEqualTo(message);
    }
    private class BridgeStaticNumberGenerator implements BridgeNumberGenerator {
        int count = 0;

        @Override
        public int generate() {
            if (count++ % 2 == 0) {
                return 1;
            }
            return 0;
        }
    }
}