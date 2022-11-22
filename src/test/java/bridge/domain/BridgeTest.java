package bridge.domain;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeTest {

    @Test
    void check_Bridge_Size_Test() {
        assertThat(Bridge.of(List.of("U", "D", "D", "U")).getSize()).isEqualTo(4);
    }

}