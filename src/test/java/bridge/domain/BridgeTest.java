package bridge.domain;

import static bridge.domain.BridgeSize.MAX_SIZE;
import static bridge.domain.BridgeSize.MIN_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("Bridge를 생성할때")
    @Nested
    class Validate {

        @DisplayName("길이가 범위를 벗어날 경우 예외를 반환한다")
        @ValueSource(ints = {MIN_SIZE - 1, MAX_SIZE + 1})
        @ParameterizedTest
        void test1(int wrongSize) {
            assertThatThrownBy(() -> new Bridge(bridgeMaker.makeBridge(wrongSize)))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @DisplayName("잘못된 값을 가지고 있을 경우 예외를 반환한다.")
        @ValueSource(ints = {MIN_SIZE})
        @ParameterizedTest
        void test2(int rightSize) {
            List<String> blocks = bridgeMaker.makeBridge(rightSize);
            blocks.add("wrongValue");
            assertThatThrownBy(() -> new Bridge(blocks))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

}