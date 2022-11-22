package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BridgeMakerTest {
    BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    public void 다리길이만큼_다리블록_생성하기() throws Exception {
        //given
        int size = 10;

        //when
        List<String> bridgeBlocks = maker.makeBridge(size);

        //then
        assertThat(bridgeBlocks.size()).isEqualTo(size);
        assertThat(!bridgeBlocks.containsAll(List.of("U", "D"))).isEqualTo(false);
    }
}