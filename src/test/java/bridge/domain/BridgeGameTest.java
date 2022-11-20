package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    private List<String> bridge = List.of("U", "D");
    private BridgeState bridgeState = new BridgeState();
    private BridgeGame bridgeGame = new BridgeGame(bridge, bridgeState);

    @DisplayName("다리 방향 입력 값이 U(위 칸) 또는 D(아래 칸) 중 하나가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "Z"})
    void validateBridgeArrow(String arrow) {
        assertThatThrownBy(() -> bridgeGame.move(arrow))
                .isInstanceOf(IllegalArgumentException.class);
    }
}