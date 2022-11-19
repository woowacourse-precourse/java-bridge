package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {

    private static Collection<Arguments> param1() {
        return Arrays.asList(
            Arguments.of("size: 3", 3, List.of("D", "D", "D"), List.of(0, 0, 0)),
            Arguments.of("size: 3", 3, List.of("U", "U", "U"), List.of(1, 1, 1)),
            Arguments.of("size: 25", 25,
                List.of("U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U", "U",
                    "U", "U", "U", "U", "U", "U", "U", "U", "U", "U"),
                List.of(1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1))
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param1")
    @DisplayName("정상적인 사이즈를 입력받아 다리를 생성하는 테스트")
    void test1(String description, int size, List<String> expect, List<Integer> data) {
        BridgeNumberGeneratorMock mock = new BridgeNumberGeneratorMock(data);
        BridgeMaker bridgeMaker = new BridgeMaker(mock);
        List<String> bridge = bridgeMaker.makeBridge(size);
        Assertions.assertEquals(size, bridge.size());
        Assertions.assertEquals(expect, bridge);
    }

    private static Collection<Arguments> param2() {
        return Arrays.asList(
            Arguments.of("size: 2", 2, Collections.EMPTY_LIST),
            Arguments.of("size: 26", 26, Collections.EMPTY_LIST)
        );
    }

    @ParameterizedTest(name = "{index}: {0}")
    @MethodSource("param2")
    @DisplayName("비정상적인 사이즈를 입력받아 다리를 생성하는 테스트")
    void test2(String description, int size, List<Integer> data) {
        BridgeNumberGeneratorMock mock = new BridgeNumberGeneratorMock(data);
        BridgeMaker bridgeMaker = new BridgeMaker(mock);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size)).isInstanceOf(
            IllegalArgumentException.class).hasMessageContaining("[ERROR]");

    }
}
