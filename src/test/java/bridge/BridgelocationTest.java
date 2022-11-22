package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.jupiter.api.Test;

class BridgelocationTest {

    @Test
    void 다리_위치_테스트() {
        assertThat(Bridgelocation.valueOf("U", true)).isEqualTo(Bridgelocation.UPO);
    }

}
