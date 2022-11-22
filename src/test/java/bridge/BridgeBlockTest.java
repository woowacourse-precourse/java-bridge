package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeBlockTest {

    @Test
    void 다리_블록_getter_테스트() {
        BridgeBlock upperBridgeBlock = BridgeBlock.getBridgeBlockType("U");
        BridgeBlock lowerBridgeBlock = BridgeBlock.getBridgeBlockType("D");

        assertThat(upperBridgeBlock).isEqualTo(BridgeBlock.UPPER_BLOCK);
        assertThat(lowerBridgeBlock).isEqualTo(BridgeBlock.LOWER_BLOCK);
    }
}