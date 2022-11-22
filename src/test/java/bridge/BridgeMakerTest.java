package bridge;

import static bridge.constant.BridgeMove.*;
import static org.assertj.core.api.Assertions.*;

import bridge.constant.BridgeMove;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    BridgeRandomNumberGenerator bridgeRandomNumberGenerator;
    BridgeMaker bridgeMaker;

    @BeforeEach
    void init() {
        bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    }

    @ParameterizedTest
    @ValueSource(ints = {3})
    void makeBridge(int size) {
        // when
        List<String> result = bridgeMaker.makeBridge(size);

        // then
        assertThat(result.size()).isEqualTo(size);
        assertThat(result).allMatch(s -> s.equals(DOWN.getFirstLetter()) || s.equals(UP.getFirstLetter()));
    }
}