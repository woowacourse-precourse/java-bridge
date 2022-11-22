package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BridgeMakerTest {


    @DisplayName("주어진 길이로 올바르게 다리 정보가 생성되는지 확인")
    @ValueSource(ints = {3, 9, 14, 19})
    @ParameterizedTest
    public void makeBridge(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(input))
                .hasSize(input)
                .containsAnyOf("U", "D");
    }

    @DisplayName("0 미만의 다리 길이가 주어졌을 때 예외 처리")
    @ValueSource(ints = {-1, -5, -3})
    @ParameterizedTest
    public void makeBridgeByLessThanOne(int input) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThatThrownBy(() -> bridgeMaker.makeBridge(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("0의 다리 길이가 주어졌을 때 빈 배열 반환하는지 확인")
    @Test
    public void makeBridgeByZeroSize() {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        assertThat(bridgeMaker.makeBridge(0)).hasSize(0);
    }

}
