package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import bridge.constant.Direction;

class BridgeGameStatusTest {
    private BridgeGameStatus bridgeGameStatus;

    @DisplayName("다리 문자열 변환 테스트")
    @Test
    void getBridgeString_테스트() {
        bridgeGameStatus = new BridgeGameStatus(List.of("U","U","U"));
        this.bridgeGameStatus.move(Direction.UP);
        this.bridgeGameStatus.move(Direction.UP);
        this.bridgeGameStatus.move(Direction.DOWN);
        assertThat(bridgeGameStatus.getUpBridgeString()).isEqualTo("[ O | O |   ]");
        assertThat(bridgeGameStatus.getDownBridgeString()).isEqualTo("[   |   | X ]");
    }
}