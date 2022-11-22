package bridge;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.util.Lists.newArrayList;

class BridgeMakerTest {
    @Test
    void 다리를_생성한다() {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0, 1)));

        List<String> bridge = bridgeMaker.makeBridge(4);

        assertThat(bridge).containsExactly("U", "D", "D", "U");
    }

    @ValueSource(ints = {-1, 0, 2, 21})
    @ParameterizedTest
    void 다리의_길이는_3이상_20이하여야_한다(int size) {
        BridgeMaker bridgeMaker = new BridgeMaker(new TestNumberGenerator(newArrayList(1, 0, 0, 1)));

        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
