package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeMakerTest {

    private static final BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {

        @Test
        @DisplayName("허용된 사이즈의 최소값(3)보다 작은 값이 입력된다.")
        void inputSmallerThanMinimumSize() {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(2)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("허용된 사이즈의 최대값(20)보다 큰 값이 입력된다.")
        void inputBiggerThanMaximumSize() {
            assertThatThrownBy(() -> bridgeMaker.makeBridge(21)).isInstanceOf(IllegalArgumentException.class);
        }

        @Test
        @DisplayName("규격 외의 다리 종류가 존재한다.")
        void inputUnknownBridgeType() {
            BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator() {
                @Override
                public int generate() {
                    return Randoms.pickNumberInRange(10, 10);
                }
            };

            BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
            assertThatThrownBy(() -> bridgeMaker.makeBridge(5)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("정상 동작 테스트")
    class NormalTest {

        @Test
        @DisplayName("U, D 발판만 포함된 길이 3의 다리가 생성된다.")
        void createBridgeOf3() {
            List<String> bridge = bridgeMaker.makeBridge(3);
            assertThat(bridge.size()).isEqualTo(3);
            assertThat(bridge).containsAnyElementsOf(BridgeType.getNames());
        }

        @Test
        @DisplayName("U, D 발판만 포함된 길이 20의 다리가 생성된다.")
        void createBridgeOf20() {
            List<String> bridge = bridgeMaker.makeBridge(20);
            assertThat(bridge.size()).isEqualTo(20);
            assertThat(bridge).containsAnyElementsOf(BridgeType.getNames());
        }
    }
}
