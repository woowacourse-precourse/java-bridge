package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> bridge = new ArrayList<>();

    @ParameterizedTest
    @DisplayName("0이면 D, 1이면 U 다리를 추가한다.")
    @CsvSource(value = {"0, D", "1, U"})
    void makeBridgeMovingByNumber(int number, String expected) {
        bridgeMaker.addBridgeMoving(bridge, number);
        assertThat(bridge).contains(expected);
    }

    @ParameterizedTest
    @DisplayName("다리 길이만큼 다리를 생성한다.")
    @ValueSource(ints = {0, 1, 10, 50})
    void makeBridgeAsIntegerSize(int size) {
        assertThat(bridgeMaker.makeBridge(size))
                .size()
                .isEqualTo(size);
    }
}
