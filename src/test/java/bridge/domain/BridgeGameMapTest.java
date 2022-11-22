package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeGameMapTest {

    @ParameterizedTest
    @CsvSource({"U, U, O", "U, D, ' '", "D, U, X"})
    @DisplayName("윗다리를 올바르게 업데이트 할 수 있다.")
    void canUpdateUpSideCorrectly(String bridgeStatus, String playerMoving, String answer) {
        BridgeGameMap bridgeGameMap = new BridgeGameMap();
        bridgeGameMap.updateMap(bridgeStatus, playerMoving);
        assertThat(bridgeGameMap.getUpSide()).isEqualTo(List.of(answer));
    }

    @ParameterizedTest
    @CsvSource({"U, U, ' '", "D, D, O", "U, D, X"})
    @DisplayName("아랫다리를 올바르게 업데이트 할 수 있다.")
    void canUpdateDownSideCorrectly(String bridgeStatus, String playerMoving, String answer) {
        BridgeGameMap bridgeGameMap = new BridgeGameMap();
        bridgeGameMap.updateMap(bridgeStatus, playerMoving);
        assertThat(bridgeGameMap.getDownSide()).isEqualTo(List.of(answer));
    }

    @Test
    @DisplayName("올바른 맵을 만들 수 있다.")
    void canCreateCorrectMap() {
        BridgeGameMap bridgeGameMap = new BridgeGameMap();
        bridgeGameMap.updateMap("U", "U");
        bridgeGameMap.updateMap("U", "U");
        bridgeGameMap.updateMap("D", "U");

        assertThat(bridgeGameMap.getUpSide()).isEqualTo(List.of("O", "O", "X"));
        assertThat(bridgeGameMap.getDownSide()).isEqualTo(List.of(" ", " ", " "));
    }

    @Test
    @DisplayName("맵을 비울 수 있다.")
    void canClearMap() {
        BridgeGameMap bridgeGameMap = new BridgeGameMap();
        bridgeGameMap.updateMap("U", "U");
        bridgeGameMap.reset();

        assertThat(bridgeGameMap.getUpSide().isEmpty()).isEqualTo(true);
        assertThat(bridgeGameMap.getDownSide().isEmpty()).isEqualTo(true);
    }
}