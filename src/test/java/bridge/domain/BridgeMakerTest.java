package bridge.domain;

import bridge.BridgeRandomNumberGenerator;
import bridge.Validator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;

class BridgeMakerTest {

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

    @DisplayName("숫자 생성시 0과 1만 출력되는 지 확인한다.")
    @Test
    void checkNumberGenerateIncludeZeroAndOne() {
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        HashSet<Integer> randomNumber = new HashSet<>();
        while (true) {
            if (randomNumber.size() == 2) {
                break;
            }
            randomNumber.add(bridgeRandomNumberGenerator.generate());
        }
        Assertions.assertThat(randomNumber).contains(0,1);
    }
}