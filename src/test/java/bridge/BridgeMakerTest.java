package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BridgeMakerTest {
    private static BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Test
    @DisplayName("생성자 인수에 Null이 입력되면 예외 발생")
    void constructorTest() {
        assertThatThrownBy(() -> new BridgeMaker(null))
                .isInstanceOf(NullPointerException.class)
                .hasMessageContaining("BridgeNumberGenerator는 Null이 될 수 없습니다.");
    }

    @ParameterizedTest(name = "입력한 다리의 길이만큼 다리를 생성한다")
    @MethodSource
    void makeBridge(int size) {
        List<String> moves = bridgeMaker.makeBridge(size);
        assertThat(moves.size()).isEqualTo(size);
    }

    private static Stream<Arguments> makeBridge() {
        return Stream.of(
                Arguments.of(3),
                Arguments.of(4),
                Arguments.of(5),
                Arguments.of(2)
        );
    }


}