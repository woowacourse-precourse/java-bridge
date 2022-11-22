package bridge.domain;

import bridge.domain.bridgenumber.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    @DisplayName("길이 입력 값 크기의 다리 만들기 성공")
    @Test
    void getRandomDirectionBridge() {
        int inputSize = 3;
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> result = bridgeMaker.makeBridge(inputSize);

        assertThat(result.size()).isEqualTo(inputSize);
    }
}
