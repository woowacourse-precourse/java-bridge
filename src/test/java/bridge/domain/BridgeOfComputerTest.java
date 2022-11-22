package bridge.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeOfComputerTest {

    private BridgeOfComputer bridgeOfComputer;

    @BeforeEach
    void beforeEach() {
        bridgeOfComputer = new BridgeOfComputer(List.of("U", "D", "U"));
    }

    @DisplayName("컴퓨터에 저장된 맵에 대해 맞는지 반환합니다. - 성공")
    @Test
    void 성공() {
        boolean result = bridgeOfComputer.match(0, "U");
        assertThat(result).isTrue();
    }

    @DisplayName("컴퓨터에 저장된 맵에 대해 맞는지 반환합니다. - 실패")
    @Test
    void 실패() {
        boolean result = bridgeOfComputer.match(0, "D");
        assertThat(result).isFalse();
    }

}