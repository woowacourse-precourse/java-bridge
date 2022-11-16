package bridge;

import static bridge.constant.BridgeMove.DOWN;
import static bridge.constant.BridgeMove.UP;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BlockMakerTest {

    BlockMaker blockMaker;

    @BeforeEach
    void init() {
        blockMaker = new BlockMaker();
    }

    @ParameterizedTest
    @ValueSource(ints = {0})
    void makeBlockDownBlock(int bridgeNumber) {
        // when
        String block = blockMaker.makeBlock(bridgeNumber);

        // then
        assertThat(block).isEqualTo(DOWN.getFirstLetter());
    }

    @ParameterizedTest
    @ValueSource(ints = {1})
    void makeBlockUpBlock(int bridgeNumber) {
        // when
        String block = blockMaker.makeBlock(bridgeNumber);

        // then
        assertThat(block).isEqualTo(UP.getFirstLetter());
    }
}