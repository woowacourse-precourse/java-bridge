package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class bridgeTest {

    @Nested
    public class BridgeMakerTest {

        BridgeNumberGenerator bridgeNumberGenerator;
        BridgeMaker bridgeMaker;

        @BeforeEach
        void setUp() {
            bridgeNumberGenerator = new BridgeRandomNumberGenerator();
            bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        }

        @Test
        @DisplayName("다리 사이즈가 3 미만일 때 정상적으로 예외를 던지고 메시지를 출력하는지 테스트")
        void validateBridgeSizeIsFour() {
            assertThatThrownBy(() -> {
                List<String> itSupposedToThrowsException = bridgeMaker.makeBridge(2);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 다리 길이는 3부터");
        }

        @Test
        @DisplayName("다리 사이즈가 20 초과일 때 정상적으로 예외를 던지고 메시지를 출력하는지 테스트")
        void validateBridgeSizeIsTwentyOne() {
            assertThatThrownBy(() -> {
                List<String> itSupposedToThrowsException = bridgeMaker.makeBridge(21);
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 다리 길이는 3부터");
        }

        @Test
        @DisplayName("숫자만 정상적으로 받는지 테스트")
        void validateBridgeSizeIsNumberTest() {
            assertThatThrownBy(() -> {
                bridgeMaker.convertStringToInt("itCanNotBeConvertedToInt");
            }).isInstanceOf(IllegalArgumentException.class)
                    .hasMessageContaining("[ERROR] 숫자만 입력해주세요.");
        }
    }
}
