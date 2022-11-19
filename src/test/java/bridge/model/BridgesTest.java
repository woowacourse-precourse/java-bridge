package bridge.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BridgesTest {

    @Test
    @DisplayName("다리 칸 비교 기능 테스트")
    void judgementBridgeSpace(){
        Bridges bridges = new Bridges(List.of("U", "D", "D"));

        assertThat(bridges.judgeMovement("U", 0)).isTrue();
        assertThat(bridges.judgeMovement("U", 1)).isFalse();
        assertThat(bridges.judgeMovement("D", 1)).isTrue();
    }

}