package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;


class BridgeMakerTest {

    private static final String NOT_ACTION_INPUT = "[^(U | D)]";

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void 다리_크기_검증(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // when
        List<String> strings = bridgeMaker.makeBridge(size);
        // then
        Assertions.assertThat(strings.size()).isEqualTo(size);
    }

    @ValueSource(ints = {1, 2, 3, 4, 5})
    @ParameterizedTest
    void U_D_로만_구성되어야_한다(int size) {
        // given
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        // when
        List<String> strings = bridgeMaker.makeBridge(size);
        // then
        for (String string : strings) {
            Assertions.assertThat(string.matches(NOT_ACTION_INPUT)).isEqualTo(false);
        }
    }

}