package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {
    private List<String> bridge;

    @BeforeEach
    void setUp() {
        bridge = new ArrayList<>();
    }

    @ParameterizedTest
    @MethodSource("returnNumberGenerator")
    void 숫자_0과1에_대응하는_칸을_추가하는지_테스트(BridgeNumberGenerator generator, String expected) {
        //given
        BridgeMaker maker = new BridgeMaker(generator);

        //when
        maker.appendBridge(bridge);

        //then
        assertThat(bridge).contains(expected);
    }

    static Stream<Arguments> returnNumberGenerator() {
        return Stream.of(
                arguments(new NumberZeroGenerator(), "D"),
                arguments(new NumberOneGenerator(), "U")
        );
    }

    @Test
    void 입력받은_크기만큼_다리를_생성하는지_테스트() {
        //given
        BridgeMaker maker = new BridgeMaker(new BridgeRandomNumberGenerator());

        //when
        bridge = maker.makeBridge(5);

        //then
        assertThat(bridge).hasSize(5);
    }
}
