package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.utils.common.BridgeConst;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {

    private BridgeNumberGenerator generator = new BridgeRandomNumberGenerator();

    @Nested
    @DisplayName("generate 메소드는")
    class DescribeGenerateMethodTest {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @RepeatedTest(10)
            @DisplayName("지정한 범위 내의 랜덤한 숫자를 생성해 반환한다")
            void it_returns_randomNumber() {
                int actual = generator.generate();

                assertThat(actual)
                        .isLessThanOrEqualTo(BridgeConst.UP_TILE_VALUE)
                        .isGreaterThanOrEqualTo(BridgeConst.DOWN_TILE_VALUE);
            }
        }
    }
}
