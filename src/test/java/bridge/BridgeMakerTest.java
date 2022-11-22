package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Set;
import java.util.stream.IntStream;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    @DisplayName("다리의 길이를 입력 받아 U, D 만 포함한 다리를 생성한다")
    @ParameterizedTest
    @MethodSource("bridgeRange")
    void testMakeBridge(int size) {
        // given
        BridgeRandomNumberGenerator generator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(generator);;

        // when
        List<String> bridges = bridgeMaker.makeBridge(size);

        // then
        assertThat(bridges.size()).isEqualTo(size);
        assertThat(bridges).containsAnyOf("U", "D");
    }

    static IntStream bridgeRange() {
        return IntStream.range(3, 20);
    }
}
