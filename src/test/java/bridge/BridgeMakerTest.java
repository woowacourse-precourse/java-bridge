package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {


    static BridgeMaker maker;

    @BeforeAll
    static void init() {
        maker = new BridgeMaker(() -> 1);
    }

    @DisplayName("길이에 맞는 다리를 생성한다.")
    @Test
    void makeBridge() {
        // given
        int size = 6;

        // when, then
        assertThat(maker.makeBridge(size).size()).isEqualTo(size);
    }

}
