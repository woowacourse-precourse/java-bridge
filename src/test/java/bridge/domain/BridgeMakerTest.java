package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

class BridgeMakerTest {

    @DisplayName("다리 길이 입력시 숫자가 아닌 값이 입력되면 에러가 출력된다.")
    @ValueSource(strings = {"Z", "n", "%"})
    void bridgeLengthInputType(String command) {
        Assertions.assertThatThrownBy(() -> Validator.validateInputBridgeSizeType(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 시 U, D 값만 포함되어 있는지 확인한다.")
    @Test
    void createRandomBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);

        Assertions.assertThat(bridge).contains("U", "D");
    }

    @DisplayName("다리 생성 시 U, D 이외의 값이 포함되어 있으면 에러가 발생한다.")
    @Test
    void checkRandomBridge() {
        Assertions.assertThatThrownBy(()-> Validator.validateMovingWord("H"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자 생성시 0과 1만 생성되면 정상적으로 출력된다.")
    @Test
    void checkNumberGenerateIncludeZeroAndOne() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        HashSet<Integer> randomNumber = new HashSet<>();
        while (randomNumber.size() != 2) {
            randomNumber.add(bridgeRandomNumberGenerator.generate());
        }
        Assertions.assertThat(randomNumber).contains(0,1);
    }
}