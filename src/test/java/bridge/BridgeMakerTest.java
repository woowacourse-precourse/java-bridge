package bridge;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeMakerTest {
    @DisplayName("다리 길이가 3미만 일 경우 예외 처리한다.")
    @ValueSource(ints = {2, 1, 0, -5, -7777})
    @ParameterizedTest
    void bridgeSizeLessThanThree(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 20초과 일 경우 예외 처리한다.")
    @ValueSource(ints = {21, 25, 300, 40000})
    @ParameterizedTest
    void bridgeSizeGreaterThanTwenty(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThatThrownBy(() -> bridgeMaker.makeBridge(size))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이가 3이상 20이하 일 경우 정상 처리한다.")
    @ValueSource(ints = {3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20})
    @ParameterizedTest
    void bridgeSizeValidRange(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        assertThat(bridgeMaker.makeBridge(size).size()).isEqualTo(size);
    }
}
