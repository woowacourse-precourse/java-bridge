package bridge.domain.bridge;

import bridge.resource.ErrorMessage;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

//@TestInstance(TestInstance.Lifecycle.PER_CLASS)
class BridgeMakerTest {

//    BridgeNumberGenerator bridgeNumberGenerator;
//
//    @BeforeAll
//    void init() {
//        bridgeNumberGenerator = new BridgeRandomNumberGenerator();
//    }

    @DisplayName("다리 생성 테스트 성공")
    @Test
    void makeBridgeSuccess() {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        String size = "3";

        List<String> bridge = bridgeMaker.makeBridge(size);
        int count = bridge.size();
        int uCount = (int) bridge.stream().filter(b -> b.equals("U")).count();
        int dCount = (int) bridge.stream().filter(b -> b.equals("D")).count();

        assertThat(uCount + dCount).isEqualTo(count);
    }

    @DisplayName("다리 생성 테스트 실패 - 문자열을 입력받는 경우")
    @ValueSource(strings = {"가나다", "a", "dbfbe"})
    @ParameterizedTest
    void makeBridgeInputByString(String size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_INTEGER_OR_NUMBER_OUT_OF_RANGE_MESSAGE.getValue());
    }

    @DisplayName("다리 생성 테스트 실패 - 다리 길이가 3~20의 범위에 있지 않은 경우")
    @ValueSource(strings = {"1", "2", "21"})
    @ParameterizedTest
    void makeBridgeInputByOutOfBridgeLengthNumber(String size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ErrorMessage.NOT_BETWEEN_3_AND_20_MESSAGE.getValue());
    }
}