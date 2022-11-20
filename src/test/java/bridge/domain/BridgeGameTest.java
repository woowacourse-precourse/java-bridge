package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {

    private List<String> bridge = List.of("U", "D");
    private BridgeGame bridgeGame;
    private BridgeState bridgeState;

    @BeforeEach
    void init() {
        bridgeState = new BridgeState();
        bridgeGame = new BridgeGame(bridge, bridgeState);
    }

    @DisplayName("다리 방향 입력 값이 U(위 칸) 또는 D(아래 칸) 중 하나가 아닌 경우 예외가 발생한다.")
    @ParameterizedTest
    @ValueSource(strings = {"A", "Z"})
    void validateBridgeArrow(String arrow) {
        assertThatThrownBy(() -> bridgeGame.move(arrow))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("첫 라운드 다리 건너고 나서 위 다리 상태 값 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "U, O",
            "D, ' '"
    })
    void confirmFirstRoundUpBridgeState(String arrow, String up) {
        bridgeGame.move(arrow);
        assertThat(bridgeState.getUpBridgeState()).isEqualTo(up);
    }

    @DisplayName("첫 라운드 다리 건너고 나서 아래 다리 상태 값 확인")
    @ParameterizedTest
    @CsvSource(value = {
            "U, ' '",
            "D, 'X'"
    })
    void confirmFirstRoundDownBridgeState(String arrow, String down) {
        bridgeGame.move(arrow);
        assertThat(bridgeState.getDownBridgeState()).isEqualTo(down);
    }
}