package bridge.test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import bridge.model.Bridgelocation;
import org.junit.jupiter.api.Test;

class BridgelocationTest {

    @Test
    void 다리_위치_테스트() {
        assertThat(Bridgelocation.valueOf("U", true)).isEqualTo(Bridgelocation.UPO);
    }

    @Test
    void 다리_위치_예외_테스트() {
        assertThat(Bridgelocation.valueOf("x", true)).isEqualTo(Bridgelocation.ERROR);
    }

}
