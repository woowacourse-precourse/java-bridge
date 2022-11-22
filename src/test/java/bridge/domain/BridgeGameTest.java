package bridge.domain;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    @Test
    void 이동한_칸이_U이고_맞으면_true() {
        List<String> bridge = List.of("U");
        BridgeGame b = new BridgeGame(bridge);
        boolean isSuccess = b.move("U", 0);
        assertThat(isSuccess).isEqualTo(true);
    }

    @Test
    void 이동한_칸이_U이고_틀리면_false() {
        List<String> bridge = List.of("D");
        BridgeGame b = new BridgeGame(bridge);
        boolean isSuccess = b.move("U", 0);
        assertThat(isSuccess).isEqualTo(false);
    }

}