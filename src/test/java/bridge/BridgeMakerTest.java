package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMakerTest {

    private BridgeMaker bridgeMaker;

    @BeforeEach
    void setUp() {
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @Nested
    @DisplayName("makeBridge 메서드는")
    class DescribeMakeBridge {

        @ParameterizedTest
        @ValueSource(ints = {0, -1})
        @DisplayName("1보다 작은 숫자를 인자를 받으면 IllegalArgumentException을 반환")
        void trowExceptionReceiveSmallerThenOne(int wrongSize) {
            //then
            Assertions.assertThatThrownBy(() -> bridgeMaker.makeBridge(wrongSize))
                    .isInstanceOf(IllegalArgumentException.class);
        }

        @ParameterizedTest
        @ValueSource(ints = {2, 10})
        @DisplayName("1보다 큰 숫자를 인자로 받으면 해당 숫자만큼의 U와 D로 이루어진 리스트를 반환한다.")
        void returnBridgeReceiveBiggerThenOne(int size) {
            //when
            List<String> actual = bridgeMaker.makeBridge(size);

            //then
            Assertions.assertThat(actual.size()).isEqualTo(size);
            Assertions.assertThat(actual).allMatch(sign -> sign.equals("U") || sign.equals("D"));
        }
    }
}