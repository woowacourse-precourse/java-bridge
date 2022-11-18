package bridge;


import bridge.domain.Bridge;
import bridge.domain.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeTest {
    Bridge bridge;
    Player success;
    Player fail;

    @BeforeEach
    void setUp() {
        bridge = new Bridge(List.of("D", "U", "D", "U"));
        success = new Player();
        fail = new Player();
        List.of("D", "U").forEach(e -> success.inputDirection(e));
        List.of("D", "U", "D", "D").forEach(e -> fail.inputDirection(e));
    }

    @Test
    @DisplayName("플레이어와 입력과 같다면 true를 return한다.")
    void 플레이어와_입력이_같다면_정상_true() {
        assertThat(bridge.hasSameDirection(success)).isTrue();
    }

    @Test
    @DisplayName("플레이어와 입력과 같지 않다면 false를 return한다.")
    void 플레이어와_입력이_같지_않다면_false() {
        assertThat(bridge.hasSameDirection(fail)).isFalse();
    }
}
