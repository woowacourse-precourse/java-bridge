package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.Validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.List;

class BridgeMakerTest {

    @DisplayName("다리 길이 입력시 숫자가 아닌 값이 입력되면 에러가 출력된다.")
    @ValueSource(strings = {"Z", "n", "%"})
    void bridgeLengthInputType(String command) {
        assertThatThrownBy(() -> Validator.validateInputBridgeSizeType(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 생성 시 U, D 값만 포함되어 있을 때 에러가 발생하지 않는다.")
    @Test
    void createRandomBridge() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);

        assertThat(bridge).contains("U", "D");
    }

    @DisplayName("다리 생성 시 U, D 이외의 값이 포함되어 있으면 에러가 발생한다.")
    @Test
    void checkRandomBridge() {
        assertThatThrownBy(()-> Validator.validateMovingWord("H"))
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
        assertThat(randomNumber).contains(0,1);
    }
}