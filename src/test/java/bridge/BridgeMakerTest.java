package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @DisplayName("입력한 다리 길이만큼 다리가 만들어지는지 테스트")
    @ParameterizedTest
    @CsvSource({"3", "10", "20"})
    void bridgeSize(int bridgeSize) {
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        assertThat(bridge.size()).isEqualTo(bridgeSize);
    }

    @DisplayName("다리 정답 숫자를 문자로 잘 바꾸는지 테스트")
    @ParameterizedTest
    @CsvSource({"0,D", "1,U"})
    void decodeBridgeAnswer(int bridgeAnswerNumber, String bridgeAnswerCode) {
        String decoded = bridgeMaker.decodeBridgeAnswerNumber(bridgeAnswerNumber);
        assertThat(decoded).isEqualTo(bridgeAnswerCode);
    }
}