package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("init 메서드가 게임을 정상적으로 초기화하는지 확인한다.")
    @Test
    void init_초기화_테스트() {
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
        assertThat(bridgeMaker.makeBridge(3)).containsOnly("U", "D");
    }

    @DisplayName("getUpOrDownWithNum 메서드가 0이면 D를 1이면 U를 반환하는지 확인한다.")
    @Test
    void getUpOrDownWithNum_테스트() {
        assertThat(bridgeMaker.getUpOrDownWithNum(0)).isEqualTo("U");
        assertThat(bridgeMaker.getUpOrDownWithNum(1)).isEqualTo("D");
    }
}
