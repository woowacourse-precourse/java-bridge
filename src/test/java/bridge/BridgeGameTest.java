package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeGameTest {

    @DisplayName("잘못된 다리 길이 입력에 대한 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"0", "2", "21", "15.", "2.5", " ", "십오", "four"})
    void 다리_길이_입력_예외_발생(String bridgeSize) {
        BridgeGame bridgeGame = new BridgeGame();

        assertThatThrownBy(() -> bridgeGame.generateBridge(bridgeSize))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
